/**
 * PDF 
 * <b>The PDF conversion API 'conversion2pdf' converts image, office and PDF files to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First upload an image/file using the /conversion2pdf POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload any additional images/files using the /conversion2pdf/{jobId} POST endpoint when you want to merge additional image, office or PDF files. You will get back the update job response that contains a job with its associated settings. Currently you can only merge spreadsheets with spreadsheet, documents with documents and images/pdfs with images/pdfs  3. Start the job from a PUT request to the /conversion2pdf/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start. The OCR setting is only applicable to images, since other files will always be searchable.  4. Check the job status from the /conversion2pdf/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /conversion2pdf/{jobid}/stream GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0
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
import com.sphereon.sdk.pdf.model.ConversionSettings;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * The PDF conversion job. Has access to the job settings.
 */
@ApiModel(description = "The PDF conversion job. Has access to the job settings.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-07-11T20:01:51.608+02:00")
public class ConversionJob   {
  @SerializedName("jobId")
  private String jobId = null;

  @SerializedName("settings")
  private ConversionSettings settings = null;

  public ConversionJob jobId(String jobId) {
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

  public ConversionJob settings(ConversionSettings settings) {
    this.settings = settings;
    return this;
  }

   /**
   * Get settings
   * @return settings
  **/
  @ApiModelProperty(example = "null", value = "")
  public ConversionSettings getSettings() {
    return settings;
  }

  public void setSettings(ConversionSettings settings) {
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
    ConversionJob conversionJob = (ConversionJob) o;
    return Objects.equals(this.jobId, conversionJob.jobId) &&
        Objects.equals(this.settings, conversionJob.settings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, settings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionJob {\n");
    
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

