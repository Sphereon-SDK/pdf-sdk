# Pdf.ConversionJobResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**result** | [**ResultResponse**](ResultResponse.md) | The result(s) | [optional] 
**completionTime** | **Date** | The completion date/time of this job in ISO 8601 format | [optional] 
**input** | [**InputResponse**](InputResponse.md) | The input(s) | [optional] 
**jobId** | **String** |  | [optional] 
**creationTime** | **Date** | The creation date/time of this job in ISO 8601 format | [optional] 
**conversionTasks** | [**[ConversionTask]**](ConversionTask.md) |  | [optional] 
**updateTime** | **Date** | The last update date/time of this job in ISO 8601 format | [optional] 
**job** | [**ConversionJob**](ConversionJob.md) |  | [optional] 
**statusMessage** | **String** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse | [optional] 
**queueTime** | **Date** | The conversion queue date/time of this job in ISO 8601 format | [optional] 
**status** | **String** | The status of the job | 


<a name="StatusEnum"></a>
## Enum: StatusEnum


* `INIT` (value: `"INIT"`)

* `INPUTS_UPLOADED` (value: `"INPUTS_UPLOADED"`)

* `PROCESSING` (value: `"PROCESSING"`)

* `DONE` (value: `"DONE"`)

* `ERROR` (value: `"ERROR"`)

* `DELETED` (value: `"DELETED"`)




