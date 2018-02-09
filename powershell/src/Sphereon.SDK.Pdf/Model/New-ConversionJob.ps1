        function New-ConversionJob {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [String]            
            ${jobId},
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [Sphereon.SDK.Pdf.Model.ConversionSettings]            
            ${settings}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.ConversionJob' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.ConversionJob -ArgumentList @(
            ${jobId},
            ${settings}
        )
        }
        }
