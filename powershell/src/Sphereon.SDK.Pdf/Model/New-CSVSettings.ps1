        function New-CSVSettings {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${separatorCharacter},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Double]]            
            ${standardRowHeight},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Double]]            
            ${standardColumnWidth}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.CSVSettings' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.CSVSettings -ArgumentList @(
            ${separatorCharacter},
            ${standardRowHeight},
            ${standardColumnWidth}
        )
        }
        }
