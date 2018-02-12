function New-InputSettings
{
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Sphereon.SDK.Pdf.Model.Lifecycle] ${lifecycle},

        [Parameter(Position = 1, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Sphereon.SDK.Pdf.Model.StorageLocation] ${storageLocation}
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
