function New-Lifecycle
{
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String[]] ${applicableJobStatusses},

        [Parameter(Position = 1, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${action} = "RETRIEVAL",
            
        [Parameter(Position = 2, Mandatory = $false, ValueFromPipelineByPropertyName = $true, ValueFromPipeline = $true)]
        [String] ${type} = "NONE"
    )

    Process {
        'Creating object: Sphereon.SDK.Pdf.Model.Lifecycle' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.Lifecycle -ArgumentList @(
        ${applicableJobStatusses},
        ${action},
        ${type}
        )
    }
}
