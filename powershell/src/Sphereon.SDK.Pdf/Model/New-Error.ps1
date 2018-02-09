        function New-Error {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [String]            
            ${code},
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [String]            
            ${level},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Sphereon.SDK.Pdf.Model.Error]]            
            ${cause},
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [String]            
            ${message}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.Error' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.Error -ArgumentList @(
            ${code},
            ${level},
            ${cause},
            ${message}
        )
        }
        }
