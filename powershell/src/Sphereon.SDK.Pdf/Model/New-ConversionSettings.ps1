function New-PDFConversionSettings
{
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, Mandatory = $false)]
        [Int32] ${qualityFactor},

        [Parameter(Position = 1, Mandatory = $false)]
        [Sphereon.SDK.Pdf.Model.ResultSettings] ${resultSettings},

        [Parameter(Position = 2, Mandatory = $false)]
        [Sphereon.SDK.Pdf.Model.InputSettings] ${inputSettings},

        [Parameter(Position = 3, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${engine} = "ADVANCED",

        [Parameter(Position = 4, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Sphereon.SDK.Pdf.Model.CSVSettings] ${csv},

        [Parameter(Position = 5, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${containerConversion} = "ALL",

        [Parameter(Position = 6, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${version} = "_17",

        [Parameter(Position = 7, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Sphereon.SDK.Pdf.Model.Lifecycle] ${jobLifecycle},

        [Parameter(Position = 8, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${ocrMode} = "AUTO"
    )

    Process {
        'Creating object: Sphereon.SDK.Pdf.Model.ConversionSettings' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.ConversionSettings -ArgumentList @(
        ${qualityFactor},
        ${resultSettings},
        ${inputSettings},
        ${engine},
        ${csv},
        ${containerConversion},
        ${version},
        ${jobLifecycle},
        ${ocrMode}
        )
    }
}
