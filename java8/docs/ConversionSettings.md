
# ConversionSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lifecycle** | [**Lifecycle**](Lifecycle.md) |  |  [optional]
**qualityFactor** | **Integer** | Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest) |  [optional]
**outputFileName** | **String** |  |  [optional]
**engine** | [**EngineEnum**](#EngineEnum) |  |  [optional]
**compression** | [**Compression**](Compression.md) |  |  [optional]
**containerConversion** | [**ContainerConversionEnum**](#ContainerConversionEnum) |  |  [optional]
**version** | [**VersionEnum**](#VersionEnum) |  |  [optional]
**csvSettings** | [**CSVSettings**](CSVSettings.md) |  |  [optional]
**outputFileFormat** | [**OutputFileFormatEnum**](#OutputFileFormatEnum) |  |  [optional]
**ocrMode** | [**OcrModeEnum**](#OcrModeEnum) |  |  [optional]


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


<a name="OutputFileFormatEnum"></a>
## Enum: OutputFileFormatEnum
Name | Value
---- | -----
TIFF | &quot;TIFF&quot;
PDF | &quot;PDF&quot;
XLSX | &quot;XLSX&quot;
DOCX | &quot;DOCX&quot;


<a name="OcrModeEnum"></a>
## Enum: OcrModeEnum
Name | Value
---- | -----
ALWAYS | &quot;ALWAYS&quot;
NEVER | &quot;NEVER&quot;
AUTO | &quot;AUTO&quot;



