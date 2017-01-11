
# ConversionSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lifecycle** | [**Lifecycle**](Lifecycle.md) |  |  [optional]
**qualityFactor** | **Integer** | Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest) |  [optional]
**resultFileName** | **String** |  |  [optional]
**engine** | [**EngineEnum**](#EngineEnum) |  |  [optional]
**compression** | [**Compression**](Compression.md) |  |  [optional]
**version** | [**VersionEnum**](#VersionEnum) |  |  [optional]
**conversionStructure** | [**ConversionStructureEnum**](#ConversionStructureEnum) |  |  [optional]
**fileFormat** | [**FileFormatEnum**](#FileFormatEnum) |  |  [optional]
**ocrMode** | [**OcrModeEnum**](#OcrModeEnum) |  |  [optional]


<a name="EngineEnum"></a>
## Enum: EngineEnum
Name | Value
---- | -----
BASIC | &quot;BASIC&quot;
ADVANCED | &quot;ADVANCED&quot;
PREMIUM | &quot;PREMIUM&quot;


<a name="VersionEnum"></a>
## Enum: VersionEnum
Name | Value
---- | -----
_1_4 | &quot;PDF_1_4&quot;
_1_5 | &quot;PDF_1_5&quot;
_1_6 | &quot;PDF_1_6&quot;
_1_7 | &quot;PDF_1_7&quot;
A_1B | &quot;PDF_A_1b&quot;


<a name="ConversionStructureEnum"></a>
## Enum: ConversionStructureEnum
Name | Value
---- | -----
ALL | &quot;CONVERT_ALL&quot;
MAIN | &quot;CONVERT_MAIN&quot;
SUB | &quot;CONVERT_SUB&quot;


<a name="FileFormatEnum"></a>
## Enum: FileFormatEnum
Name | Value
---- | -----
TIFF | &quot;TIFF&quot;
PDF | &quot;PDF&quot;
SPREADSHEET | &quot;SPREADSHEET&quot;
DOC | &quot;DOC&quot;


<a name="OcrModeEnum"></a>
## Enum: OcrModeEnum
Name | Value
---- | -----
ALWAYS | &quot;ALWAYS&quot;
NEVER | &quot;NEVER&quot;
IF_NECESSARY | &quot;IF_NECESSARY&quot;



