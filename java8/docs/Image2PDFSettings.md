
# Image2PDFSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lifecycle** | [**Lifecycle**](Lifecycle.md) |  |  [optional]
**qualityFactor** | **Integer** | Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest) |  [optional]
**resultFileName** | **String** |  |  [optional]
**links** | [**Map&lt;String, Link&gt;**](Link.md) |  |  [optional]
**engine** | [**EngineEnum**](#EngineEnum) |  |  [optional]
**compression** | [**Compression**](Compression.md) |  |  [optional]
**version** | [**VersionEnum**](#VersionEnum) |  |  [optional]
**ocr** | **Boolean** | Whether to perform OCR. When set to false the text in the PDF will not be searchable |  [optional]


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



