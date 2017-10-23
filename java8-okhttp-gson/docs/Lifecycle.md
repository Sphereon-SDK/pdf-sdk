
# Lifecycle

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**applicableJobStatusses** | [**List&lt;ApplicableJobStatussesEnum&gt;**](#List&lt;ApplicableJobStatussesEnum&gt;) | Job status needs to be in this list in order for the action to be performeld! |  [optional]
**action** | [**ActionEnum**](#ActionEnum) |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]


<a name="List<ApplicableJobStatussesEnum>"></a>
## Enum: List&lt;ApplicableJobStatussesEnum&gt;
Name | Value
---- | -----
INIT | &quot;INIT&quot;
INPUTS_UPLOADED | &quot;INPUTS_UPLOADED&quot;
PROCESSING | &quot;PROCESSING&quot;
DONE | &quot;DONE&quot;
ERROR | &quot;ERROR&quot;
DELETED | &quot;DELETED&quot;


<a name="ActionEnum"></a>
## Enum: ActionEnum
Name | Value
---- | -----
DELETE | &quot;DELETE&quot;
NONE | &quot;NONE&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
RETRIEVAL | &quot;RETRIEVAL&quot;



