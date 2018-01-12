# pdf

Pdf - JavaScript client for pdf
The PDF conversion API 'conversion2pdf' converts image, office and PDF files to (searcheable) PDF files.    The flow is generally as follows:  1. First create a job using the /conversion2pdf/jobs POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Upload one or more images/files using the /conversion2pdf/jobs/{jobId}/streams/multipart POST endpoint. You can also add stream locations from the storage API . You will get back the update job response that contains a job with its associated settings. Currently you can only merge spreadsheets with spreadsheet, documents with documents and images/pdfs with images/pdfs  3. Start the job from a PUT request to the /conversion2pdf/jobs/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start. The OCR setting is only applicable to images, since other files will always be searchable.  4. Check the job status from the /conversion2pdf/jobs/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  5. Retrieve the PDF file using the /conversion2pdf/jobs/{jobid}/streams/result GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      Interactive testing: A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
This SDK is automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen) project:

- API version: 1.1
- Package version: 1.1
- Build package: io.swagger.codegen.languages.JavascriptClientCodegen
For more information, please visit [https://sphereon.com](https://sphereon.com)

## Installation

### For [Node.js](https://nodejs.org/)

#### npm

To publish the library as a [npm](https://www.npmjs.com/),
please follow the procedure in ["Publishing npm packages"](https://docs.npmjs.com/getting-started/publishing-npm-packages).

Then install it via:

```shell
npm install pdf --save
```

##### Local development

To use the library locally without publishing to a remote npm registry, first install the dependencies by changing 
into the directory containing `package.json` (and this README). Let's call this `JAVASCRIPT_CLIENT_DIR`. Then run:

```shell
npm install
```

Next, [link](https://docs.npmjs.com/cli/link) it globally in npm with the following, also from `JAVASCRIPT_CLIENT_DIR`:

```shell
npm link
```

Finally, switch to the directory you want to use your pdf from, and run:

```shell
npm link /path/to/<JAVASCRIPT_CLIENT_DIR>
```

You should now be able to `require('pdf')` in javascript files from the directory you ran the last 
command above from.

#### git
#
If the library is hosted at a git repository, e.g.
https://github.com/GIT_USER_ID/GIT_REPO_ID
then install it via:

```shell
    npm install GIT_USER_ID/GIT_REPO_ID --save
```

### For browser

The library also works in the browser environment via npm and [browserify](http://browserify.org/). After following
the above steps with Node.js and installing browserify with `npm install -g browserify`,
perform the following (assuming *main.js* is your entry file, that's to say your javascript file where you actually 
use this library):

```shell
browserify main.js > bundle.js
```

Then include *bundle.js* in the HTML pages.

### Webpack Configuration

Using Webpack you may encounter the following error: "Module not found: Error:
Cannot resolve module", most certainly you should disable AMD loader. Add/merge
the following section to your webpack config:

```javascript
module: {
  rules: [
    {
      parser: {
        amd: false
      }
    }
  ]
}
```

## Getting Started

Please follow the [installation](#installation) instruction and execute the following JS code:

```javascript
var Pdf = require('pdf');

var defaultClient = Pdf.ApiClient.instance;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = "YOUR ACCESS TOKEN"

var api = new Pdf.Conversion2PDFApi()

var jobid = "jobid_example"; // {String} jobid

var stream = "/path/to/file.txt"; // {File} The (additional) binary image or PDF (file/inputstream) to convert to PDF

var opts = { 
  'fileName': "fileName_example" // {String} Optional input file name.
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
api.addInputFile(jobid, stream, opts, callback);

```

## Documentation for API Endpoints

All URIs are relative to *https://gw.api.cloud.sphereon.com/pdf/1.1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*Pdf.Conversion2PDFApi* | [**addInputFile**](docs/Conversion2PDFApi.md#addInputFile) | **POST** /conversion2pdf/jobs/{jobid}/streams/multipart | Upload a file
*Pdf.Conversion2PDFApi* | [**addInputStreamLocations**](docs/Conversion2PDFApi.md#addInputStreamLocations) | **POST** /conversion2pdf/jobs/{jobid}/streams/location | Add Input Stream Location(s)
*Pdf.Conversion2PDFApi* | [**createJob**](docs/Conversion2PDFApi.md#createJob) | **POST** /conversion2pdf/jobs | Create a PDF conversion job
*Pdf.Conversion2PDFApi* | [**deleteJob**](docs/Conversion2PDFApi.md#deleteJob) | **DELETE** /conversion2pdf/jobs/{jobid} | Delete a job manually
*Pdf.Conversion2PDFApi* | [**getJob**](docs/Conversion2PDFApi.md#getJob) | **GET** /conversion2pdf/jobs/{jobid} | Job definition and state
*Pdf.Conversion2PDFApi* | [**getJobs**](docs/Conversion2PDFApi.md#getJobs) | **GET** /conversion2pdf/jobs | Get all jobs
*Pdf.Conversion2PDFApi* | [**getStream**](docs/Conversion2PDFApi.md#getStream) | **GET** /conversion2pdf/jobs/{jobid}/streams/result | Get the current result stream
*Pdf.Conversion2PDFApi* | [**submitJob**](docs/Conversion2PDFApi.md#submitJob) | **PUT** /conversion2pdf/jobs/{jobid} | Submit PDF job for processing


## Documentation for Models

 - [Pdf.CSVSettings](docs/CSVSettings.md)
 - [Pdf.Compression](docs/Compression.md)
 - [Pdf.ConversionJob](docs/ConversionJob.md)
 - [Pdf.ConversionJobResponse](docs/ConversionJobResponse.md)
 - [Pdf.ConversionSettings](docs/ConversionSettings.md)
 - [Pdf.ConversionTask](docs/ConversionTask.md)
 - [Pdf.ConversionTaskInput](docs/ConversionTaskInput.md)
 - [Pdf.Error](docs/Error.md)
 - [Pdf.ErrorResponse](docs/ErrorResponse.md)
 - [Pdf.InputResponse](docs/InputResponse.md)
 - [Pdf.InputSettings](docs/InputSettings.md)
 - [Pdf.Lifecycle](docs/Lifecycle.md)
 - [Pdf.ResultResponse](docs/ResultResponse.md)
 - [Pdf.ResultSettings](docs/ResultSettings.md)
 - [Pdf.StorageLocation](docs/StorageLocation.md)
 - [Pdf.StreamLocation](docs/StreamLocation.md)


## Documentation for Authorization


### oauth2schema

- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: 
  - global: accessEverything
