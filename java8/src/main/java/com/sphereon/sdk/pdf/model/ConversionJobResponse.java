/**
 * PDF 
 * <b>The PDF conversion API 'conversion2pdf' converts image, office and PDF files to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First upload an image/file using the /conversion2pdf POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload any additional images/files using the /conversion2pdf/{jobId} POST endpoint when you want to merge additional image, office or PDF files. You will get back the update job response that contains a job with its associated settings. Currently you can only merge spreadsheets with spreadsheet, documents with documents and images/pdfs with images/pdfs  3. Start the job from a PUT request to the /conversion2pdf/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start. The OCR setting is only applicable to images, since other files will always be searchable.  4. Check the job status from the /conversion2pdf/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /conversion2pdf/{jobid}/stream GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0.0
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
import com.sphereon.sdk.pdf.model.ConversionJob;
import com.sphereon.sdk.pdf.model.ConversionTask;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * The PDF job. Has access to the job settings as well as ocr engine tasks
 */
@ApiModel(description = "The PDF job. Has access to the job settings as well as ocr engine tasks")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-01-24T13:42:36.462+01:00")
public class ConversionJobResponse   {
  @SerializedName("completionTime")
  private OffsetDateTime completionTime = null;

  @SerializedName("jobId")
  private String jobId = null;

  @SerializedName("creationTime")
  private OffsetDateTime creationTime = null;

  @SerializedName("inputs")
  private List<String> inputs = new ArrayList<String>();

  @SerializedName("conversionTasks")
  private List<ConversionTask> conversionTasks = new ArrayList<ConversionTask>();

  @SerializedName("updateTime")
  private OffsetDateTime updateTime = null;

  @SerializedName("job")
  private ConversionJob job = null;

  @SerializedName("statusMessage")
  private String statusMessage = null;

  @SerializedName("queueTime")
  private OffsetDateTime queueTime = null;

  /**
   * The status of the job
   */
  public enum StatusEnum {
    @SerializedName("INPUTS_UPLOADED")
    INPUTS_UPLOADED("INPUTS_UPLOADED"),
    
    @SerializedName("PROCESSING")
    PROCESSING("PROCESSING"),
    
    @SerializedName("DONE")
    DONE("DONE"),
    
    @SerializedName("ERROR")
    ERROR("ERROR"),
    
    @SerializedName("DELETED")
    DELETED("DELETED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

   /**
   * The completion date/time of this job in ISO 8601 format
   * @return completionTime
  **/
  @ApiModelProperty(example = "null", value = "The completion date/time of this job in ISO 8601 format")
  public OffsetDateTime getCompletionTime() {
    return completionTime;
  }

  public ConversionJobResponse jobId(String jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * Get jobId
   * @return jobId
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

   /**
   * The creation date/time of this job in ISO 8601 format
   * @return creationTime
  **/
  @ApiModelProperty(example = "null", value = "The creation date/time of this job in ISO 8601 format")
  public OffsetDateTime getCreationTime() {
    return creationTime;
  }

  public ConversionJobResponse inputs(List<String> inputs) {
    this.inputs = inputs;
    return this;
  }

  public ConversionJobResponse addInputsItem(String inputsItem) {
    this.inputs.add(inputsItem);
    return this;
  }

   /**
   * The original input files. Currently supported inputs are: inputs, pdfs and office files
   * @return inputs
  **/
  @ApiModelProperty(example = "null", required = true, value = "The original input files. Currently supported inputs are: inputs, pdfs and office files")
  public List<String> getInputs() {
    return inputs;
  }

  public void setInputs(List<String> inputs) {
    this.inputs = inputs;
  }

  public ConversionJobResponse conversionTasks(List<ConversionTask> conversionTasks) {
    this.conversionTasks = conversionTasks;
    return this;
  }

  public ConversionJobResponse addConversionTasksItem(ConversionTask conversionTasksItem) {
    this.conversionTasks.add(conversionTasksItem);
    return this;
  }

   /**
   * Get conversionTasks
   * @return conversionTasks
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ConversionTask> getConversionTasks() {
    return conversionTasks;
  }

  public void setConversionTasks(List<ConversionTask> conversionTasks) {
    this.conversionTasks = conversionTasks;
  }

   /**
   * The last update date/time of this job in ISO 8601 format
   * @return updateTime
  **/
  @ApiModelProperty(example = "null", value = "The last update date/time of this job in ISO 8601 format")
  public OffsetDateTime getUpdateTime() {
    return updateTime;
  }

  public ConversionJobResponse job(ConversionJob job) {
    this.job = job;
    return this;
  }

   /**
   * Get job
   * @return job
  **/
  @ApiModelProperty(example = "null", value = "")
  public ConversionJob getJob() {
    return job;
  }

  public void setJob(ConversionJob job) {
    this.job = job;
  }

   /**
   * A status message, which can be informational, warning or error. AA message here does not indicate an error perse
   * @return statusMessage
  **/
  @ApiModelProperty(example = "null", value = "A status message, which can be informational, warning or error. AA message here does not indicate an error perse")
  public String getStatusMessage() {
    return statusMessage;
  }

   /**
   * The conversion queue date/time of this job in ISO 8601 format
   * @return queueTime
  **/
  @ApiModelProperty(example = "null", value = "The conversion queue date/time of this job in ISO 8601 format")
  public OffsetDateTime getQueueTime() {
    return queueTime;
  }

   /**
   * The status of the job
   * @return status
  **/
  @ApiModelProperty(example = "null", required = true, value = "The status of the job")
  public StatusEnum getStatus() {
    return status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversionJobResponse conversionJobResponse = (ConversionJobResponse) o;
    return Objects.equals(this.completionTime, conversionJobResponse.completionTime) &&
        Objects.equals(this.jobId, conversionJobResponse.jobId) &&
        Objects.equals(this.creationTime, conversionJobResponse.creationTime) &&
        Objects.equals(this.inputs, conversionJobResponse.inputs) &&
        Objects.equals(this.conversionTasks, conversionJobResponse.conversionTasks) &&
        Objects.equals(this.updateTime, conversionJobResponse.updateTime) &&
        Objects.equals(this.job, conversionJobResponse.job) &&
        Objects.equals(this.statusMessage, conversionJobResponse.statusMessage) &&
        Objects.equals(this.queueTime, conversionJobResponse.queueTime) &&
        Objects.equals(this.status, conversionJobResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(completionTime, jobId, creationTime, inputs, conversionTasks, updateTime, job, statusMessage, queueTime, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionJobResponse {\n");
    
    sb.append("    completionTime: ").append(toIndentedString(completionTime)).append("\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    conversionTasks: ").append(toIndentedString(conversionTasks)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    job: ").append(toIndentedString(job)).append("\n");
    sb.append("    statusMessage: ").append(toIndentedString(statusMessage)).append("\n");
    sb.append("    queueTime: ").append(toIndentedString(queueTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

