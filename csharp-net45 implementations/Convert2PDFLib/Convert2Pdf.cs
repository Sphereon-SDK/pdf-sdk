using System;
using System.IO;
using System.Runtime.InteropServices;
using System.Threading;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

/**
 * Register using c:\Windows\Microsoft.NET\Framework64\v4.0.30319\RegAsm.exe /codebase Convert2PDFLib.dll  (Framework without 64 on x86 systems)
 */
namespace Convert2PDFLib
{ 
    [Guid("20E44D9D-8F66-46E8-B048-D8E1AB516230")]
    [ComVisible(true)]
    [ProgId("Convert2PDFLib.Convert2Pdf")]
    public class Convert2Pdf
    {
        
        private const string BasePath = "https://gw.api.cloud.sphereon.com";

        private readonly ConversionPDFApi _api;

        private ConversionSettings settings;


        public Convert2Pdf()
        {
            _api = new ConversionPDFApi();
            settings = new ConversionSettings
            {
                Ocr = true,
                Engine = ConversionSettings.EngineEnum.BASIC,
                Lifecycle = new Lifecycle(null, null, Lifecycle.TypeEnum.TIME)
            };
        }

        [ComVisible(true)]
        public void SetAccessToken(string accessToken)
        {
            _api.Configuration.AccessToken = accessToken;
        }

        [ComVisible(true)]
        public void SetQualityFactor(int value)
        {
            settings.QualityFactor = value;
        }


        [ComVisible(true)]
        public void SetCompressionType(string value)
        {
            Compression.TypeEnum compressionType;
            Enum.TryParse(value, out compressionType);
            if(settings.Compression == null)
                settings.Compression = new Compression();
            settings.Compression.Type = compressionType;

        }

        [ComVisible(true)]
        public void SetCompressionLevel(int value)
        {
            if (settings.Compression == null)
                settings.Compression = new Compression();
            settings.Compression.Level = value;
        }

        [ComVisible(true)]
        public void SetOcr(bool value)
        {
            settings.Ocr = value;            
        }


        [ComVisible(true)]
        public void SetEngine(string value)
        {
            ConversionSettings.EngineEnum engine;
            Enum.TryParse(value, out engine);
            settings.Engine = engine;
        }


        [ComVisible(true)]
        public void Convert(string inFile, string outFile)
        {
            var jobResponse = Upload(inFile);
            string jobId = jobResponse.JobId;
            var pdfJob = jobResponse.Job;
            pdfJob.Settings = settings;    
            jobResponse = _api.SubmitJob(jobId, pdfJob);
            CheckStatus(jobResponse);
            WaitProcessing(jobId);
            WritePdf(outFile, jobId); 
        }

        public Configuration Configuration => _api.Configuration;

        private PDFJobResponse Upload(string inFile)
        {
            PDFJobResponse response;
            using (var fileStream = File.OpenRead(inFile))
            {
                response = _api.UploadFile(fileStream);
                if (response.Status == null || response.Status.Value != PDFJobResponse.StatusEnum.INPUTSUPLOADED)
                    throw new Exception(response.StatusMessage);
            }
            return response;
        }


        private void WaitProcessing(string jobId)
        {
            while (true)
            {
                var response = _api.GetJob(jobId);
                CheckStatus(response);
                if (response.Status != PDFJobResponse.StatusEnum.PROCESSING)
                    break;
                Thread.Sleep(2000);
            }
        }

        private void WritePdf(string outFile, string jobId)
        {
            using (var fileStream = File.OpenWrite(outFile))
            {
                var data = _api.GetStream(jobId);
                fileStream.Write(data, 0, data.Length);
            }
        }



        private static void CheckStatus(PDFJobResponse response)
        {
            if (response.Status != null &&
                (response.Status.Value == PDFJobResponse.StatusEnum.ERROR || response.Status.Value == PDFJobResponse.StatusEnum.DELETED))
            {
                throw new Exception($"convert2pdf conversion job {response.JobId} returned an invalid status code {response.Status} with message {response.StatusMessage}");
            }
        }

    }
}