# Sphereon.SDK.Pdf.Api.ConversionPDFApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DeleteJob**](ConversionPDFApi.md#deletejob) | **DELETE** /pdf/1.0/conversion2pdf/{jobid} | Delete a job manually
[**GetJob**](ConversionPDFApi.md#getjob) | **GET** /pdf/1.0/conversion2pdf/{jobid} | Job definition and state
[**GetJobs**](ConversionPDFApi.md#getjobs) | **GET** /pdf/1.0/conversion2pdf | Get all jobs
[**GetStream**](ConversionPDFApi.md#getstream) | **GET** /pdf/1.0/conversion2pdf/{jobid}/stream | Get the current result stream
[**SubmitJob**](ConversionPDFApi.md#submitjob) | **PUT** /pdf/1.0/conversion2pdf/{jobid} | Submit PDF job for processing
[**UploadAdditionalFile**](ConversionPDFApi.md#uploadadditionalfile) | **POST** /pdf/1.0/conversion2pdf/{jobid} | Upload an additional file
[**UploadFile**](ConversionPDFApi.md#uploadfile) | **POST** /pdf/1.0/conversion2pdf | Upload first file


<a name="deletejob"></a>
# **DeleteJob**
> ConversionJobResponse DeleteJob (string jobid)

Delete a job manually

Delete the PDF job and all related files

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class DeleteJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ConversionPDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Delete a job manually
                ConversionJobResponse result = apiInstance.DeleteJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ConversionPDFApi.DeleteJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getjob"></a>
# **GetJob**
> ConversionJobResponse GetJob (string jobid)

Job definition and state

Get the PDF job definition and current state. Please not that you can differentiate based on http response status

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class GetJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ConversionPDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Job definition and state
                ConversionJobResponse result = apiInstance.GetJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ConversionPDFApi.GetJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getjobs"></a>
# **GetJobs**
> ConversionJobResponse GetJobs (List<string> status = null)

Get all jobs

Get all PDF job definitions and their current state.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class GetJobsExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ConversionPDFApi();
            var status = new List<string>(); // List<string> | A list of status to filter on. (optional) 

            try
            {
                // Get all jobs
                ConversionJobResponse result = apiInstance.GetJobs(status);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ConversionPDFApi.GetJobs: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List<string>**](string.md)| A list of status to filter on. | [optional] 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getstream"></a>
# **GetStream**
> byte[] GetStream (string jobid)

Get the current result stream

Get the PDF as binary stream/file.  Our API generation does not allow changing the media type based on the Accepted header unfortunately.<br/>This means we use a seperate path postfix with the value '/stream'.  This API only returns the PDF when the response status code is zero! In other cases nothing is returned or the Job JSON when it is still being executed

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class GetStreamExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ConversionPDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Get the current result stream
                byte[] result = apiInstance.GetStream(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ConversionPDFApi.GetStream: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 

### Return type

**byte[]**

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="submitjob"></a>
# **SubmitJob**
> ConversionJobResponse SubmitJob (string jobid, ConversionJob job)

Submit PDF job for processing

Convert the previously uploaded file(s) to PDF, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class SubmitJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ConversionPDFApi();
            var jobid = jobid_example;  // string | jobid
            var job = new ConversionJob(); // ConversionJob | jobEntity

            try
            {
                // Submit PDF job for processing
                ConversionJobResponse result = apiInstance.SubmitJob(jobid, job);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ConversionPDFApi.SubmitJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 
 **job** | [**ConversionJob**](ConversionJob.md)| jobEntity | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="uploadadditionalfile"></a>
# **UploadAdditionalFile**
> ConversionJobResponse UploadAdditionalFile (string jobid, System.IO.Stream stream)

Upload an additional file

Upload an additional image, office or pdf for conversion to PDF. Conversion will not be started yet.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class UploadAdditionalFileExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ConversionPDFApi();
            var jobid = jobid_example;  // string | jobid
            var stream = new System.IO.Stream(); // System.IO.Stream | The additional binary image or PDF (file/inputstream) to convert to PDF

            try
            {
                // Upload an additional file
                ConversionJobResponse result = apiInstance.UploadAdditionalFile(jobid, stream);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ConversionPDFApi.UploadAdditionalFile: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 
 **stream** | **System.IO.Stream**| The additional binary image or PDF (file/inputstream) to convert to PDF | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="uploadfile"></a>
# **UploadFile**
> ConversionJobResponse UploadFile (System.IO.Stream stream)

Upload first file

Upload the first image, office or pdf file.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class UploadFileExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ConversionPDFApi();
            var stream = new System.IO.Stream(); // System.IO.Stream | The first image, office or PDF file to convert to PDF

            try
            {
                // Upload first file
                ConversionJobResponse result = apiInstance.UploadFile(stream);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ConversionPDFApi.UploadFile: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stream** | **System.IO.Stream**| The first image, office or PDF file to convert to PDF | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
