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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * ConversionTask
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-08-14T16:34:03.653+02:00")
public class ConversionTask   {
  @SerializedName("jobId")
  private String jobId = null;

  @SerializedName("queueId")
  private String queueId = null;

  /**
   * The Engine being used
   */
  public enum EngineEnum {
    @SerializedName("ADVANCED")
    ADVANCED("ADVANCED"),
    
    @SerializedName("PREMIUM")
    PREMIUM("PREMIUM"),
    
    @SerializedName("BASIC")
    BASIC("BASIC");

    private String value;

    EngineEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("engine")
  private EngineEnum engine = null;

  @SerializedName("inputs")
  private List<String> inputs = new ArrayList<String>();

  @SerializedName("documentId")
  private String documentId = null;

  /**
   * The status of the Conversion task itself
   */
  public enum StatusEnum {
    @SerializedName("REQUESTED")
    REQUESTED("REQUESTED"),
    
    @SerializedName("QUEUED")
    QUEUED("QUEUED"),
    
    @SerializedName("PROCESSING")
    PROCESSING("PROCESSING"),
    
    @SerializedName("DONE")
    DONE("DONE"),
    
    @SerializedName("ERROR")
    ERROR("ERROR");

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
   * The current job Id
   * @return jobId
  **/
  @ApiModelProperty(example = "null", value = "The current job Id")
  public String getJobId() {
    return jobId;
  }

   /**
   * The queue Id provided by a backend system
   * @return queueId
  **/
  @ApiModelProperty(example = "null", value = "The queue Id provided by a backend system")
  public String getQueueId() {
    return queueId;
  }

   /**
   * The Engine being used
   * @return engine
  **/
  @ApiModelProperty(example = "null", value = "The Engine being used")
  public EngineEnum getEngine() {
    return engine;
  }

  public ConversionTask inputs(List<String> inputs) {
    this.inputs = inputs;
    return this;
  }

  public ConversionTask addInputsItem(String inputsItem) {
    this.inputs.add(inputsItem);
    return this;
  }

   /**
   * The names of the supplied files/inputs
   * @return inputs
  **/
  @ApiModelProperty(example = "null", value = "The names of the supplied files/inputs")
  public List<String> getInputs() {
    return inputs;
  }

  public void setInputs(List<String> inputs) {
    this.inputs = inputs;
  }

   /**
   * The document Id provided by a backend system
   * @return documentId
  **/
  @ApiModelProperty(example = "null", value = "The document Id provided by a backend system")
  public String getDocumentId() {
    return documentId;
  }

   /**
   * The status of the Conversion task itself
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "The status of the Conversion task itself")
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
    ConversionTask conversionTask = (ConversionTask) o;
    return Objects.equals(this.jobId, conversionTask.jobId) &&
        Objects.equals(this.queueId, conversionTask.queueId) &&
        Objects.equals(this.engine, conversionTask.engine) &&
        Objects.equals(this.inputs, conversionTask.inputs) &&
        Objects.equals(this.documentId, conversionTask.documentId) &&
        Objects.equals(this.status, conversionTask.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, queueId, engine, inputs, documentId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionTask {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    queueId: ").append(toIndentedString(queueId)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
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

