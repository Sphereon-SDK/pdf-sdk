        function New-Lifecycle {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String[]]            
            ${applicableJobStatusses},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${action},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${type}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.Lifecycle' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.Lifecycle -ArgumentList @(
            ${applicableJobStatusses},
            ${action},
            ${type}
        )
        }
        }
