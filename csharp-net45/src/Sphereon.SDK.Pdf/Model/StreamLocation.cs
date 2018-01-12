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
    /// Location record of data stream
    /// </summary>
    [DataContract]
    public partial class StreamLocation :  IEquatable<StreamLocation>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="StreamLocation" /> class.
        /// </summary>
        /// <param name="FolderPath">FolderPath.</param>
        /// <param name="Filename">Filename.</param>
        /// <param name="Name">Name.</param>
        /// <param name="ContainerId">ContainerId.</param>
        /// <param name="OriginalFilename">OriginalFilename.</param>
        public StreamLocation(string FolderPath = default(string), string Filename = default(string), string Name = default(string), string ContainerId = default(string), string OriginalFilename = default(string))
        {
            this.FolderPath = FolderPath;
            this.Filename = Filename;
            this.Name = Name;
            this.ContainerId = ContainerId;
            this.OriginalFilename = OriginalFilename;
        }
        
        /// <summary>
        /// Gets or Sets FolderPath
        /// </summary>
        [DataMember(Name="folderPath", EmitDefaultValue=false)]
        public string FolderPath { get; set; }

        /// <summary>
        /// Gets or Sets Filename
        /// </summary>
        [DataMember(Name="filename", EmitDefaultValue=false)]
        public string Filename { get; set; }

        /// <summary>
        /// Gets or Sets Name
        /// </summary>
        [DataMember(Name="name", EmitDefaultValue=false)]
        public string Name { get; set; }

        /// <summary>
        /// Gets or Sets Id
        /// </summary>
        [DataMember(Name="id", EmitDefaultValue=false)]
        public string Id { get; private set; }

        /// <summary>
        /// Gets or Sets ContainerId
        /// </summary>
        [DataMember(Name="containerId", EmitDefaultValue=false)]
        public string ContainerId { get; set; }

        /// <summary>
        /// Gets or Sets OriginalFilename
        /// </summary>
        [DataMember(Name="originalFilename", EmitDefaultValue=false)]
        public string OriginalFilename { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class StreamLocation {\n");
            sb.Append("  FolderPath: ").Append(FolderPath).Append("\n");
            sb.Append("  Filename: ").Append(Filename).Append("\n");
            sb.Append("  Name: ").Append(Name).Append("\n");
            sb.Append("  Id: ").Append(Id).Append("\n");
            sb.Append("  ContainerId: ").Append(ContainerId).Append("\n");
            sb.Append("  OriginalFilename: ").Append(OriginalFilename).Append("\n");
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
            return this.Equals(obj as StreamLocation);
        }

        /// <summary>
        /// Returns true if StreamLocation instances are equal
        /// </summary>
        /// <param name="other">Instance of StreamLocation to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(StreamLocation other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.FolderPath == other.FolderPath ||
                    this.FolderPath != null &&
                    this.FolderPath.Equals(other.FolderPath)
                ) && 
                (
                    this.Filename == other.Filename ||
                    this.Filename != null &&
                    this.Filename.Equals(other.Filename)
                ) && 
                (
                    this.Name == other.Name ||
                    this.Name != null &&
                    this.Name.Equals(other.Name)
                ) && 
                (
                    this.Id == other.Id ||
                    this.Id != null &&
                    this.Id.Equals(other.Id)
                ) && 
                (
                    this.ContainerId == other.ContainerId ||
                    this.ContainerId != null &&
                    this.ContainerId.Equals(other.ContainerId)
                ) && 
                (
                    this.OriginalFilename == other.OriginalFilename ||
                    this.OriginalFilename != null &&
                    this.OriginalFilename.Equals(other.OriginalFilename)
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
                if (this.FolderPath != null)
                    hash = hash * 59 + this.FolderPath.GetHashCode();
                if (this.Filename != null)
                    hash = hash * 59 + this.Filename.GetHashCode();
                if (this.Name != null)
                    hash = hash * 59 + this.Name.GetHashCode();
                if (this.Id != null)
                    hash = hash * 59 + this.Id.GetHashCode();
                if (this.ContainerId != null)
                    hash = hash * 59 + this.ContainerId.GetHashCode();
                if (this.OriginalFilename != null)
                    hash = hash * 59 + this.OriginalFilename.GetHashCode();
                return hash;
            }
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            yield break;
        }
    }

}
