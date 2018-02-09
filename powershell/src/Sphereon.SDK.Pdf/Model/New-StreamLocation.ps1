        function New-StreamLocation {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${folderPath},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${filename},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${name},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${id},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${containerId},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${originalFilename}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.StreamLocation' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.StreamLocation -ArgumentList @(
            ${folderPath},
            ${filename},
            ${name},
            ${id},
            ${containerId},
            ${originalFilename}
        )
        }
        }
