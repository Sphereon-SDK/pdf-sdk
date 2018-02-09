        function New-ConversionSettings {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Int32]]            
            ${qualityFactor},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Sphereon.SDK.Pdf.Model.ResultSettings]]            
            ${result},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Sphereon.SDK.Pdf.Model.InputSettings]]            
            ${input},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${engine},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Sphereon.SDK.Pdf.Model.CSVSettings]]            
            ${csv},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${containerConversion},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${version},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Sphereon.SDK.Pdf.Model.Lifecycle]]            
            ${jobLifecycle},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${ocrMode}
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
