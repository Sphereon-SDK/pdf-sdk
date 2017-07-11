# Sphereon.SDK.Pdf.Model.ConversionJobResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**CreationTime** | **DateTime?** | The creation date/time of this job in ISO 8601 format | [optional] 
**Inputs** | **List&lt;string&gt;** | The original input files. Currently supported inputs are: inputs, pdfs and office files | 
**ConversionTasks** | [**List&lt;ConversionTask&gt;**](ConversionTask.md) |  | [optional] 
**UpdateTime** | **DateTime?** | The last update date/time of this job in ISO 8601 format | [optional] 
**StatusMessage** | **string** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse | [optional] 
**QueueTime** | **DateTime?** | The conversion queue date/time of this job in ISO 8601 format | [optional] 
**CompletionTime** | **DateTime?** | The completion date/time of this job in ISO 8601 format | [optional] 
**JobId** | **string** |  | [optional] 
**InputLocations** | [**List&lt;StreamLocation&gt;**](StreamLocation.md) | The storage locations of the input files. | 
**ResultLocations** | [**List&lt;StreamLocation&gt;**](StreamLocation.md) | The storage locations of the result files. | 
**Job** | [**ConversionJob**](ConversionJob.md) |  | [optional] 
**ResultLocationUrls** | **List&lt;string&gt;** | The storage location URL&#39;s of the result files. | [optional] 
**Status** | **string** | The status of the job | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

