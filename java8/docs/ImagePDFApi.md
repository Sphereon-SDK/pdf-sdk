# ImagePDFApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteJob**](ImagePDFApi.md#deleteJob) | **DELETE** /pdf/0.1.5/image2pdf/{jobid} | Delete a job manually
[**getJob**](ImagePDFApi.md#getJob) | **GET** /pdf/0.1.5/image2pdf/{jobid} | Job definition and state
[**getJobs**](ImagePDFApi.md#getJobs) | **GET** /pdf/0.1.5/image2pdf{?status} | Get all jobs
[**getStream**](ImagePDFApi.md#getStream) | **GET** /pdf/0.1.5/image2pdf/{jobid}/stream | Get the current result stream
[**submitJob**](ImagePDFApi.md#submitJob) | **PUT** /pdf/0.1.5/image2pdf/{jobid} | Submit PDF job for processing
[**uploadAdditionalImage**](ImagePDFApi.md#uploadAdditionalImage) | **POST** /pdf/0.1.5/image2pdf/{jobid} | Upload an additional image
[**uploadImage**](ImagePDFApi.md#uploadImage) | **POST** /pdf/0.1.5/image2pdf | Upload (first) image


<a name="deleteJob"></a>
# **deleteJob**
> PDFJobResponse deleteJob(jobid)

Delete a job manually

Delete the PDF job and all related files

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ImagePDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ImagePDFApi apiInstance = new ImagePDFApi();
String jobid = "jobid_example"; // String | jobid
try {
    PDFJobResponse result = apiInstance.deleteJob(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImagePDFApi#deleteJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |

### Return type

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getJob"></a>
# **getJob**
> PDFJobResponse getJob(jobid)

Job definition and state

Get the PDF job definition and current state. Please not that you can differentiate based on http response status

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ImagePDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ImagePDFApi apiInstance = new ImagePDFApi();
String jobid = "jobid_example"; // String | jobid
try {
    PDFJobResponse result = apiInstance.getJob(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImagePDFApi#getJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |

### Return type

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getJobs"></a>
# **getJobs**
> PDFJobResponse getJobs(status)

Get all jobs

Get all PDF job definitions and their current state.

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ImagePDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ImagePDFApi apiInstance = new ImagePDFApi();
List<String> status = Arrays.asList("status_example"); // List<String> | A list of status to filter on.
try {
    PDFJobResponse result = apiInstance.getJobs(status);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImagePDFApi#getJobs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List&lt;String&gt;**](String.md)| A list of status to filter on. | [optional] [enum: IMAGE_UPLOADED, PROCESSING, DONE, ERROR, DELETED]

### Return type

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getStream"></a>
# **getStream**
> byte[] getStream(jobid)

Get the current result stream

Get the PDF as binary stream/file.  Our API generation does not allow changing the media type based on the Accepted header unfortunately.&lt;br/&gt;This means we use a seperate path postfix with the value &#39;/stream&#39;.  This API only returns the PDF when the response status code is zero! In other cases nothing is returned or the Job JSON when it is still being executed

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ImagePDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ImagePDFApi apiInstance = new ImagePDFApi();
String jobid = "jobid_example"; // String | jobid
try {
    byte[] result = apiInstance.getStream(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImagePDFApi#getStream");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |

### Return type

**byte[]**

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="submitJob"></a>
# **submitJob**
> PDFJobResponse submitJob(jobid, job)

Submit PDF job for processing

Convert the previously uploaded image(s) to PDF, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status IMAGE_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ImagePDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ImagePDFApi apiInstance = new ImagePDFApi();
String jobid = "jobid_example"; // String | jobid
PDFJob job = new PDFJob(); // PDFJob | jobEntity
try {
    PDFJobResponse result = apiInstance.submitJob(jobid, job);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImagePDFApi#submitJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |
 **job** | [**PDFJob**](PDFJob.md)| jobEntity |

### Return type

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="uploadAdditionalImage"></a>
# **uploadAdditionalImage**
> PDFJobResponse uploadAdditionalImage(jobid, stream)

Upload an additional image

Upload an additional image for conversion to PDF. Conversion will not be started yet.

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ImagePDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ImagePDFApi apiInstance = new ImagePDFApi();
String jobid = "jobid_example"; // String | jobid
File stream = new File("/path/to/file.txt"); // File | The additional binary image or PDF (file/inputstream) to convert to PDF
try {
    PDFJobResponse result = apiInstance.uploadAdditionalImage(jobid, stream);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImagePDFApi#uploadAdditionalImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |
 **stream** | **File**| The additional binary image or PDF (file/inputstream) to convert to PDF |

### Return type

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

<a name="uploadImage"></a>
# **uploadImage**
> PDFJobResponse uploadImage(stream)

Upload (first) image

Upload an image for conversion to PDF. Conversion will not be started yet. In order to create a multipage PDF you can submit a multipage Tiff in this step or submit additional images or PDFs in subsequent steps using the uploadAdditionalImage endpoint

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ImagePDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ImagePDFApi apiInstance = new ImagePDFApi();
File stream = new File("/path/to/file.txt"); // File | The first binary image or PDF (file/inputstream) to convert to PDF
try {
    PDFJobResponse result = apiInstance.uploadImage(stream);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImagePDFApi#uploadImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stream** | **File**| The first binary image or PDF (file/inputstream) to convert to PDF |

### Return type

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

