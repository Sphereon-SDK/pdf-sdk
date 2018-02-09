        function New-Compression {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[Int32]]            
            ${level},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${type}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.Compression' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.Compression -ArgumentList @(
            ${level},
            ${type}
        )
        }
        }
