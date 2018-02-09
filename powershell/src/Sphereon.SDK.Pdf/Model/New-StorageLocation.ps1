        function New-StorageLocation {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${folderPath},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${id},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${containerId}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.StorageLocation' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.StorageLocation -ArgumentList @(
            ${folderPath},
            ${id},
            ${containerId}
        )
        }
        }
