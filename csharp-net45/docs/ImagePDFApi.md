# Sphereon.SDK.Pdf.Api.ImagePDFApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DeleteJob**](ImagePDFApi.md#deletejob) | **DELETE** /pdf/0.1.5/image2pdf/{jobid} | Delete a job manually
[**GetJob**](ImagePDFApi.md#getjob) | **GET** /pdf/0.1.5/image2pdf/{jobid} | Job definition and state
[**GetJobs**](ImagePDFApi.md#getjobs) | **GET** /pdf/0.1.5/image2pdf | Get all jobs
[**GetStream**](ImagePDFApi.md#getstream) | **GET** /pdf/0.1.5/image2pdf/{jobid}/stream | Get the current result stream
[**SubmitJob**](ImagePDFApi.md#submitjob) | **PUT** /pdf/0.1.5/image2pdf/{jobid} | Submit PDF job for processing
[**UploadAdditionalImage**](ImagePDFApi.md#uploadadditionalimage) | **POST** /pdf/0.1.5/image2pdf/{jobid} | Upload an additional image
[**UploadImage**](ImagePDFApi.md#uploadimage) | **POST** /pdf/0.1.5/image2pdf | Upload (first) image


<a name="deletejob"></a>
# **DeleteJob**
> PDFJobResponse DeleteJob (string jobid)

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

            var apiInstance = new ImagePDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Delete a job manually
                PDFJobResponse result = apiInstance.DeleteJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ImagePDFApi.DeleteJob: " + e.Message );
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

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getjob"></a>
# **GetJob**
> PDFJobResponse GetJob (string jobid)

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

            var apiInstance = new ImagePDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Job definition and state
                PDFJobResponse result = apiInstance.GetJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ImagePDFApi.GetJob: " + e.Message );
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

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getjobs"></a>
# **GetJobs**
> PDFJobResponse GetJobs (List<string> status = null)

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

            var apiInstance = new ImagePDFApi();
            var status = new List<string>(); // List<string> | A list of status to filter on. (optional) 

            try
            {
                // Get all jobs
                PDFJobResponse result = apiInstance.GetJobs(status);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ImagePDFApi.GetJobs: " + e.Message );
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

[**PDFJobResponse**](PDFJobResponse.md)

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

            var apiInstance = new ImagePDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Get the current result stream
                byte[] result = apiInstance.GetStream(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ImagePDFApi.GetStream: " + e.Message );
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
> PDFJobResponse SubmitJob (string jobid, PDFJob job)

Submit PDF job for processing

Convert the previously uploaded image(s) to PDF, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status IMAGE_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request

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

            var apiInstance = new ImagePDFApi();
            var jobid = jobid_example;  // string | jobid
            var job = new PDFJob(); // PDFJob | jobEntity

            try
            {
                // Submit PDF job for processing
                PDFJobResponse result = apiInstance.SubmitJob(jobid, job);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ImagePDFApi.SubmitJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 
 **job** | [**PDFJob**](PDFJob.md)| jobEntity | 

### Return type

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="uploadadditionalimage"></a>
# **UploadAdditionalImage**
> PDFJobResponse UploadAdditionalImage (string jobid, System.IO.Stream stream)

Upload an additional image

Upload an additional image for conversion to PDF. Conversion will not be started yet.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class UploadAdditionalImageExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ImagePDFApi();
            var jobid = jobid_example;  // string | jobid
            var stream = new System.IO.Stream(); // System.IO.Stream | The additional binary image or PDF (file/inputstream) to convert to PDF

            try
            {
                // Upload an additional image
                PDFJobResponse result = apiInstance.UploadAdditionalImage(jobid, stream);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ImagePDFApi.UploadAdditionalImage: " + e.Message );
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

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="uploadimage"></a>
# **UploadImage**
> PDFJobResponse UploadImage (System.IO.Stream stream)

Upload (first) image

Upload an image for conversion to PDF. Conversion will not be started yet. In order to create a multipage PDF you can submit a multipage Tiff in this step or submit additional images or PDFs in subsequent steps using the uploadAdditionalImage endpoint

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class UploadImageExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new ImagePDFApi();
            var stream = new System.IO.Stream(); // System.IO.Stream | The first binary image or PDF (file/inputstream) to convert to PDF

            try
            {
                // Upload (first) image
                PDFJobResponse result = apiInstance.UploadImage(stream);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ImagePDFApi.UploadImage: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stream** | **System.IO.Stream**| The first binary image or PDF (file/inputstream) to convert to PDF | 

### Return type

[**PDFJobResponse**](PDFJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

