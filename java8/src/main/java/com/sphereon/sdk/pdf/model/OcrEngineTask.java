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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * OcrEngineTask
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-01T18:16:14.907+01:00")
public class OcrEngineTask   {
  @SerializedName("documentId")
  private String documentId = null;

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

  @SerializedName("images")
  private List<String> images = new ArrayList<String>();

  @SerializedName("jobId")
  private String jobId = null;

  @SerializedName("queueId")
  private String queueId = null;

  /**
   * The status of the Ocr engine task itself
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

  @SerializedName("url")
  private String url = null;

   /**
   * The document Id provided by a backend system
   * @return documentId
  **/
  @ApiModelProperty(example = "null", value = "The document Id provided by a backend system")
  public String getDocumentId() {
    return documentId;
  }

   /**
   * The Engine being used
   * @return engine
  **/
  @ApiModelProperty(example = "null", value = "The Engine being used")
  public EngineEnum getEngine() {
    return engine;
  }

  public OcrEngineTask images(List<String> images) {
    this.images = images;
    return this;
  }

  public OcrEngineTask addImagesItem(String imagesItem) {
    this.images.add(imagesItem);
    return this;
  }

   /**
   * The names of the supplied images
   * @return images
  **/
  @ApiModelProperty(example = "null", value = "The names of the supplied images")
  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

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
   * The status of the Ocr engine task itself
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "The status of the Ocr engine task itself")
  public StatusEnum getStatus() {
    return status;
  }

   /**
   * The URL on the bucketstore for the PDF. Only available once the status is DONE
   * @return url
  **/
  @ApiModelProperty(example = "null", value = "The URL on the bucketstore for the PDF. Only available once the status is DONE")
  public String getUrl() {
    return url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OcrEngineTask ocrEngineTask = (OcrEngineTask) o;
    return Objects.equals(this.documentId, ocrEngineTask.documentId) &&
        Objects.equals(this.engine, ocrEngineTask.engine) &&
        Objects.equals(this.images, ocrEngineTask.images) &&
        Objects.equals(this.jobId, ocrEngineTask.jobId) &&
        Objects.equals(this.queueId, ocrEngineTask.queueId) &&
        Objects.equals(this.status, ocrEngineTask.status) &&
        Objects.equals(this.url, ocrEngineTask.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documentId, engine, images, jobId, queueId, status, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OcrEngineTask {\n");
    
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    queueId: ").append(toIndentedString(queueId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

