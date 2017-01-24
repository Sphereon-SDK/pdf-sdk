# ConversionPDFApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteJob**](ConversionPDFApi.md#deleteJob) | **DELETE** /pdf/1.0.0/conversion2pdf/{jobid} | Delete a job manually
[**getJob**](ConversionPDFApi.md#getJob) | **GET** /pdf/1.0.0/conversion2pdf/{jobid} | Job definition and state
[**getJobs**](ConversionPDFApi.md#getJobs) | **GET** /pdf/1.0.0/conversion2pdf | Get all jobs
[**getStream**](ConversionPDFApi.md#getStream) | **GET** /pdf/1.0.0/conversion2pdf/{jobid}/stream | Get the current result stream
[**submitJob**](ConversionPDFApi.md#submitJob) | **PUT** /pdf/1.0.0/conversion2pdf/{jobid} | Submit PDF job for processing
[**uploadAdditionalFile**](ConversionPDFApi.md#uploadAdditionalFile) | **POST** /pdf/1.0.0/conversion2pdf/{jobid} | Upload an additional file
[**uploadFile**](ConversionPDFApi.md#uploadFile) | **POST** /pdf/1.0.0/conversion2pdf | Upload first file


<a name="deleteJob"></a>
# **deleteJob**
> ConversionJobResponse deleteJob(jobid)

Delete a job manually

Delete the PDF job and all related files

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ConversionPDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ConversionPDFApi apiInstance = new ConversionPDFApi();
String jobid = "jobid_example"; // String | jobid
try {
    ConversionJobResponse result = apiInstance.deleteJob(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConversionPDFApi#deleteJob");
    e.printStackTrace();
}
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

Get the PDF job definition and current state. Please not that you can differentiate based on http response status

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ConversionPDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ConversionPDFApi apiInstance = new ConversionPDFApi();
String jobid = "jobid_example"; // String | jobid
try {
    ConversionJobResponse result = apiInstance.getJob(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConversionPDFApi#getJob");
    e.printStackTrace();
}
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
> ConversionJobResponse getJobs(status)

Get all jobs

Get all PDF job definitions and their current state.

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ConversionPDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ConversionPDFApi apiInstance = new ConversionPDFApi();
List<String> status = Arrays.asList("status_example"); // List<String> | A list of status to filter on.
try {
    ConversionJobResponse result = apiInstance.getJobs(status);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConversionPDFApi#getJobs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List&lt;String&gt;**](String.md)| A list of status to filter on. | [optional] [enum: INPUTS_UPLOADED, PROCESSING, DONE, ERROR, DELETED]

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

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
//import com.sphereon.sdk.pdf.api.ConversionPDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ConversionPDFApi apiInstance = new ConversionPDFApi();
String jobid = "jobid_example"; // String | jobid
try {
    byte[] result = apiInstance.getStream(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConversionPDFApi#getStream");
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
> ConversionJobResponse submitJob(jobid, job)

Submit PDF job for processing

Convert the previously uploaded file(s) to PDF, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ConversionPDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ConversionPDFApi apiInstance = new ConversionPDFApi();
String jobid = "jobid_example"; // String | jobid
ConversionJob job = new ConversionJob(); // ConversionJob | jobEntity
try {
    ConversionJobResponse result = apiInstance.submitJob(jobid, job);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConversionPDFApi#submitJob");
    e.printStackTrace();
}
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

<a name="uploadAdditionalFile"></a>
# **uploadAdditionalFile**
> ConversionJobResponse uploadAdditionalFile(jobid, stream)

Upload an additional file

Upload an additional image, office or pdf for conversion to PDF. Conversion will not be started yet.

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ConversionPDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ConversionPDFApi apiInstance = new ConversionPDFApi();
String jobid = "jobid_example"; // String | jobid
File stream = new File("/path/to/file.txt"); // File | The additional binary image or PDF (file/inputstream) to convert to PDF
try {
    ConversionJobResponse result = apiInstance.uploadAdditionalFile(jobid, stream);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConversionPDFApi#uploadAdditionalFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |
 **stream** | **File**| The additional binary image or PDF (file/inputstream) to convert to PDF |

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

<a name="uploadFile"></a>
# **uploadFile**
> ConversionJobResponse uploadFile(stream)

Upload first file

Upload the first image, office or pdf file.

### Example
```java
// Import classes:
//import com.sphereon.sdk.pdf.handler.ApiClient;
//import com.sphereon.sdk.pdf.handler.ApiException;
//import com.sphereon.sdk.pdf.handler.Configuration;
//import com.sphereon.sdk.pdf.handler.auth.*;
//import com.sphereon.sdk.pdf.api.ConversionPDFApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

ConversionPDFApi apiInstance = new ConversionPDFApi();
File stream = new File("/path/to/file.txt"); // File | The first image, office or PDF file to convert to PDF
try {
    ConversionJobResponse result = apiInstance.uploadFile(stream);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConversionPDFApi#uploadFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stream** | **File**| The first image, office or PDF file to convert to PDF |

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

