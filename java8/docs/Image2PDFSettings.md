
# Image2PDFSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**compression** | [**Compression**](Compression.md) |  |  [optional]
**engine** | [**EngineEnum**](#EngineEnum) |  |  [optional]
**lifecycle** | [**Lifecycle**](Lifecycle.md) |  |  [optional]
**ocr** | **Boolean** | Whether to perform OCR. When set to false the text in the PDF will not be searchable |  [optional]
**qualityFactor** | **Integer** | Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest) |  [optional]
**resultFileName** | **String** |  |  [optional]
**version** | [**VersionEnum**](#VersionEnum) |  |  [optional]


<a name="EngineEnum"></a>
## Enum: EngineEnum
Name | Value
---- | -----
BASIC | &quot;BASIC&quot;
ADVANCED | &quot;ADVANCED&quot;


<a name="VersionEnum"></a>
## Enum: VersionEnum
Name | Value
---- | -----
_1_4 | &quot;PDF_1_4&quot;
_1_5 | &quot;PDF_1_5&quot;
_1_6 | &quot;PDF_1_6&quot;
_1_7 | &quot;PDF_1_7&quot;
A_1B | &quot;PDF_A_1b&quot;



