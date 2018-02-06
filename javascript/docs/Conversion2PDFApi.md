# Pdf.Conversion2PDFApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/pdf/1.1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addInputFile**](Conversion2PDFApi.md#addInputFile) | **POST** /conversion2pdf/jobs/{jobid}/streams/multipart | Upload a file
[**addInputStreamLocations**](Conversion2PDFApi.md#addInputStreamLocations) | **POST** /conversion2pdf/jobs/{jobid}/streams/location | Add Input Stream Location(s)
[**createJob**](Conversion2PDFApi.md#createJob) | **POST** /conversion2pdf/jobs | Create a PDF conversion job
[**deleteJob**](Conversion2PDFApi.md#deleteJob) | **DELETE** /conversion2pdf/jobs/{jobid} | Delete a job manually
[**getJob**](Conversion2PDFApi.md#getJob) | **GET** /conversion2pdf/jobs/{jobid} | Job definition and state
[**getJobs**](Conversion2PDFApi.md#getJobs) | **GET** /conversion2pdf/jobs | Get all jobs
[**getStream**](Conversion2PDFApi.md#getStream) | **GET** /conversion2pdf/jobs/{jobid}/streams/result | Get the current result stream
[**submitJob**](Conversion2PDFApi.md#submitJob) | **PUT** /conversion2pdf/jobs/{jobid} | Submit PDF job for processing


<a name="addInputFile"></a>
# **addInputFile**
> ConversionJobResponse addInputFile(jobid, stream, opts)

Upload a file

Upload an image, office or pdf for conversion to PDF. Please note that you can upload multiple files. Conversion will not be started yet.

### Example
```javascript
var Pdf = require('pdf');
var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new Pdf.Conversion2PDFApi();

var jobid = "jobid_example"; // String | jobid

var stream = "/path/to/file.txt"; // File | The (additional) binary image or PDF (file/inputstream) to convert to PDF

var opts = { 
  'fileName': "fileName_example" // String | Optional input file name.
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.addInputFile(jobid, stream, opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid | 
 **stream** | **File**| The (additional) binary image or PDF (file/inputstream) to convert to PDF | 
 **fileName** | **String**| Optional input file name. | [optional] 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

<a name="addInputStreamLocations"></a>
# **addInputStreamLocations**
> ConversionJobResponse addInputStreamLocations(jobid, inputStreamLocations)

Add Input Stream Location(s)

Add image, office or pdf input stream location(s) from the storage API for conversion to PDF. Please note that you can upload multiple files. Conversion will not be started yet.

### Example
```javascript
var Pdf = require('pdf');
var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new Pdf.Conversion2PDFApi();

var jobid = "jobid_example"; // String | jobid

var inputStreamLocations = [new Pdf.StreamLocation()]; // [StreamLocation] | The (additional) binary image or PDF (file/inputstream) to convert to PDF


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.addInputStreamLocations(jobid, inputStreamLocations, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid | 
 **inputStreamLocations** | [**[StreamLocation]**](StreamLocation.md)| The (additional) binary image or PDF (file/inputstream) to convert to PDF | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="createJob"></a>
# **createJob**
> ConversionJobResponse createJob(opts)

Create a PDF conversion job

Create a PDF conversion job using optional settings supplied, otherwise defaults will be used

### Example
```javascript
var Pdf = require('pdf');
var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new Pdf.Conversion2PDFApi();

var opts = { 
  'settings': new Pdf.ConversionSettings() // ConversionSettings | Optional settings to use for this job
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createJob(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **settings** | [**ConversionSettings**](ConversionSettings.md)| Optional settings to use for this job | [optional] 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="deleteJob"></a>
# **deleteJob**
> ConversionJobResponse deleteJob(jobid)

Delete a job manually

Delete the PDF job and all related files.

### Example
```javascript
var Pdf = require('pdf');
var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new Pdf.Conversion2PDFApi();

var jobid = "jobid_example"; // String | jobid


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.deleteJob(jobid, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getJob"></a>
# **getJob**
> ConversionJobResponse getJob(jobid)

Job definition and state

Get the PDF job definition and current state. Please note that you can differentiate based on http response status.

### Example
```javascript
var Pdf = require('pdf');
var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new Pdf.Conversion2PDFApi();

var jobid = "jobid_example"; // String | jobid


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getJob(jobid, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getJobs"></a>
# **getJobs**
> ConversionJobResponse getJobs(opts)

Get all jobs

Get all PDF job definitions and their current state.

### Example
```javascript
var Pdf = require('pdf');
var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new Pdf.Conversion2PDFApi();

var opts = { 
  'status': ["status_example"] // [String] | A list of status to filter on.
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getJobs(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**[String]**](String.md)| A list of status to filter on. | [optional] 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getStream"></a>
# **getStream**
> &#39;Blob&#39; getStream(jobid)

Get the current result stream

Get the PDF as binary stream/file.  Our API generation does not allow changing the media type based on the Accepted header unfortunately.  This means we use a seperate path postfix with the value &#39;/stream&#39;.  This API only returns the PDF when the response status.

### Example
```javascript
var Pdf = require('pdf');
var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new Pdf.Conversion2PDFApi();

var jobid = "jobid_example"; // String | jobid


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.getStream(jobid, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid | 

### Return type

**&#39;Blob&#39;**

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="submitJob"></a>
# **submitJob**
> ConversionJobResponse submitJob(jobid, job)

Submit PDF job for processing

Start PDF conversion. Convert the previously uploaded file(s) to PDF. The settings supplied with the job in the request body are used for the conversion. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request.

### Example
```javascript
var Pdf = require('pdf');
var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new Pdf.Conversion2PDFApi();

var jobid = "jobid_example"; // String | jobid

var job = new Pdf.ConversionJob(); // ConversionJob | jobEntity


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.submitJob(jobid, job, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid | 
 **job** | [**ConversionJob**](ConversionJob.md)| jobEntity | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

