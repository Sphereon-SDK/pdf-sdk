/**
 * Sphereon :: DOC :: PDF
 * <b>The PDF conversion API 'image2pdf' converts images to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First upload an image using the /image2pdf POST endpoint. You will get back a response that contains a job with its associated settings.  2. Start the job from a PUT request to the /image2pdf/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start  3. Check the job status from the /image2pdf/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the PDF file using the /image2pdf/{jobid}/stream GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 0.1.4
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
import com.sphereon.sdk.pdf.model.Compression;
import com.sphereon.sdk.pdf.model.Lifecycle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Image to PDF settings
 */
@ApiModel(description = "Image to PDF settings")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-09-30T08:40:04.477+02:00")
public class Image2PDFSettings   {
  @SerializedName("compression")
  private Compression compression = null;

  /**
   * Gets or Sets engine
   */
  public enum EngineEnum {
    @SerializedName("BASIC")
    BASIC("BASIC"),
    
    @SerializedName("ADVANCED")
    ADVANCED("ADVANCED");

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

  @SerializedName("lifecycle")
  private Lifecycle lifecycle = null;

  @SerializedName("ocr")
  private Boolean ocr = null;

  @SerializedName("qualityFactor")
  private Integer qualityFactor = null;

  @SerializedName("resultFileName")
  private String resultFileName = null;

  /**
   * Gets or Sets version
   */
  public enum VersionEnum {
    @SerializedName("PDF_1_4")
    _1_4("PDF_1_4"),
    
    @SerializedName("PDF_1_5")
    _1_5("PDF_1_5"),
    
    @SerializedName("PDF_1_6")
    _1_6("PDF_1_6"),
    
    @SerializedName("PDF_1_7")
    _1_7("PDF_1_7"),
    
    @SerializedName("PDF_A_1b")
    A_1B("PDF_A_1b");

    private String value;

    VersionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("version")
  private VersionEnum version = null;

  public Image2PDFSettings compression(Compression compression) {
    this.compression = compression;
    return this;
  }

   /**
   * Get compression
   * @return compression
  **/
  @ApiModelProperty(example = "null", value = "")
  public Compression getCompression() {
    return compression;
  }

  public void setCompression(Compression compression) {
    this.compression = compression;
  }

  public Image2PDFSettings engine(EngineEnum engine) {
    this.engine = engine;
    return this;
  }

   /**
   * Get engine
   * @return engine
  **/
  @ApiModelProperty(example = "null", value = "")
  public EngineEnum getEngine() {
    return engine;
  }

  public void setEngine(EngineEnum engine) {
    this.engine = engine;
  }

  public Image2PDFSettings lifecycle(Lifecycle lifecycle) {
    this.lifecycle = lifecycle;
    return this;
  }

   /**
   * Get lifecycle
   * @return lifecycle
  **/
  @ApiModelProperty(example = "null", value = "")
  public Lifecycle getLifecycle() {
    return lifecycle;
  }

  public void setLifecycle(Lifecycle lifecycle) {
    this.lifecycle = lifecycle;
  }

  public Image2PDFSettings ocr(Boolean ocr) {
    this.ocr = ocr;
    return this;
  }

   /**
   * Whether to perform OCR. When set to false the text in the PDF will not be searchable
   * @return ocr
  **/
  @ApiModelProperty(example = "false", value = "Whether to perform OCR. When set to false the text in the PDF will not be searchable")
  public Boolean getOcr() {
    return ocr;
  }

  public void setOcr(Boolean ocr) {
    this.ocr = ocr;
  }

  public Image2PDFSettings qualityFactor(Integer qualityFactor) {
    this.qualityFactor = qualityFactor;
    return this;
  }

   /**
   * Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest)
   * minimum: 0.0
   * maximum: 10.0
   * @return qualityFactor
  **/
  @ApiModelProperty(example = "null", value = "Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest)")
  public Integer getQualityFactor() {
    return qualityFactor;
  }

  public void setQualityFactor(Integer qualityFactor) {
    this.qualityFactor = qualityFactor;
  }

  public Image2PDFSettings resultFileName(String resultFileName) {
    this.resultFileName = resultFileName;
    return this;
  }

   /**
   * Get resultFileName
   * @return resultFileName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getResultFileName() {
    return resultFileName;
  }

  public void setResultFileName(String resultFileName) {
    this.resultFileName = resultFileName;
  }

  public Image2PDFSettings version(VersionEnum version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(example = "null", value = "")
  public VersionEnum getVersion() {
    return version;
  }

  public void setVersion(VersionEnum version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Image2PDFSettings image2PDFSettings = (Image2PDFSettings) o;
    return Objects.equals(this.compression, image2PDFSettings.compression) &&
        Objects.equals(this.engine, image2PDFSettings.engine) &&
        Objects.equals(this.lifecycle, image2PDFSettings.lifecycle) &&
        Objects.equals(this.ocr, image2PDFSettings.ocr) &&
        Objects.equals(this.qualityFactor, image2PDFSettings.qualityFactor) &&
        Objects.equals(this.resultFileName, image2PDFSettings.resultFileName) &&
        Objects.equals(this.version, image2PDFSettings.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(compression, engine, lifecycle, ocr, qualityFactor, resultFileName, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Image2PDFSettings {\n");
    
    sb.append("    compression: ").append(toIndentedString(compression)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    lifecycle: ").append(toIndentedString(lifecycle)).append("\n");
    sb.append("    ocr: ").append(toIndentedString(ocr)).append("\n");
    sb.append("    qualityFactor: ").append(toIndentedString(qualityFactor)).append("\n");
    sb.append("    resultFileName: ").append(toIndentedString(resultFileName)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

