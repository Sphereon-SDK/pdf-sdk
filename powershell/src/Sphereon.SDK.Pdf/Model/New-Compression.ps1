function New-Compression
{
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [Int32] ${level} = 5,
        [Parameter(Position = 1, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${type} = "ADVANCED"
    )

    Process {
        'Creating object: Sphereon.SDK.Pdf.Model.Compression' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.Compression -ArgumentList @(${level}, ${type})
    }
}
