function New-PDFStreamLocation
{
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${folderPath},

        [Parameter(Position = 1, Mandatory = $true, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${filename},

        [Parameter(Position = 2, Mandatory = $true, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${containerId},

        [Parameter(Position = 3, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${originalFilename}
    )

    Process {
        'Creating object: Sphereon.SDK.Pdf.Model.StreamLocation' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.StreamLocation -ArgumentList @(
        ${folderPath},
        ${filename},
        ${containerId},
        ${originalFilename}
        )
    }
}
