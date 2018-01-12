/* 
 * PDF
 *
 * The PDF conversion API 'conversion2pdf' converts image, office and PDF files to (searcheable) PDF files.    The flow is generally as follows:  1. First create a job using the /conversion2pdf/jobs POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload one or more images/files using the /conversion2pdf/jobs/{jobId}/streams/multipart POST endpoint. You can also add stream locations from the storage API . You will get back the update job response that contains a job with its associated settings. Currently you can only merge spreadsheets with spreadsheet, documents with documents and images/pdfs with images/pdfs  3. Start the job from a PUT request to the /conversion2pdf/jobs/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start. The OCR setting is only applicable to images, since other files will always be searchable.  4. Check the job status from the /conversion2pdf/jobs/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /conversion2pdf/jobs/{jobid}/streams/result GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      Interactive testing: A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.1
 * Contact: dev@sphereon.com
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 */

using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using System.ComponentModel.DataAnnotations;
using SwaggerDateConverter = Sphereon.SDK.Pdf.Client.SwaggerDateConverter;

namespace Sphereon.SDK.Pdf.Model
{
    /// <summary>
    /// Conversion settings
    /// </summary>
    [DataContract]
    public partial class ConversionSettings :  IEquatable<ConversionSettings>
    {
        /// <summary>
        /// Gets or Sets Engine
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum EngineEnum
        {
            
            /// <summary>
            /// Enum BASIC for "BASIC"
            /// </summary>
            [EnumMember(Value = "BASIC")]
            BASIC,
            
            /// <summary>
            /// Enum ADVANCED for "ADVANCED"
            /// </summary>
            [EnumMember(Value = "ADVANCED")]
            ADVANCED,
            
            /// <summary>
            /// Enum PREMIUM for "PREMIUM"
            /// </summary>
            [EnumMember(Value = "PREMIUM")]
            PREMIUM
        }

        /// <summary>
        /// Gets or Sets ContainerConversion
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum ContainerConversionEnum
        {
            
            /// <summary>
            /// Enum ALL for "ALL"
            /// </summary>
            [EnumMember(Value = "ALL")]
            ALL,
            
            /// <summary>
            /// Enum MAIN for "MAIN"
            /// </summary>
            [EnumMember(Value = "MAIN")]
            MAIN,
            
            /// <summary>
            /// Enum SUB for "SUB"
            /// </summary>
            [EnumMember(Value = "SUB")]
            SUB
        }

        /// <summary>
        /// The PDF version to use for conversion
        /// </summary>
        /// <value>The PDF version to use for conversion</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum VersionEnum
        {
            
            /// <summary>
            /// Enum _14 for "PDF_1_4"
            /// </summary>
            [EnumMember(Value = "PDF_1_4")]
            _14,
            
            /// <summary>
            /// Enum _15 for "PDF_1_5"
            /// </summary>
            [EnumMember(Value = "PDF_1_5")]
            _15,
            
            /// <summary>
            /// Enum _16 for "PDF_1_6"
            /// </summary>
            [EnumMember(Value = "PDF_1_6")]
            _16,
            
            /// <summary>
            /// Enum _17 for "PDF_1_7"
            /// </summary>
            [EnumMember(Value = "PDF_1_7")]
            _17,
            
            /// <summary>
            /// Enum A1b for "PDF_A_1b"
            /// </summary>
            [EnumMember(Value = "PDF_A_1b")]
            A1b
        }

        /// <summary>
        /// Gets or Sets OcrMode
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum OcrModeEnum
        {
            
            /// <summary>
            /// Enum ALWAYS for "ALWAYS"
            /// </summary>
            [EnumMember(Value = "ALWAYS")]
            ALWAYS,
            
            /// <summary>
            /// Enum NEVER for "NEVER"
            /// </summary>
            [EnumMember(Value = "NEVER")]
            NEVER,
            
            /// <summary>
            /// Enum AUTO for "AUTO"
            /// </summary>
            [EnumMember(Value = "AUTO")]
            AUTO
        }

