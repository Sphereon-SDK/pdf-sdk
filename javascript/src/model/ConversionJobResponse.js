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
    define(['ApiClient', 'model/ConversionJob', 'model/ConversionTask', 'model/InputResponse', 'model/ResultResponse'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./ConversionJob'), require('./ConversionTask'), require('./InputResponse'), require('./ResultResponse'));
  } else {
    // Browser globals (root is window)
    if (!root.Pdf) {
      root.Pdf = {};
    }
    root.Pdf.ConversionJobResponse = factory(root.Pdf.ApiClient, root.Pdf.ConversionJob, root.Pdf.ConversionTask, root.Pdf.InputResponse, root.Pdf.ResultResponse);
  }
}(this, function(ApiClient, ConversionJob, ConversionTask, InputResponse, ResultResponse) {
  'use strict';




  /**
   * The ConversionJobResponse model module.
   * @module model/ConversionJobResponse
   * @version 1.1
   */

  /**
   * Constructs a new <code>ConversionJobResponse</code>.
   * The PDF job. Has access to the job settings as well as (ocr) engine tasks
   * @alias module:model/ConversionJobResponse
   * @class
   * @param result {module:model/ResultResponse} The result(s)
   * @param input {module:model/InputResponse} The input(s)
   * @param jobId {String} The job id
   * @param job {module:model/ConversionJob} The job
   * @param status {module:model/ConversionJobResponse.StatusEnum} The status of the job
   */
  var exports = function(result, input, jobId, job, status) {
    var _this = this;

    _this['result'] = result;

    _this['input'] = input;
    _this['jobId'] = jobId;



    _this['job'] = job;


    _this['status'] = status;
  };

  /**
   * Constructs a <code>ConversionJobResponse</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/ConversionJobResponse} obj Optional instance to populate.
   * @return {module:model/ConversionJobResponse} The populated <code>ConversionJobResponse</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('result')) {
        obj['result'] = ResultResponse.constructFromObject(data['result']);
      }
      if (data.hasOwnProperty('completionTime')) {
        obj['completionTime'] = ApiClient.convertToType(data['completionTime'], 'Date');
      }
      if (data.hasOwnProperty('input')) {
        obj['input'] = InputResponse.constructFromObject(data['input']);
      }
      if (data.hasOwnProperty('jobId')) {
        obj['jobId'] = ApiClient.convertToType(data['jobId'], 'String');
      }
      if (data.hasOwnProperty('creationTime')) {
        obj['creationTime'] = ApiClient.convertToType(data['creationTime'], 'Date');
      }
      if (data.hasOwnProperty('conversionTasks')) {
        obj['conversionTasks'] = ApiClient.convertToType(data['conversionTasks'], [ConversionTask]);
      }
      if (data.hasOwnProperty('updateTime')) {
        obj['updateTime'] = ApiClient.convertToType(data['updateTime'], 'Date');
      }
      if (data.hasOwnProperty('job')) {
        obj['job'] = ConversionJob.constructFromObject(data['job']);
      }
      if (data.hasOwnProperty('statusMessage')) {
        obj['statusMessage'] = ApiClient.convertToType(data['statusMessage'], 'String');
      }
      if (data.hasOwnProperty('queueTime')) {
        obj['queueTime'] = ApiClient.convertToType(data['queueTime'], 'Date');
      }
      if (data.hasOwnProperty('status')) {
        obj['status'] = ApiClient.convertToType(data['status'], 'String');
      }
    }
    return obj;
  }

  /**
   * The result(s)
   * @member {module:model/ResultResponse} result
   */
  exports.prototype['result'] = undefined;
  /**
   * The completion date/time of this job in ISO 8601 format
   * @member {Date} completionTime
   */
  exports.prototype['completionTime'] = undefined;
  /**
   * The input(s)
   * @member {module:model/InputResponse} input
   */
  exports.prototype['input'] = undefined;
  /**
   * The job id
   * @member {String} jobId
   */
  exports.prototype['jobId'] = undefined;
  /**
   * The creation date/time of this job in ISO 8601 format
   * @member {Date} creationTime
   */
  exports.prototype['creationTime'] = undefined;
  /**
   * @member {Array.<module:model/ConversionTask>} conversionTasks
   */
  exports.prototype['conversionTasks'] = undefined;
  /**
   * The last update date/time of this job in ISO 8601 format
   * @member {Date} updateTime
   */
  exports.prototype['updateTime'] = undefined;
  /**
   * The job
   * @member {module:model/ConversionJob} job
   */
  exports.prototype['job'] = undefined;
  /**
   * A status message, which can be informational, warning or error. AA message here does not indicate an error perse
   * @member {String} statusMessage
   */
  exports.prototype['statusMessage'] = undefined;
  /**
   * The conversion queue date/time of this job in ISO 8601 format
   * @member {Date} queueTime
   */
  exports.prototype['queueTime'] = undefined;
  /**
   * The status of the job
   * @member {module:model/ConversionJobResponse.StatusEnum} status
   */
  exports.prototype['status'] = undefined;


  /**
   * Allowed values for the <code>status</code> property.
   * @enum {String}
   * @readonly
   */
  exports.StatusEnum = {
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


  return exports;
}));


