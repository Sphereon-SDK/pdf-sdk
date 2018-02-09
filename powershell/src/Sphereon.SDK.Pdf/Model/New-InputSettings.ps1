        function New-InputSettings {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Sphereon.SDK.Pdf.Model.Lifecycle]]            
            ${lifecycle},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Sphereon.SDK.Pdf.Model.StorageLocation]]            
            ${storageLocation}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.InputSettings' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.InputSettings -ArgumentList @(
            ${lifecycle},
            ${storageLocation}
        )
        }
        }
