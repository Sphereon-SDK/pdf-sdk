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
    /// An error
    /// </summary>
    [DataContract]
    public partial class Error :  IEquatable<Error>
    {
        /// <summary>
        /// Gets or Sets Level
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum LevelEnum
        {
            
            /// <summary>
            /// Enum INFO for "INFO"
            /// </summary>
            [EnumMember(Value = "INFO")]
            INFO,
            
            /// <summary>
            /// Enum WARNING for "WARNING"
            /// </summary>
            [EnumMember(Value = "WARNING")]
            WARNING,
            
            /// <summary>
            /// Enum FATAL for "FATAL"
            /// </summary>
            [EnumMember(Value = "FATAL")]
            FATAL
        }

        /// <summary>
        /// Gets or Sets Level
        /// </summary>
        [DataMember(Name="level", EmitDefaultValue=false)]
        public LevelEnum? Level { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Error" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Error() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Error" /> class.
        /// </summary>
        /// <param name="Code">Code (required).</param>
        /// <param name="Level">Level (required).</param>
        /// <param name="Cause">Cause.</param>
        /// <param name="Message">Message (required).</param>
        public Error(string Code = null, LevelEnum? Level = null, Error Cause = null, string Message = null)
        {
            // to ensure "Code" is required (not null)
            if (Code == null)
            {
                throw new InvalidDataException("Code is a required property for Error and cannot be null");
            }
            else
            {
                this.Code = Code;
            }
            // to ensure "Level" is required (not null)
            if (Level == null)
            {
                throw new InvalidDataException("Level is a required property for Error and cannot be null");
            }
            else
            {
                this.Level = Level;
            }
            // to ensure "Message" is required (not null)
            if (Message == null)
            {
                throw new InvalidDataException("Message is a required property for Error and cannot be null");
            }
            else
            {
                this.Message = Message;
            }
            this.Cause = Cause;
        }
        
        /// <summary>
        /// Gets or Sets Code
        /// </summary>
        [DataMember(Name="code", EmitDefaultValue=false)]
        public string Code { get; set; }
        /// <summary>
        /// Gets or Sets Cause
        /// </summary>
        [DataMember(Name="cause", EmitDefaultValue=false)]
        public Error Cause { get; set; }
        /// <summary>
        /// Gets or Sets Message
        /// </summary>
        [DataMember(Name="message", EmitDefaultValue=false)]
        public string Message { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Error {\n");
            sb.Append("  Code: ").Append(Code).Append("\n");
            sb.Append("  Level: ").Append(Level).Append("\n");
            sb.Append("  Cause: ").Append(Cause).Append("\n");
            sb.Append("  Message: ").Append(Message).Append("\n");
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
            return this.Equals(obj as Error);
        }

        /// <summary>
        /// Returns true if Error instances are equal
        /// </summary>
        /// <param name="other">Instance of Error to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Error other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Code == other.Code ||
                    this.Code != null &&
                    this.Code.Equals(other.Code)
                ) && 
                (
                    this.Level == other.Level ||
                    this.Level != null &&
                    this.Level.Equals(other.Level)
                ) && 
                (
                    this.Cause == other.Cause ||
                    this.Cause != null &&
                    this.Cause.Equals(other.Cause)
                ) && 
                (
                    this.Message == other.Message ||
                    this.Message != null &&
                    this.Message.Equals(other.Message)
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
                if (this.Code != null)
                    hash = hash * 59 + this.Code.GetHashCode();
                if (this.Level != null)
                    hash = hash * 59 + this.Level.GetHashCode();
                if (this.Cause != null)
                    hash = hash * 59 + this.Cause.GetHashCode();
                if (this.Message != null)
                    hash = hash * 59 + this.Message.GetHashCode();
                return hash;
            }
        }
    }

}
