
# ConversionSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**qualityFactor** | **Integer** | Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest) |  [optional]
**result** | [**ResultSettings**](ResultSettings.md) | The result file and lifecycle settings |  [optional]
**input** | [**InputSettings**](InputSettings.md) | The input file and lifecycle settings |  [optional]
**engine** | [**EngineEnum**](#EngineEnum) | Engine to use for conversion. Costs apply. Default engine : ADVANCED |  [optional]
**csv** | [**CSVSettings**](CSVSettings.md) |  |  [optional]
**containerConversion** | [**ContainerConversionEnum**](#ContainerConversionEnum) | Specify which container to process. Currently used for email (ALL&#x3D;Both message and attachments, MAIN&#x3D;Only message, SUB&#x3D;attachments |  [optional]
**version** | [**VersionEnum**](#VersionEnum) | The PDF version to use for conversion. Default value : PDF_1_7 |  [optional]
**jobLifecycle** | [**Lifecycle**](Lifecycle.md) | The lifecycle of the job itself |  [optional]
**ocrMode** | [**OcrModeEnum**](#OcrModeEnum) | Specify if a file must be processed by OCR engine. Default ocrMode : AUTO (only when not already processed) |  [optional]


<a name="EngineEnum"></a>
## Enum: EngineEnum
Name | Value
---- | -----
BASIC | &quot;BASIC&quot;
ADVANCED | &quot;ADVANCED&quot;
PREMIUM | &quot;PREMIUM&quot;


<a name="ContainerConversionEnum"></a>
## Enum: ContainerConversionEnum
Name | Value
---- | -----
ALL | &quot;ALL&quot;
MAIN | &quot;MAIN&quot;
SUB | &quot;SUB&quot;


<a name="VersionEnum"></a>
## Enum: VersionEnum
Name | Value
---- | -----
_1_4 | &quot;PDF_1_4&quot;
_1_5 | &quot;PDF_1_5&quot;
_1_6 | &quot;PDF_1_6&quot;
_1_7 | &quot;PDF_1_7&quot;
A_1B | &quot;PDF_A_1b&quot;


<a name="OcrModeEnum"></a>
## Enum: OcrModeEnum
Name | Value
---- | -----
ALWAYS | &quot;ALWAYS&quot;
NEVER | &quot;NEVER&quot;
AUTO | &quot;AUTO&quot;



