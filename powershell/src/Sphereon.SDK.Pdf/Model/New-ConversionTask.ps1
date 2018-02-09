        function New-ConversionTask {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${jobId},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${queueId},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${engine},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Sphereon.SDK.Pdf.Model.ConversionTaskInput]]            
            ${conversionInput},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${documentId},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${status}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.ConversionTask' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.ConversionTask -ArgumentList @(
            ${jobId},
            ${queueId},
            ${engine},
            ${conversionInput},
            ${documentId},
            ${status}
        )
        }
        }
