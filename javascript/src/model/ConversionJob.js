/**
 * PDF
 * The PDF conversion API 'conversion2pdf' converts image, office and PDF files to (searcheable) PDF files.    The flow is generally as follows:  1. First create a job using the /conversion2pdf/jobs POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload one or more images/files using the /conversion2pdf/jobs/{jobId}/streams/multipart POST endpoint. You can also add stream locations from the storage API . You will get back the update job response that contains a job with its associated settings. Currently you can only merge spreadsheets with spreadsheet, documents with documents and images/pdfs with images/pdfs  3. Start the job from a PUT request to the /conversion2pdf/jobs/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start. The OCR setting is only applicable to images, since other files will always be searchable.  4. Check the job status from the /conversion2pdf/jobs/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /conversion2pdf/jobs/{jobid}/streams/result GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      Interactive testing: A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.1
 * Contact: dev@sphereon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 2.3.1
 *
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient', 'model/ConversionSettings'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./ConversionSettings'));
  } else {
    // Browser globals (root is window)
    if (!root.Pdf) {
      root.Pdf = {};
    }
    root.Pdf.ConversionJob = factory(root.Pdf.ApiClient, root.Pdf.ConversionSettings);
  }
}(this, function(ApiClient, ConversionSettings) {
  'use strict';




  /**
   * The ConversionJob model module.
   * @module model/ConversionJob
   * @version 1.1
   */

  /**
   * Constructs a new <code>ConversionJob</code>.
   * The PDF conversion job. Has access to the job settings.
   * @alias module:model/ConversionJob
   * @class
   * @param jobId {String} The server generated job jobId. This jobId is checked against the jobId in the request path on overy invocation
   * @param settings {module:model/ConversionSettings} The settings to use during the conversion job
   */
  var exports = function(jobId, settings) {
    var _this = this;

    _this['jobId'] = jobId;
    _this['settings'] = settings;
  };

  /**
   * Constructs a <code>ConversionJob</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/ConversionJob} obj Optional instance to populate.
   * @return {module:model/ConversionJob} The populated <code>ConversionJob</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('jobId')) {
        obj['jobId'] = ApiClient.convertToType(data['jobId'], 'String');
      }
      if (data.hasOwnProperty('settings')) {
        obj['settings'] = ConversionSettings.constructFromObject(data['settings']);
      }
    }
    return obj;
  }

  /**
   * The server generated job jobId. This jobId is checked against the jobId in the request path on overy invocation
   * @member {String} jobId
   */
  exports.prototype['jobId'] = undefined;
  /**
   * The settings to use during the conversion job
   * @member {module:model/ConversionSettings} settings
   */
  exports.prototype['settings'] = undefined;



  return exports;
}));


