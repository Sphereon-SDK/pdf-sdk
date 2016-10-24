using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sphereon.SDK.Pdf.Converter
{
    class Program
    {
        static void Main(string[] args)
        {
            Conversion conversion = new Conversion();
            conversion.Image2PDF(@"c:\sucimages\1.tiff");
        }
    }
}
