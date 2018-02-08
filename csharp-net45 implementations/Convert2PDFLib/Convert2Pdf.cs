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

        private readonly Conversion2PDFApi _api;

        private readonly ConversionSettings _settings;


        public Convert2Pdf()
        {
            _api = new Conversion2PDFApi();
            _settings = new ConversionSettings
            {
                OcrMode = ConversionSettings.OcrModeEnum.AUTO,
                Engine = ConversionSettings.EngineEnum.BASIC,
                Result = new ResultSettings(FileFormat: ResultSettings.FileFormatEnum.PDF,
                Compression: new Compression(1, Compression.TypeEnum.NONE)),
                QualityFactor = 255
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
            _settings.QualityFactor = value;
        }

        private void InitCompression() {
            if (_settings.Result.Compression == null)
                _settings.Result.Compression = new Compression();
        }

        
        [ComVisible(true)]
        public void SetCompressionType(string value)
        {
            Compression.TypeEnum compressionType;
            Enum.TryParse(value, out compressionType);
            InitCompression();
            _settings.Result.Compression.Type = compressionType;

        }

        [ComVisible(true)]
        public void SetCompressionLevel(int value)
        {
            InitCompression();
            _settings.Result.Compression.Level = value;
        }

        [ComVisible(true)]
        public void SetOcrMode(string value)
        {
            ConversionSettings.OcrModeEnum ocrModeEnum;
            Enum.TryParse(value, out ocrModeEnum);
            _settings.OcrMode = ocrModeEnum;            
        }


        [ComVisible(true)]
        public void SetEngine(string value)
        {
            ConversionSettings.EngineEnum engine;
            Enum.TryParse(value, out engine);
            _settings.Engine = engine;
        }


        [ComVisible(true)]
        public void Convert(string inFile, string outFile)
        {
            var jobResponse = CreateJob();
            jobResponse = Upload(inFile, jobResponse.JobId);
            string jobId = jobResponse.JobId;
            var pdfJob = jobResponse.Job;
            pdfJob.Settings = _settings;    
            jobResponse = _api.SubmitJob(jobId, pdfJob);
            CheckStatus(jobResponse);
            WaitProcessing(jobId);
            WritePdf(outFile, jobId); 
        }

        private ConversionJobResponse CreateJob() {
            var conversionJobResponse = _api.CreateJob(_settings);
            if (conversionJobResponse.Status == ConversionJobResponse.StatusEnum.ERROR) {
                throw new Exception("CreateJob failed: " + conversionJobResponse.StatusMessage);
            }
            return conversionJobResponse;
        }

        public Configuration Configuration => _api.Configuration;

        private ConversionJobResponse Upload(string inFile, string jobId)
        {
            ConversionJobResponse response;
            using (var fileStream = File.OpenRead(inFile))
            {
                response = _api.AddInputFile(jobId, fileStream);
                if (response.Status == null || response.Status.Value != ConversionJobResponse.StatusEnum.INPUTSUPLOADED)
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
                if (response.Status != ConversionJobResponse.StatusEnum.PROCESSING)
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



        private static void CheckStatus(ConversionJobResponse response)
        {
            if (response.Status != null &&
                (response.Status.Value == ConversionJobResponse.StatusEnum.ERROR || response.Status.Value == ConversionJobResponse.StatusEnum.DELETED))
            {
                throw new Exception($"convert2pdf conversion job {response.JobId} returned an invalid status code {response.Status} with message {response.StatusMessage}");
            }
        }
    }
}