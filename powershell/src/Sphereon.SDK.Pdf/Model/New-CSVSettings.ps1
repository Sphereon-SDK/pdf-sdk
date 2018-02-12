function New-CSVSettings
{
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${separatorCharacter},

        [Parameter(Position = 1, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Double] ${standardRowHeight},

        [Parameter(Position = 2, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Double] ${standardColumnWidth}
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
