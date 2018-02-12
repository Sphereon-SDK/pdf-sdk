function New-ResultSettings
{
    [CmdletBinding()]
    Param (
        [Parameter(ValueFromPipeLine = $true, Position = 0, Mandatory = $false, ValueFromPipelineByPropertyName = $true)]
        [Sphereon.SDK.Pdf.Model.Lifecycle] ${lifecycle},

        [Parameter(ValueFromPipeLine = $true, Position = 1, Mandatory = $false, ValueFromPipelineByPropertyName = $true)]
        [Sphereon.SDK.Pdf.Model.StorageLocation] ${storageLocation},

        [Parameter(ValueFromPipeLine = $true, Position = 2, Mandatory = $false, ValueFromPipelineByPropertyName = $true)]
        [Sphereon.SDK.Pdf.Model.Compression] ${compression},
        
        [Parameter(ValueFromPipeLine = $true, Position = 3, Mandatory = $false, ValueFromPipelineByPropertyName = $true)]
        [String] ${fileFormat} = "PDF"

    )

    Process {
        'Creating object: Sphereon.SDK.Pdf.Model.ResultSettings' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug
        New-Object -TypeName Sphereon.SDK.Pdf.Model.ResultSettings -ArgumentList @(
        ${lifecycle},
        ${storageLocation},
        ${compression},
        ${fileFormat}
        )
    }
}
