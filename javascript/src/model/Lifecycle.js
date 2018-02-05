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
    root.Pdf.Lifecycle = factory(root.Pdf.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The Lifecycle model module.
   * @module model/Lifecycle
   * @version 1.1
   */

  /**
   * Constructs a new <code>Lifecycle</code>.
   * Lifecycle settings. When no lifecycle settings are supplied, the job and files will be deleted directly after retrieval of the file
   * @alias module:model/Lifecycle
   * @class
   */
  var exports = function() {
    var _this = this;




  };

  /**
   * Constructs a <code>Lifecycle</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/Lifecycle} obj Optional instance to populate.
   * @return {module:model/Lifecycle} The populated <code>Lifecycle</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('applicableJobStatusses')) {
        obj['applicableJobStatusses'] = ApiClient.convertToType(data['applicableJobStatusses'], ['String']);
      }
      if (data.hasOwnProperty('action')) {
        obj['action'] = ApiClient.convertToType(data['action'], 'String');
      }
      if (data.hasOwnProperty('type')) {
        obj['type'] = ApiClient.convertToType(data['type'], 'String');
      }
    }
    return obj;
  }

  /**
   * Job status needs to be in this list in order for the action to be performeld!
   * @member {Array.<module:model/Lifecycle.ApplicableJobStatussesEnum>} applicableJobStatusses
   */
  exports.prototype['applicableJobStatusses'] = undefined;
  /**
   * @member {module:model/Lifecycle.ActionEnum} action
   */
  exports.prototype['action'] = undefined;
  /**
   * @member {module:model/Lifecycle.TypeEnum} type
   */
  exports.prototype['type'] = undefined;


  /**
   * Allowed values for the <code>applicableJobStatusses</code> property.
   * @enum {String}
   * @readonly
   */
  exports.ApplicableJobStatussesEnum = {
    /**
     * value: "INIT"
     * @const
     */
    "INIT": "INIT",
    /**
     * value: "INPUTS_UPLOADED"
     * @const
     */
    "INPUTS_UPLOADED": "INPUTS_UPLOADED",
    /**
     * value: "PROCESSING"
     * @const
     */
    "PROCESSING": "PROCESSING",
    /**
     * value: "DONE"
     * @const
     */
    "DONE": "DONE",
    /**
     * value: "ERROR"
     * @const
     */
    "ERROR": "ERROR",
    /**
     * value: "DELETED"
     * @const
     */
    "DELETED": "DELETED"  };

  /**
   * Allowed values for the <code>action</code> property.
   * @enum {String}
   * @readonly
   */
  exports.ActionEnum = {
    /**
     * value: "DELETE"
     * @const
     */
    "DELETE": "DELETE",
    /**
     * value: "NONE"
     * @const
     */
    "NONE": "NONE"  };

  /**
   * Allowed values for the <code>type</code> property.
   * @enum {String}
   * @readonly
   */
  exports.TypeEnum = {
    /**
     * value: "RETRIEVAL"
     * @const
     */
    "RETRIEVAL": "RETRIEVAL"  };


  return exports;
}));


