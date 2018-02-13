# Pdf.ConversionSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**qualityFactor** | **Number** | Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest) | [optional] 
**result** | [**ResultSettings**](ResultSettings.md) | The result file and lifecycle settings | [optional] 
**input** | [**InputSettings**](InputSettings.md) | The input file and lifecycle settings | [optional] 
**engine** | **String** | Engine to use for conversion. Costs apply. Default engine : ADVANCED | [optional] 
**csv** | [**CSVSettings**](CSVSettings.md) |  | [optional] 
**containerConversion** | **String** | Specify which container to process. Currently used for email (ALL&#x3D;Both message and attachments, MAIN&#x3D;Only message, SUB&#x3D;attachments | [optional] 
**version** | **String** | The PDF version to use for conversion. Default value : PDF_1_7 | [optional] 
**jobLifecycle** | [**Lifecycle**](Lifecycle.md) | The lifecycle of the job itself | [optional] 
**ocrMode** | **String** | Specify if a file must be processed by OCR engine. Default ocrMode : AUTO (only when not already processed) | [optional] 


<a name="EngineEnum"></a>
## Enum: EngineEnum


* `BASIC` (value: `"BASIC"`)

* `ADVANCED` (value: `"ADVANCED"`)

* `PREMIUM` (value: `"PREMIUM"`)




<a name="ContainerConversionEnum"></a>
## Enum: ContainerConversionEnum


* `ALL` (value: `"ALL"`)

* `MAIN` (value: `"MAIN"`)

* `SUB` (value: `"SUB"`)




<a name="VersionEnum"></a>
## Enum: VersionEnum


* `1_4` (value: `"PDF_1_4"`)

* `1_5` (value: `"PDF_1_5"`)

* `1_6` (value: `"PDF_1_6"`)

* `1_7` (value: `"PDF_1_7"`)

* `A_1b` (value: `"PDF_A_1b"`)




<a name="OcrModeEnum"></a>
## Enum: OcrModeEnum


* `ALWAYS` (value: `"ALWAYS"`)

* `NEVER` (value: `"NEVER"`)

* `AUTO` (value: `"AUTO"`)




