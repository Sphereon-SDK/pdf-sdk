/**
 * Sphereon :: DOC :: PDF
 * <b>The PDF conversion API 'image2pdf' converts images to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First upload an image using the /image2pdf POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload any additional images using the /image2pdf/{jobId} POST endpoint when you want to merge additional images or PDFs. You will get back the update job response that contains a job with its associated settings.  3. Start the job from a PUT request to the /image2pdf/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start  4. Check the job status from the /image2pdf/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /image2pdf/{jobid}/stream GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 0.1.5
 * Contact: dev@sphereon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.sphereon.sdk.pdf.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import com.sphereon.sdk.pdf.model.Image2PDFSettings;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * The PDF job. Has access to the job settings.
 */
@ApiModel(description = "The PDF job. Has access to the job settings.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-03T12:07:24.493+01:00")
public class PDFJob   {
  @SerializedName("jobId")
  private String jobId = null;

  @SerializedName("settings")
  private Image2PDFSettings settings = null;

  public PDFJob jobId(String jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * The server generated job jobId. This jobId is checked against the jobId in the request path on overy invocation
   * @return jobId
  **/
  @ApiModelProperty(example = "null", required = true, value = "The server generated job jobId. This jobId is checked against the jobId in the request path on overy invocation")
  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public PDFJob settings(Image2PDFSettings settings) {
    this.settings = settings;
    return this;
  }

   /**
   * Get settings
   * @return settings
  **/
  @ApiModelProperty(example = "null", value = "")
  public Image2PDFSettings getSettings() {
    return settings;
  }

  public void setSettings(Image2PDFSettings settings) {
    this.settings = settings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PDFJob pDFJob = (PDFJob) o;
    return Objects.equals(this.jobId, pDFJob.jobId) &&
        Objects.equals(this.settings, pDFJob.settings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, settings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PDFJob {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

