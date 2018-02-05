# Pdf.Lifecycle

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**applicableJobStatusses** | **[String]** | Job status needs to be in this list in order for the action to be performed! | [optional] 
**action** | **String** |  | [optional] 
**type** | **String** |  | [optional] 


<a name="[ApplicableJobStatussesEnum]"></a>
## Enum: [ApplicableJobStatussesEnum]


* `INIT` (value: `"INIT"`)

* `INPUTS_UPLOADED` (value: `"INPUTS_UPLOADED"`)

* `PROCESSING` (value: `"PROCESSING"`)

* `DONE` (value: `"DONE"`)

* `ERROR` (value: `"ERROR"`)

* `DELETED` (value: `"DELETED"`)




<a name="ActionEnum"></a>
## Enum: ActionEnum


* `DELETE` (value: `"DELETE"`)

* `NONE` (value: `"NONE"`)




<a name="TypeEnum"></a>
## Enum: TypeEnum


* `RETRIEVAL` (value: `"RETRIEVAL"`)




