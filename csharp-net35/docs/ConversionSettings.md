# Sphereon.SDK.Pdf.Model.ConversionSettings
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**QualityFactor** | **int?** | Set the quality factor for the resulting PDF. Range from 0 (lowest) to 10 (highest) | [optional] 
**Result** | [**ResultSettings**](ResultSettings.md) | The result file and lifecycle settings | [optional] 
**Input** | [**InputSettings**](InputSettings.md) | The input file and lifecycle settings | [optional] 
**Engine** | **string** | Engine to use for conversion. Costs apply. Default engine : ADVANCED | [optional] 
**Csv** | [**CSVSettings**](CSVSettings.md) |  | [optional] 
**ContainerConversion** | **string** | Specify which container to process. Currently used for email (ALL&#x3D;Both message and attachments, MAIN&#x3D;Only message, SUB&#x3D;attachments | [optional] 
**Version** | **string** | The PDF version to use for conversion. Default value : PDF_1_7 | [optional] 
**JobLifecycle** | [**Lifecycle**](Lifecycle.md) | The lifecycle of the job itself | [optional] 
**OcrMode** | **string** | Specify if a file must be processed by OCR engine. Default ocrMode : AUTO (only when not already processed) | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

