/**
 * PDF
 * <b>The PDF conversion API 'conversion2pdf' converts image, office and PDF files to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First create a job using the /conversion2pdf/jobs POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload one or more images/files using the /conversion2pdf/jobs/{jobId}/streams/multipart POST endpoint. You can also add stream locations from the storage API . You will get back the update job response that contains a job with its associated settings. Currently you can only merge spreadsheets with spreadsheet, documents with documents and images/pdfs with images/pdfs  3. Start the job from a PUT request to the /conversion2pdf/jobs/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start. The OCR setting is only applicable to images, since other files will always be searchable.  4. Check the job status from the /conversion2pdf/jobs/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /conversion2pdf/jobs/{jobid}/streams/result GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.1
 * Contact: dev@sphereon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 2.2.3
 *
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.Pdf) {
      root.Pdf = {};
    }
    root.Pdf.CSVSettings = factory(root.Pdf.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The CSVSettings model module.
   * @module model/CSVSettings
   * @version 1.1
   */

  /**
   * Constructs a new <code>CSVSettings</code>.
   * @alias module:model/CSVSettings
   * @class
   */
  var exports = function() {
    var _this = this;




  };

  /**
   * Constructs a <code>CSVSettings</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/CSVSettings} obj Optional instance to populate.
   * @return {module:model/CSVSettings} The populated <code>CSVSettings</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('separatorCharacter')) {
        obj['separatorCharacter'] = ApiClient.convertToType(data['separatorCharacter'], 'String');
      }
      if (data.hasOwnProperty('standardRowHeight')) {
        obj['standardRowHeight'] = ApiClient.convertToType(data['standardRowHeight'], 'Number');
      }
      if (data.hasOwnProperty('standardColumnWidth')) {
        obj['standardColumnWidth'] = ApiClient.convertToType(data['standardColumnWidth'], 'Number');
      }
    }
    return obj;
  }

  /**
   * Set the separator for the columns. Choose between a comma (,), semicolon(;) and tab( )
   * @member {module:model/CSVSettings.SeparatorCharacterEnum} separatorCharacter
   */
  exports.prototype['separatorCharacter'] = undefined;
  /**
   * Set the standard row Height. Range from 1 (lowest) to 409 (highest)
   * @member {Number} standardRowHeight
   */
  exports.prototype['standardRowHeight'] = undefined;
  /**
   * Set the quality factor for the resulting PDF. Range from 1 (lowest) to 255 (highest)
   * @member {Number} standardColumnWidth
   */
  exports.prototype['standardColumnWidth'] = undefined;


  /**
   * Allowed values for the <code>separatorCharacter</code> property.
   * @enum {String}
   * @readonly
   */
  exports.SeparatorCharacterEnum = {
    /**
     * value: "COMMA"
     * @const
     */
    "COMMA": "COMMA",
    /**
     * value: "SEMICOLON"
     * @const
     */
    "SEMICOLON": "SEMICOLON",
    /**
     * value: "TAB"
     * @const
     */
    "TAB": "TAB"  };


  return exports;
}));


