using System.Management.Automation;

namespace Convert2PDFLib
{
    [Cmdlet(VerbsCommon.Get, "ConvertAsPDF")]
    [OutputType(typeof(string))]
    public class Convert2PdfCmdlet : Cmdlet
    {
        private Convert2Pdf _convert2Pdf;

        [Parameter(Position = 1, Mandatory = true)]
        [Alias("inFile", "in")]
        public string InputFileName { get; set; }


        [Parameter(Position = 2, Mandatory = true)]
        [Alias("outFile", "out")]
        public string OutputFileName { get; set; }

        [Parameter(Position = 3, Mandatory = true)]
        [Alias("token")]
        public string AccessToken
        {
            set
            {
                _convert2Pdf.SetAccessToken(value);
            }
        }

        [Parameter(Position = 4, Mandatory = false)]
        public string OcrMode {
            set
            {
                _convert2Pdf.SetOcrMode(value);
            }
        }

        [Parameter(Position = 5, Mandatory = false)]
        public string Engine { 
            set
            {
              _convert2Pdf.SetEngine(value);  
            }
        }

        [Parameter(Position = 6, Mandatory = false)]
        [Alias("ct")]
        public string CompressionType { 
            set
            {
              _convert2Pdf.SetCompressionType(value);  
            }
        }

        [Parameter(Position = 7, Mandatory = false)]
        [Alias("cl")]
        public int CompressionLevel { 
            set
            {
              _convert2Pdf.SetCompressionLevel(value);  
            }
        }

        [Parameter(Position = 8, Mandatory = false)]
        [Alias("qf")]
        public int QualityFactor
        {
            set
            {
                _convert2Pdf.SetQualityFactor(value);
            }
        }

        public Convert2PdfCmdlet()
        {
            _convert2Pdf = new Convert2Pdf();
        }

        protected override void ProcessRecord()
        {
            base.ProcessRecord();
            _convert2Pdf.Convert(InputFileName, OutputFileName);
        }
    }
}
