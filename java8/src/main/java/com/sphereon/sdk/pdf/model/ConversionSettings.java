/**
 * Converstion 2 PDF
 * <b>The PDF conversion API 'conversion2pdf' converts image, office and PDF files to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First upload an image/file using the /conversion2pdf POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload any additional images/files using the /conversion2pdf/{jobId} POST endpoint when you want to merge additional image, office or PDF files. You will get back the update job response that contains a job with its associated settings. Currently you can only merge spreadsheets with spreadsheet, documents with documents and images/pdfs with images/pdfs  3. Start the job from a PUT request to the /conversion2pdf/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start. The OCR setting is only applicable to images, since other files will always be searchable.  4. Check the job status from the /conversion2pdf/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /conversion2pdf/{jobid}/stream GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 0.3.1
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
 * Conversion settings
 */
@ApiModel(description = "Conversion settings")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-12-19T13:27:22.418+01:00")
public class ConversionSettings   {
  @SerializedName("lifecycle")
  private Lifecycle lifecycle = null;

  @SerializedName("qualityFactor")
  private Integer qualityFactor = null;

  @SerializedName("resultFileName")
  private String resultFileName = null;

  /**
   * Gets or Sets engine
   */
  public enum EngineEnum {
    @SerializedName("BASIC")
    BASIC("BASIC"),
    
    @SerializedName("ADVANCED")
    ADVANCED("ADVANCED"),
    
    @SerializedName("PREMIUM")
    PREMIUM("PREMIUM");

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

  @SerializedName("compression")
  private Compression compression = null;

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

  @SerializedName("ocr")
  private Boolean ocr = null;

  public ConversionSettings lifecycle(Lifecycle lifecycle) {
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

  public ConversionSettings qualityFactor(Integer qualityFactor) {
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

  public ConversionSettings resultFileName(String resultFileName) {
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

  public ConversionSettings engine(EngineEnum engine) {
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

  public ConversionSettings compression(Compression compression) {
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

  public ConversionSettings version(VersionEnum version) {
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

  public ConversionSettings ocr(Boolean ocr) {
    this.ocr = ocr;
    return this;
  }

   /**
   * Whether to perform OCR. When set to false the text in the PDF will not be searchable. Not applicable to Office input files!
   * @return ocr
  **/
  @ApiModelProperty(example = "false", value = "Whether to perform OCR. When set to false the text in the PDF will not be searchable. Not applicable to Office input files!")
  public Boolean getOcr() {
    return ocr;
  }

  public void setOcr(Boolean ocr) {
    this.ocr = ocr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversionSettings conversionSettings = (ConversionSettings) o;
    return Objects.equals(this.lifecycle, conversionSettings.lifecycle) &&
        Objects.equals(this.qualityFactor, conversionSettings.qualityFactor) &&
        Objects.equals(this.resultFileName, conversionSettings.resultFileName) &&
        Objects.equals(this.engine, conversionSettings.engine) &&
        Objects.equals(this.compression, conversionSettings.compression) &&
        Objects.equals(this.version, conversionSettings.version) &&
        Objects.equals(this.ocr, conversionSettings.ocr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lifecycle, qualityFactor, resultFileName, engine, compression, version, ocr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionSettings {\n");
    
    sb.append("    lifecycle: ").append(toIndentedString(lifecycle)).append("\n");
    sb.append("    qualityFactor: ").append(toIndentedString(qualityFactor)).append("\n");
    sb.append("    resultFileName: ").append(toIndentedString(resultFileName)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    compression: ").append(toIndentedString(compression)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    ocr: ").append(toIndentedString(ocr)).append("\n");
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

