# Sphereon.SDK.Pdf.Model.PDFJobResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Links** | [**Dictionary&lt;string, Link&gt;**](Link.md) |  | [optional] 
**CompletionTime** | **DateTime?** | The completion date/time of this job in ISO 8601 format | [optional] 
**CreationTime** | **DateTime?** | The creation date/time of this job in ISO 8601 format | [optional] 
**Images** | **List&lt;string&gt;** | The original images. Currently only a single image is supported. The image can be a multipage tiff however | 
**Job** | [**PDFJob**](PDFJob.md) |  | [optional] 
**JobId** | **string** |  | [optional] 
**Owner** | **string** |  | [optional] 
**QueueTime** | **DateTime?** | The conversion queue date/time of this job in ISO 8601 format | [optional] 
**Status** | **string** | The status of the job | 
**StatusMessage** | **string** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse | [optional] 
**Tasks** | [**List&lt;OcrEngineTask&gt;**](OcrEngineTask.md) | The server supplied engine task(s) | [optional] 
**UpdateTime** | **DateTime?** | The last update date/time of this job in ISO 8601 format | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