        /// <summary>
        /// Gets or Sets Engine
        /// </summary>
        [DataMember(Name="engine", EmitDefaultValue=false)]
        public EngineEnum? Engine { get; set; }
        /// <summary>
        /// Gets or Sets ContainerConversion
        /// </summary>
        [DataMember(Name="containerConversion", EmitDefaultValue=false)]
        public ContainerConversionEnum? ContainerConversion { get; set; }
        /// <summary>
        /// The PDF version to use for conversion
        /// </summary>
        /// <value>The PDF version to use for conversion</value>
        [DataMember(Name="version", EmitDefaultValue=false)]
        public VersionEnum? Version { get; set; }
        /// <summary>
        /// Gets or Sets OcrMode
        /// </summary>
        [DataMember(Name="ocrMode", EmitDefaultValue=false)]
        public OcrModeEnum? OcrMode { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="ConversionSettings" /> class.
        /// </summary>
        /// <param name="QualityFactor">Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest).</param>
        /// <param name="Result">Result.</param>
        /// <param name="Input">Input.</param>
        /// <param name="Engine">Engine.</param>
        /// <param name="Csv">Csv.</param>
        /// <param name="ContainerConversion">ContainerConversion.</param>
        /// <param name="Version">The PDF version to use for conversion.</param>
        /// <param name="JobLifecycle">The lifecycle of the job itself.</param>
        /// <param name="OcrMode">OcrMode.</param>
        public ConversionSettings(int? QualityFactor = default(int?), ResultSettings Result = default(ResultSettings), InputSettings Input = default(InputSettings), EngineEnum? Engine = default(EngineEnum?), CSVSettings Csv = default(CSVSettings), ContainerConversionEnum? ContainerConversion = default(ContainerConversionEnum?), VersionEnum? Version = default(VersionEnum?), Lifecycle JobLifecycle = default(Lifecycle), OcrModeEnum? OcrMode = default(OcrModeEnum?))
        {
            this.QualityFactor = QualityFactor;
            this.Result = Result;
            this.Input = Input;
            this.Engine = Engine;
            this.Csv = Csv;
            this.ContainerConversion = ContainerConversion;
            this.Version = Version;
            this.JobLifecycle = JobLifecycle;
            this.OcrMode = OcrMode;
        }
        
        /// <summary>
        /// Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest)
        /// </summary>
        /// <value>Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest)</value>
        [DataMember(Name="qualityFactor", EmitDefaultValue=false)]
        public int? QualityFactor { get; set; }

        /// <summary>
        /// Gets or Sets Result
        /// </summary>
        [DataMember(Name="result", EmitDefaultValue=false)]
        public ResultSettings Result { get; set; }

        /// <summary>
        /// Gets or Sets Input
        /// </summary>
        [DataMember(Name="input", EmitDefaultValue=false)]
        public InputSettings Input { get; set; }


        /// <summary>
        /// Gets or Sets Csv
        /// </summary>
        [DataMember(Name="csv", EmitDefaultValue=false)]
        public CSVSettings Csv { get; set; }



        /// <summary>
        /// The lifecycle of the job itself
        /// </summary>
        /// <value>The lifecycle of the job itself</value>
        [DataMember(Name="jobLifecycle", EmitDefaultValue=false)]
        public Lifecycle JobLifecycle { get; set; }


        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class ConversionSettings {\n");
            sb.Append("  QualityFactor: ").Append(QualityFactor).Append("\n");
            sb.Append("  Result: ").Append(Result).Append("\n");
            sb.Append("  Input: ").Append(Input).Append("\n");
            sb.Append("  Engine: ").Append(Engine).Append("\n");
            sb.Append("  Csv: ").Append(Csv).Append("\n");
            sb.Append("  ContainerConversion: ").Append(ContainerConversion).Append("\n");
            sb.Append("  Version: ").Append(Version).Append("\n");
            sb.Append("  JobLifecycle: ").Append(JobLifecycle).Append("\n");
            sb.Append("  OcrMode: ").Append(OcrMode).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }
  
        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="obj">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object obj)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            return this.Equals(obj as ConversionSettings);
        }

        /// <summary>
        /// Returns true if ConversionSettings instances are equal
        /// </summary>
        /// <param name="other">Instance of ConversionSettings to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(ConversionSettings other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.QualityFactor == other.QualityFactor ||
                    this.QualityFactor != null &&
                    this.QualityFactor.Equals(other.QualityFactor)
                ) && 
                (
                    this.Result == other.Result ||
                    this.Result != null &&
                    this.Result.Equals(other.Result)
                ) && 
                (
                    this.Input == other.Input ||
                    this.Input != null &&
                    this.Input.Equals(other.Input)
                ) && 
                (
                    this.Engine == other.Engine ||
                    this.Engine != null &&
                    this.Engine.Equals(other.Engine)
                ) && 
                (
                    this.Csv == other.Csv ||
                    this.Csv != null &&
                    this.Csv.Equals(other.Csv)
                ) && 
                (
                    this.ContainerConversion == other.ContainerConversion ||
                    this.ContainerConversion != null &&
                    this.ContainerConversion.Equals(other.ContainerConversion)
                ) && 
                (
                    this.Version == other.Version ||
                    this.Version != null &&
                    this.Version.Equals(other.Version)
                ) && 
                (
                    this.JobLifecycle == other.JobLifecycle ||
                    this.JobLifecycle != null &&
                    this.JobLifecycle.Equals(other.JobLifecycle)
                ) && 
                (
                    this.OcrMode == other.OcrMode ||
                    this.OcrMode != null &&
                    this.OcrMode.Equals(other.OcrMode)
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            // credit: http://stackoverflow.com/a/263416/677735
            unchecked // Overflow is fine, just wrap
            {
                int hash = 41;
                // Suitable nullity checks etc, of course :)
                if (this.QualityFactor != null)
                    hash = hash * 59 + this.QualityFactor.GetHashCode();
                if (this.Result != null)
                    hash = hash * 59 + this.Result.GetHashCode();
                if (this.Input != null)
                    hash = hash * 59 + this.Input.GetHashCode();
                if (this.Engine != null)
                    hash = hash * 59 + this.Engine.GetHashCode();
                if (this.Csv != null)
                    hash = hash * 59 + this.Csv.GetHashCode();
                if (this.ContainerConversion != null)
                    hash = hash * 59 + this.ContainerConversion.GetHashCode();
                if (this.Version != null)
                    hash = hash * 59 + this.Version.GetHashCode();
                if (this.JobLifecycle != null)
                    hash = hash * 59 + this.JobLifecycle.GetHashCode();
                if (this.OcrMode != null)
                    hash = hash * 59 + this.OcrMode.GetHashCode();
                return hash;
            }
        }

    }

}
