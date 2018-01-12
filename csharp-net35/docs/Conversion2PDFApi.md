# Sphereon.SDK.Pdf.Api.Conversion2PDFApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/pdf/1.1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AddInputFile**](Conversion2PDFApi.md#addinputfile) | **POST** /conversion2pdf/jobs/{jobid}/streams/multipart | Upload a file
[**AddInputStreamLocations**](Conversion2PDFApi.md#addinputstreamlocations) | **POST** /conversion2pdf/jobs/{jobid}/streams/location | Add Input Stream Location(s)
[**CreateJob**](Conversion2PDFApi.md#createjob) | **POST** /conversion2pdf/jobs | Create a PDF conversion job
[**DeleteJob**](Conversion2PDFApi.md#deletejob) | **DELETE** /conversion2pdf/jobs/{jobid} | Delete a job manually
[**GetJob**](Conversion2PDFApi.md#getjob) | **GET** /conversion2pdf/jobs/{jobid} | Job definition and state
[**GetJobs**](Conversion2PDFApi.md#getjobs) | **GET** /conversion2pdf/jobs | Get all jobs
[**GetStream**](Conversion2PDFApi.md#getstream) | **GET** /conversion2pdf/jobs/{jobid}/streams/result | Get the current result stream
[**SubmitJob**](Conversion2PDFApi.md#submitjob) | **PUT** /conversion2pdf/jobs/{jobid} | Submit PDF job for processing


<a name="addinputfile"></a>
# **AddInputFile**
> ConversionJobResponse AddInputFile (string jobid, System.IO.Stream stream, string fileName = null)

Upload a file

Upload an image, office or pdf for conversion to PDF. Please note that you can upload multiple files. Conversion will not be started yet.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class AddInputFileExample
    {
        public void main()
        {
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new Conversion2PDFApi();
            var jobid = jobid_example;  // string | jobid
            var stream = new System.IO.Stream(); // System.IO.Stream | The (additional) binary image or PDF (file/inputstream) to convert to PDF
            var fileName = fileName_example;  // string | Optional input file name. (optional) 

            try
            {
                // Upload a file
                ConversionJobResponse result = apiInstance.AddInputFile(jobid, stream, fileName);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling Conversion2PDFApi.AddInputFile: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 
 **stream** | **System.IO.Stream**| The (additional) binary image or PDF (file/inputstream) to convert to PDF | 
 **fileName** | **string**| Optional input file name. | [optional] 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="addinputstreamlocations"></a>
# **AddInputStreamLocations**
> ConversionJobResponse AddInputStreamLocations (string jobid, List<StreamLocation> inputStreamLocations)

Add Input Stream Location(s)

Add image, office or pdf input stream location(s) from the storage API for conversion to PDF. Please note that you can upload multiple files. Conversion will not be started yet.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class AddInputStreamLocationsExample
    {
        public void main()
        {
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new Conversion2PDFApi();
            var jobid = jobid_example;  // string | jobid
            var inputStreamLocations = new List<StreamLocation>(); // List<StreamLocation> | The (additional) binary image or PDF (file/inputstream) to convert to PDF

            try
            {
                // Add Input Stream Location(s)
                ConversionJobResponse result = apiInstance.AddInputStreamLocations(jobid, inputStreamLocations);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling Conversion2PDFApi.AddInputStreamLocations: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 
 **inputStreamLocations** | [**List&lt;StreamLocation&gt;**](StreamLocation.md)| The (additional) binary image or PDF (file/inputstream) to convert to PDF | 

### Return type

[**ConversionJobResponse**](ConversionJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="createjob"></a>
# **CreateJob**
> ConversionJobResponse CreateJob (ConversionSettings settings = null)

Create a PDF conversion job

Create a PDF conversion job using optional settings supplied, otherwise defaults will be used

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Client;
using Sphereon.SDK.Pdf.Model;

namespace Example
{
    public class CreateJobExample
    {
        public void main()
        {
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new Conversion2PDFApi();
            var settings = new ConversionSettings(); // ConversionSettings | Optional settings to use for this job (optional) 

            try
            {
                // Create a PDF conversion job
                ConversionJobResponse result = apiInstance.CreateJob(settings);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling Conversion2PDFApi.CreateJob: " + e.Message );
            }
        }
    }
}
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="deletejob"></a>
# **DeleteJob**
> ConversionJobResponse DeleteJob (string jobid)

Delete a job manually

Delete the PDF job and all related files.

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

            var apiInstance = new Conversion2PDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Delete a job manually
                ConversionJobResponse result = apiInstance.DeleteJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling Conversion2PDFApi.DeleteJob: " + e.Message );
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

Get the PDF job definition and current state. Please note that you can differentiate based on http response status.

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

            var apiInstance = new Conversion2PDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Job definition and state
                ConversionJobResponse result = apiInstance.GetJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling Conversion2PDFApi.GetJob: " + e.Message );
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

            var apiInstance = new Conversion2PDFApi();
            var status = new List<string>(); // List<string> | A list of status to filter on. (optional) 

            try
            {
                // Get all jobs
                ConversionJobResponse result = apiInstance.GetJobs(status);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling Conversion2PDFApi.GetJobs: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List&lt;string&gt;**](string.md)| A list of status to filter on. | [optional] 

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

Get the PDF as binary stream/file.  Our API generation does not allow changing the media type based on the Accepted header unfortunately.<br/>This means we use a seperate path postfix with the value '/stream'.  This API only returns the PDF when the response status.

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

            var apiInstance = new Conversion2PDFApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Get the current result stream
                byte[] result = apiInstance.GetStream(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling Conversion2PDFApi.GetStream: " + e.Message );
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

Start PDF conversion. Convert the previously uploaded file(s) to PDF. The settings supplied with the job in the request body are used for the conversion. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request.

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

            var apiInstance = new Conversion2PDFApi();
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
                Debug.Print("Exception when calling Conversion2PDFApi.SubmitJob: " + e.Message );
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

