
# ConversionJobResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**result** | [**ResultResponse**](ResultResponse.md) | The result(s) |  [optional]
**completionTime** | [**OffsetDateTime**](OffsetDateTime.md) | The completion date/time of this job in ISO 8601 format |  [optional]
**input** | [**InputResponse**](InputResponse.md) | The input(s) |  [optional]
**jobId** | **String** |  |  [optional]
**creationTime** | [**OffsetDateTime**](OffsetDateTime.md) | The creation date/time of this job in ISO 8601 format |  [optional]
**conversionTasks** | [**List&lt;ConversionTask&gt;**](ConversionTask.md) |  |  [optional]
**updateTime** | [**OffsetDateTime**](OffsetDateTime.md) | The last update date/time of this job in ISO 8601 format |  [optional]
**job** | [**ConversionJob**](ConversionJob.md) | The job |  [optional]
**statusMessage** | **String** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse |  [optional]
**queueTime** | [**OffsetDateTime**](OffsetDateTime.md) | The conversion queue date/time of this job in ISO 8601 format |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the job | 


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
INIT | &quot;INIT&quot;
INPUTS_UPLOADED | &quot;INPUTS_UPLOADED&quot;
PROCESSING | &quot;PROCESSING&quot;
DONE | &quot;DONE&quot;
ERROR | &quot;ERROR&quot;
DELETED | &quot;DELETED&quot;



