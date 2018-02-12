function New-ConversionSettings
{
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Int32] ${qualityFactor},
        
        [Parameter(Position = 1, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Sphereon.SDK.Pdf.Model.ResultSettings] ${result},
        
        [Parameter(Position = 2, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Sphereon.SDK.Pdf.Model.InputSettings] ${input},

        [Parameter(Position = 3, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${engine},

        [Parameter(Position = 4, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Sphereon.SDK.Pdf.Model.CSVSettings] ${csv},

        [Parameter(Position = 5, Mandatory=$false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${containerConversion},

        [Parameter(Position = 6, Mandatory=$false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${version} = "_1_7",

        [Parameter(Position = 7, Mandatory=$false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Sphereon.SDK.Pdf.Model.Lifecycle] ${jobLifecycle},

        [Parameter(Position = 8, Mandatory=$false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${ocrMode}
    )

    Process {
        'Creating object: Sphereon.SDK.Pdf.Model.ConversionSettings' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.ConversionSettings -ArgumentList @(
        ${qualityFactor},
        ${result},
        ${input},
        ${engine},
        ${csv},
        ${containerConversion},
        ${version},
        ${jobLifecycle},
        ${ocrMode}
        )
    }
}
