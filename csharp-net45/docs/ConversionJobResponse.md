# Sphereon.SDK.Pdf.Model.ConversionJobResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**CompletionTime** | **DateTime?** | The completion date/time of this job in ISO 8601 format | [optional] 
**JobId** | **string** |  | [optional] 
**CreationTime** | **DateTime?** | The creation date/time of this job in ISO 8601 format | [optional] 
**Inputs** | **List&lt;string&gt;** | The original input files. Currently supported inputs are: inputs, pdfs and office files | 
**ConversionTasks** | [**List&lt;ConversionTask&gt;**](ConversionTask.md) |  | [optional] 
**UpdateTime** | **DateTime?** | The last update date/time of this job in ISO 8601 format | [optional] 
**Job** | [**ConversionJob**](ConversionJob.md) |  | [optional] 
**StatusMessage** | **string** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse | [optional] 
**QueueTime** | **DateTime?** | The conversion queue date/time of this job in ISO 8601 format | [optional] 
**Status** | **string** | The status of the job | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

