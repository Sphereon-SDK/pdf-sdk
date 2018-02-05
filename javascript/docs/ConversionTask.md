# Pdf.ConversionTask

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**jobId** | **String** | The current job Id | [optional] 
**queueId** | **String** | The queue Id provided by a backend system | [optional] 
**engine** | **String** | The Engine being used | [optional] 
**conversionInput** | [**ConversionTaskInput**](ConversionTaskInput.md) | Conversion input | [optional] 
**documentId** | **String** | The document Id provided by a backend system | [optional] 
**status** | **String** | The status of the Conversion task itself | [optional] 


<a name="EngineEnum"></a>
## Enum: EngineEnum


* `ADVANCED` (value: `"ADVANCED"`)

* `PREMIUM` (value: `"PREMIUM"`)

* `BASIC` (value: `"BASIC"`)




<a name="StatusEnum"></a>
## Enum: StatusEnum


* `REQUESTED` (value: `"REQUESTED"`)

* `QUEUED` (value: `"QUEUED"`)

* `PROCESSING` (value: `"PROCESSING"`)

* `DONE` (value: `"DONE"`)

* `ERROR` (value: `"ERROR"`)




