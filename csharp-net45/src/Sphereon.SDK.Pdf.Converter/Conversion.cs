using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sphereon.SDK.Pdf.Converter
{
    class Conversion
    {
        private ImagePDFApi imagePDFApi;

        public Conversion()
        {
            Configuration.Default.Username = Properties.Settings.Default.Username;
            Configuration.Default.Password = Properties.Settings.Default.Password;
            Configuration.Default.AccessToken = Properties.Settings.Default.AccessToken;
            Configuration.Default.Timeout = 1000 * Properties.Settings.Default.Timeout;
            Configuration.Default.UserAgent = "Image2PDF Conversion client";

            Configuration.Default.ApiClient = new ApiClient(Properties.Settings.Default.URL);
            imagePDFApi = new ImagePDFApi(Configuration.Default);
        }
        
        public void Image2PDF(string imagePath)
        {
            if (!File.Exists(imagePath))
            {
                throw new FileNotFoundException("Image file not found", imagePath);
            }

            Stream imageStream = File.OpenRead(imagePath);
            ApiResponse<Model.PDFJobResponse> uploadResponse = imagePDFApi.UploadImageWithHttpInfo(imageStream);
            AssertValidHttpStatus(uploadResponse);

            Model.PDFJobResponse pdfJobResponse = uploadResponse.Data;
            ApiResponse<Model.PDFJobResponse> submitResponse = imagePDFApi.SubmitJobWithHttpInfo(pdfJobResponse.JobId, pdfJobResponse.Job);
            AssertValidHttpStatus(submitResponse);

            int count = 0;
            ApiResponse<Model.PDFJobResponse> statusResponse = null;
            while (count < Properties.Settings.Default.Timeout && pdfJobResponse.Status != Model.PDFJobResponse.StatusEnum.DONE && pdfJobResponse.Status != Model.PDFJobResponse.StatusEnum.ERROR)
            {
                System.Threading.Thread.Sleep(1000);
                count++;
                statusResponse = imagePDFApi.GetJobWithHttpInfo(pdfJobResponse.JobId);
                AssertValidHttpStatus(statusResponse);
                pdfJobResponse = statusResponse.Data;
            }

            if (pdfJobResponse.Status != Model.PDFJobResponse.StatusEnum.DONE)
            {
                throw new ApiException(statusResponse.StatusCode, String.Format("PDF Job {0} had invalid status {1} after {2} seconds", pdfJobResponse.JobId, pdfJobResponse.Status, Properties.Settings.Default.Timeout));
            }
            File.WriteAllText(@"c:\sucimages\out.pdf", imagePDFApi.GetStream(pdfJobResponse.JobId));

        }




        private static void AssertValidHttpStatus(ApiResponse<Model.PDFJobResponse> uploadResponse)
        {
            if (uploadResponse.StatusCode >= 300)
            {
                throw new Exception("Server returned error " + uploadResponse.StatusCode);
            }
        }
    }
}
