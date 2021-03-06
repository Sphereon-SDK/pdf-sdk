﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CommandLine;
using CommandLine.Text;
using Convert2PDFLib;

namespace Convert2PDF_command
{
    class Options
    {
        [Option('i', "inFile", Required = true, HelpText = "Input image file to be converterd.")]
        public string InFile { get; set; }

        [Option('p', "pdfFile", Required = true, HelpText = "Output PDF file")]
        public string OutFile { get; set; }

        [Option('t', "accessToken", Required = true, HelpText = "API access token")]
        public string AccessToken { get; set; }

        [Option('q', "qualityFactor", DefaultValue = 10, Required = false, HelpText = "Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest)")]
        public int QualityFactor { get; set; }


        [Option('o', "ocr", DefaultValue = true, HelpText = "Whether to perform OCR. When set to false the text in the PDF will not be searchable. Possible values: ALWAYS,NEVER,AUTO")]
        public string OcrMode { get; set; }

        [Option('e', "engine", Required = false, DefaultValue = "BASIC", HelpText = "Specify OCR engine BASIC|ADVANCED|PREMIUM")]
        public string Engine { get; set; }

        [Option('c', "compressionType", Required = false, DefaultValue = "ADVANCED", HelpText = "Compression type NONE|ADVANCED. ADVANCED is only allowed and should be used with the ADVANCED engine.")]
        public string CompressionType { get; set; }

        [Option('l', "compressionLevel", DefaultValue=2, Required = false, HelpText = "Compression level. Valid range from 0 (minimal compression) to 10 (maximal compression)")]
        public int CompressionLevel { get; set; }


        [ParserState]
        public IParserState LastParserState { get; set; }

        [HelpOption]
        public string GetUsage()
        {
            return HelpText.AutoBuild(this, current => HelpText.DefaultParsingErrorsHandler(this, current));
        }
    }


    public class Program
    {
        static void Main(string[] args)
        {
            var options = new Options();
            if (Parser.Default.ParseArguments(args, options))
            {
                var convert2Pdf = new Convert2Pdf();
                convert2Pdf.SetAccessToken(options.AccessToken);
                convert2Pdf.SetQualityFactor(options.QualityFactor);
                convert2Pdf.SetOcrMode(options.OcrMode);
                convert2Pdf.SetEngine(options.Engine);
                convert2Pdf.SetCompressionType(options.CompressionType);
                convert2Pdf.SetCompressionLevel(options.CompressionLevel);
                convert2Pdf.Convert(options.InFile, options.OutFile);
            }
        }
    }
}
