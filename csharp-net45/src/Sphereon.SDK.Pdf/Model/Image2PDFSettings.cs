/* 
 * Sphereon :: DOC :: PDF
 *
 * <b>The PDF conversion API 'image2pdf' converts images to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First upload an image using the /image2pdf POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload any additional images using the /image2pdf/{jobId} POST endpoint when you want to merge additional images or PDFs. You will get back the update job response that contains a job with its associated settings.  3. Start the job from a PUT request to the /image2pdf/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start  4. Check the job status from the /image2pdf/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /image2pdf/{jobid}/stream GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 0.1.5
 * Contact: dev@sphereon.com
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;

namespace Sphereon.SDK.Pdf.Model
{
    /// <summary>
    /// Image to PDF settings
    /// </summary>
    [DataContract]
    public partial class Image2PDFSettings :  IEquatable<Image2PDFSettings>
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
        /// Gets or Sets Version
        /// </summary>
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
        /// Gets or Sets Engine
        /// </summary>
        [DataMember(Name="engine", EmitDefaultValue=false)]
        public EngineEnum? Engine { get; set; }
        /// <summary>
        /// Gets or Sets Version
        /// </summary>
        [DataMember(Name="version", EmitDefaultValue=false)]
        public VersionEnum? Version { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Image2PDFSettings" /> class.
        /// </summary>
        /// <param name="Lifecycle">Lifecycle.</param>
        /// <param name="QualityFactor">Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest).</param>
        /// <param name="ResultFileName">ResultFileName.</param>
        /// <param name="Links">Links.</param>
        /// <param name="Engine">Engine.</param>
        /// <param name="Compression">Compression.</param>
        /// <param name="Version">Version.</param>
        /// <param name="Ocr">Whether to perform OCR. When set to false the text in the PDF will not be searchable.</param>
        public Image2PDFSettings(Lifecycle Lifecycle = null, int? QualityFactor = null, string ResultFileName = null, Dictionary<string, Link> Links = null, EngineEnum? Engine = null, Compression Compression = null, VersionEnum? Version = null, bool? Ocr = null)
        {
            this.Lifecycle = Lifecycle;
            this.QualityFactor = QualityFactor;
            this.ResultFileName = ResultFileName;
            this.Links = Links;
            this.Engine = Engine;
            this.Compression = Compression;
            this.Version = Version;
            this.Ocr = Ocr;
        }
        
        /// <summary>
        /// Gets or Sets Lifecycle
        /// </summary>
        [DataMember(Name="lifecycle", EmitDefaultValue=false)]
        public Lifecycle Lifecycle { get; set; }
        /// <summary>
        /// Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest)
        /// </summary>
        /// <value>Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest)</value>
        [DataMember(Name="qualityFactor", EmitDefaultValue=false)]
        public int? QualityFactor { get; set; }
        /// <summary>
        /// Gets or Sets ResultFileName
        /// </summary>
        [DataMember(Name="resultFileName", EmitDefaultValue=false)]
        public string ResultFileName { get; set; }
        /// <summary>
        /// Gets or Sets Links
        /// </summary>
        [DataMember(Name="_links", EmitDefaultValue=false)]
        public Dictionary<string, Link> Links { get; set; }
        /// <summary>
        /// Gets or Sets Compression
        /// </summary>
        [DataMember(Name="compression", EmitDefaultValue=false)]
        public Compression Compression { get; set; }
        /// <summary>
        /// Whether to perform OCR. When set to false the text in the PDF will not be searchable
        /// </summary>
        /// <value>Whether to perform OCR. When set to false the text in the PDF will not be searchable</value>
        [DataMember(Name="ocr", EmitDefaultValue=false)]
        public bool? Ocr { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Image2PDFSettings {\n");
            sb.Append("  Lifecycle: ").Append(Lifecycle).Append("\n");
            sb.Append("  QualityFactor: ").Append(QualityFactor).Append("\n");
            sb.Append("  ResultFileName: ").Append(ResultFileName).Append("\n");
            sb.Append("  Links: ").Append(Links).Append("\n");
            sb.Append("  Engine: ").Append(Engine).Append("\n");
            sb.Append("  Compression: ").Append(Compression).Append("\n");
            sb.Append("  Version: ").Append(Version).Append("\n");
            sb.Append("  Ocr: ").Append(Ocr).Append("\n");
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
            return this.Equals(obj as Image2PDFSettings);
        }

        /// <summary>
        /// Returns true if Image2PDFSettings instances are equal
        /// </summary>
        /// <param name="other">Instance of Image2PDFSettings to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Image2PDFSettings other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Lifecycle == other.Lifecycle ||
                    this.Lifecycle != null &&
                    this.Lifecycle.Equals(other.Lifecycle)
                ) && 
                (
                    this.QualityFactor == other.QualityFactor ||
                    this.QualityFactor != null &&
                    this.QualityFactor.Equals(other.QualityFactor)
                ) && 
                (
                    this.ResultFileName == other.ResultFileName ||
                    this.ResultFileName != null &&
                    this.ResultFileName.Equals(other.ResultFileName)
                ) && 
                (
                    this.Links == other.Links ||
                    this.Links != null &&
                    this.Links.SequenceEqual(other.Links)
                ) && 
                (
                    this.Engine == other.Engine ||
                    this.Engine != null &&
                    this.Engine.Equals(other.Engine)
                ) && 
                (
                    this.Compression == other.Compression ||
                    this.Compression != null &&
                    this.Compression.Equals(other.Compression)
                ) && 
                (
                    this.Version == other.Version ||
                    this.Version != null &&
                    this.Version.Equals(other.Version)
                ) && 
                (
                    this.Ocr == other.Ocr ||
                    this.Ocr != null &&
                    this.Ocr.Equals(other.Ocr)
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
                if (this.Lifecycle != null)
                    hash = hash * 59 + this.Lifecycle.GetHashCode();
                if (this.QualityFactor != null)
                    hash = hash * 59 + this.QualityFactor.GetHashCode();
                if (this.ResultFileName != null)
                    hash = hash * 59 + this.ResultFileName.GetHashCode();
                if (this.Links != null)
                    hash = hash * 59 + this.Links.GetHashCode();
                if (this.Engine != null)
                    hash = hash * 59 + this.Engine.GetHashCode();
                if (this.Compression != null)
                    hash = hash * 59 + this.Compression.GetHashCode();
                if (this.Version != null)
                    hash = hash * 59 + this.Version.GetHashCode();
                if (this.Ocr != null)
                    hash = hash * 59 + this.Ocr.GetHashCode();
                return hash;
            }
        }
    }

}
