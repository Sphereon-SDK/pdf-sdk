function New-StorageLocation
{
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${folderPath},

        [Parameter(Position = 1, Mandatory = $true, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${containerId}
    )

    Process {
        'Creating object: Sphereon.SDK.Pdf.Model.StorageLocation' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.StorageLocation -ArgumentList @(
        ${folderPath},
        ${containerId}
        )
    }
}
