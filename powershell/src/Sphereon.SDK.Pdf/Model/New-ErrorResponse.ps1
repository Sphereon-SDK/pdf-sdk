        function New-ErrorResponse {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [Sphereon.SDK.Pdf.Model.Error[]]            
            ${errors}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.ErrorResponse' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.ErrorResponse -ArgumentList @(
            ${errors}
        )
        }
        }
