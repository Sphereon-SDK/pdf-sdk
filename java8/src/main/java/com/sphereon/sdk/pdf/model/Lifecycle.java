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
import java.time.OffsetDateTime;


/**
 * Lifecycle settings. When no lifecycle settings are supplied, the job and files will be deleted directly after retrieval of the file
 */
@ApiModel(description = "Lifecycle settings. When no lifecycle settings are supplied, the job and files will be deleted directly after retrieval of the file")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-11-03T12:07:24.493+01:00")
public class Lifecycle   {
  /**
   * Gets or Sets action
   */
  public enum ActionEnum {
    @SerializedName("DELETE")
    DELETE("DELETE");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("action")
  private ActionEnum action = null;

  @SerializedName("actionTime")
  private OffsetDateTime actionTime = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    @SerializedName("RETRIEVAL")
    RETRIEVAL("RETRIEVAL"),
    
    @SerializedName("TIME")
    TIME("TIME");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;

  public Lifecycle action(ActionEnum action) {
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @ApiModelProperty(example = "null", value = "")
  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public Lifecycle actionTime(OffsetDateTime actionTime) {
    this.actionTime = actionTime;
    return this;
  }

   /**
   * The time at which the job and files will be deleted, regardless of whether it has been retrieved or not. Maximal time is 1 day from job creation
   * @return actionTime
  **/
  @ApiModelProperty(example = "null", value = "The time at which the job and files will be deleted, regardless of whether it has been retrieved or not. Maximal time is 1 day from job creation")
  public OffsetDateTime getActionTime() {
    return actionTime;
  }

  public void setActionTime(OffsetDateTime actionTime) {
    this.actionTime = actionTime;
  }

  public Lifecycle type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(example = "null", value = "")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lifecycle lifecycle = (Lifecycle) o;
    return Objects.equals(this.action, lifecycle.action) &&
        Objects.equals(this.actionTime, lifecycle.actionTime) &&
        Objects.equals(this.type, lifecycle.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, actionTime, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lifecycle {\n");
    
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    actionTime: ").append(toIndentedString(actionTime)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

