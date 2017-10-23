/* 
 * PDF
 *
 * <b>The PDF conversion API 'conversion2pdf' converts image, office and PDF files to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First create a job using the /conversion2pdf/jobs POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload one or more images/files using the /conversion2pdf/jobs/{jobId}/streams/multipart POST endpoint. You can also add stream locations from the storage API . You will get back the update job response that contains a job with its associated settings. Currently you can only merge spreadsheets with spreadsheet, documents with documents and images/pdfs with images/pdfs  3. Start the job from a PUT request to the /conversion2pdf/jobs/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start. The OCR setting is only applicable to images, since other files will always be searchable.  4. Check the job status from the /conversion2pdf/jobs/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /conversion2pdf/jobs/{jobid}/streams/result GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.1
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
    /// Result settings
    /// </summary>
    [DataContract]
    public partial class ResultSettings :  IEquatable<ResultSettings>
    {
        /// <summary>
        /// Gets or Sets FileFormat
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum FileFormatEnum
        {
            
            /// <summary>
            /// Enum TIFF for "TIFF"
            /// </summary>
            [EnumMember(Value = "TIFF")]
            TIFF,
            
            /// <summary>
            /// Enum PDF for "PDF"
            /// </summary>
            [EnumMember(Value = "PDF")]
            PDF,
            
            /// <summary>
            /// Enum XLSX for "XLSX"
            /// </summary>
            [EnumMember(Value = "XLSX")]
            XLSX,
            
            /// <summary>
            /// Enum DOCX for "DOCX"
            /// </summary>
            [EnumMember(Value = "DOCX")]
            DOCX
        }

        /// <summary>
        /// Gets or Sets FileFormat
        /// </summary>
        [DataMember(Name="fileFormat", EmitDefaultValue=false)]
        public FileFormatEnum? FileFormat { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="ResultSettings" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected ResultSettings() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="ResultSettings" /> class.
        /// </summary>
        /// <param name="Lifecycle">Lifecycle.</param>
        /// <param name="StorageLocation">Result Storage location.</param>
        /// <param name="Compression">Compression.</param>
        /// <param name="FileFormat">FileFormat (required).</param>
        public ResultSettings(Lifecycle Lifecycle = null, StorageLocation StorageLocation = null, Compression Compression = null, FileFormatEnum? FileFormat = null)
        {
            // to ensure "FileFormat" is required (not null)
            if (FileFormat == null)
            {
                throw new InvalidDataException("FileFormat is a required property for ResultSettings and cannot be null");
            }
            else
            {
                this.FileFormat = FileFormat;
            }
            this.Lifecycle = Lifecycle;
            this.StorageLocation = StorageLocation;
            this.Compression = Compression;
        }
        
        /// <summary>
        /// Gets or Sets Lifecycle
        /// </summary>
        [DataMember(Name="lifecycle", EmitDefaultValue=false)]
        public Lifecycle Lifecycle { get; set; }
        /// <summary>
        /// Result Storage location
        /// </summary>
        /// <value>Result Storage location</value>
        [DataMember(Name="storageLocation", EmitDefaultValue=false)]
        public StorageLocation StorageLocation { get; set; }
        /// <summary>
        /// Gets or Sets Compression
        /// </summary>
        [DataMember(Name="compression", EmitDefaultValue=false)]
        public Compression Compression { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class ResultSettings {\n");
            sb.Append("  Lifecycle: ").Append(Lifecycle).Append("\n");
            sb.Append("  StorageLocation: ").Append(StorageLocation).Append("\n");
            sb.Append("  Compression: ").Append(Compression).Append("\n");
            sb.Append("  FileFormat: ").Append(FileFormat).Append("\n");
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
            return this.Equals(obj as ResultSettings);
        }

        /// <summary>
        /// Returns true if ResultSettings instances are equal
        /// </summary>
        /// <param name="other">Instance of ResultSettings to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(ResultSettings other)
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
                    this.StorageLocation == other.StorageLocation ||
                    this.StorageLocation != null &&
                    this.StorageLocation.Equals(other.StorageLocation)
                ) && 
                (
                    this.Compression == other.Compression ||
                    this.Compression != null &&
                    this.Compression.Equals(other.Compression)
                ) && 
                (
                    this.FileFormat == other.FileFormat ||
                    this.FileFormat != null &&
                    this.FileFormat.Equals(other.FileFormat)
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
                if (this.StorageLocation != null)
                    hash = hash * 59 + this.StorageLocation.GetHashCode();
                if (this.Compression != null)
                    hash = hash * 59 + this.Compression.GetHashCode();
                if (this.FileFormat != null)
                    hash = hash * 59 + this.FileFormat.GetHashCode();
                return hash;
            }
        }
    }

}
