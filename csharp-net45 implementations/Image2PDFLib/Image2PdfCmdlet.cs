using System.Management.Automation;

namespace Image2PDFLib
{
    [Cmdlet(VerbsCommon.Get, "ImageAsPDF")]
    [OutputType(typeof(string))]
    public class Image2PdfCmdlet : Cmdlet
    {
        private Image2Pdf _image2Pdf;

        [Parameter(Position = 1, Mandatory = true)]
        [Alias("inFile", "in")]
        public string ImageFileName { get; set; }


        [Parameter(Position = 2, Mandatory = true)]
        [Alias("outFile", "out")]
        public string OutputFileName { get; set; }

        [Parameter(Position = 3, Mandatory = true)]
        [Alias("token")]
        public string AccessToken
        {
            set
            {
                _image2Pdf.SetAccessToken(value);
            }
        }

        [Parameter(Position = 4, Mandatory = false)]
        public bool Ocr {
            set
            {
                _image2Pdf.SetOcr(value);
            }
        }

        [Parameter(Position = 5, Mandatory = false)]
        public string Engine { 
            set
            {
              _image2Pdf.SetEngine(value);  
            }
        }

        [Parameter(Position = 6, Mandatory = false)]
        [Alias("ct")]
        public string CompressionType { 
            set
            {
              _image2Pdf.SetCompressionType(value);  
            }
        }

        [Parameter(Position = 7, Mandatory = false)]
        [Alias("cl")]
        public int CompressionLevel { 
            set
            {
              _image2Pdf.SetCompressionLevel(value);  
            }
        }

        [Parameter(Position = 8, Mandatory = false)]
        [Alias("qf")]
        public int QualityFactor
        {
            set
            {
                _image2Pdf.SetQualityFactor(value);
            }
        }

        public Image2PdfCmdlet()
        {
            _image2Pdf = new Image2Pdf();
        }

        protected override void ProcessRecord()
        {
            base.ProcessRecord();
            _image2Pdf.Convert(ImageFileName, OutputFileName);
        }
    }
}
