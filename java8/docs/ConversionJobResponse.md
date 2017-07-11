
# ConversionJobResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**creationTime** | [**OffsetDateTime**](OffsetDateTime.md) | The creation date/time of this job in ISO 8601 format |  [optional]
**inputs** | **List&lt;String&gt;** | The original input files. Currently supported inputs are: inputs, pdfs and office files | 
**conversionTasks** | [**List&lt;ConversionTask&gt;**](ConversionTask.md) |  |  [optional]
**updateTime** | [**OffsetDateTime**](OffsetDateTime.md) | The last update date/time of this job in ISO 8601 format |  [optional]
**statusMessage** | **String** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse |  [optional]
**queueTime** | [**OffsetDateTime**](OffsetDateTime.md) | The conversion queue date/time of this job in ISO 8601 format |  [optional]
**completionTime** | [**OffsetDateTime**](OffsetDateTime.md) | The completion date/time of this job in ISO 8601 format |  [optional]
**jobId** | **String** |  |  [optional]
**inputLocations** | [**List&lt;StreamLocation&gt;**](StreamLocation.md) | The storage locations of the input files. | 
**resultLocations** | [**List&lt;StreamLocation&gt;**](StreamLocation.md) | The storage locations of the result files. | 
**job** | [**ConversionJob**](ConversionJob.md) |  |  [optional]
**resultLocationUrls** | **List&lt;String&gt;** | The storage location URL&#39;s of the result files. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the job | 


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
INPUTS_UPLOADED | &quot;INPUTS_UPLOADED&quot;
PROCESSING | &quot;PROCESSING&quot;
DONE | &quot;DONE&quot;
ERROR | &quot;ERROR&quot;
DELETED | &quot;DELETED&quot;



