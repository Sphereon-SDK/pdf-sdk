        function New-ConversionTaskInput {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [Sphereon.SDK.Pdf.Model.StreamLocation[]]            
            ${streamLocations}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.ConversionTaskInput' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.ConversionTaskInput -ArgumentList @(
            ${streamLocations}
        )
        }
        }
