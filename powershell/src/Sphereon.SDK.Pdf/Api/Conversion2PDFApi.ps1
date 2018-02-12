function Submit-PDFAddInputFile {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [String]
        ${jobid},
        [Parameter(Position = 1, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [System.IO.Stream]
        ${stream},
        [Parameter(Position = 2, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${fileName}
    )

    Process {
        'Calling method: Conversion2PDFApi-AddInputFile' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:Conversion2PDFApi.AddInputFile(
            ${jobid},
            ${stream},
            ${fileName}
        )
    }
}

function Submit-PDFAddInputStreamLocations {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [String]
        ${jobid},
        [Parameter(Position = 1, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [Sphereon.SDK.Pdf.Model.StreamLocation[]]
        ${inputStreamLocations}
    )

    Process {
        'Calling method: Conversion2PDFApi-AddInputStreamLocations' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:Conversion2PDFApi.AddInputStreamLocations(
            ${jobid},
            ${inputStreamLocations}
        )
    }
}

function Submit-PDFCreateJob {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [Sphereon.SDK.Pdf.Model.ConversionSettings]
        ${settings}
    )

    Process {
        'Calling method: Conversion2PDFApi-CreateJob' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:Conversion2PDFApi.CreateJob(
            ${settings}
        )
    }
}

function Submit-PDFDeleteJob {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [String]
        ${jobid}
    )

    Process {
        'Calling method: Conversion2PDFApi-DeleteJob' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:Conversion2PDFApi.DeleteJob(
            ${jobid}
        )
    }
}

function Submit-PDFGetJob {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [String]
        ${jobid}
    )

    Process {
        'Calling method: Conversion2PDFApi-GetJob' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:Conversion2PDFApi.GetJob(
            ${jobid}
        )
    }
}

function Submit-PDFGetJobs {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String[]]
        ${status}
    )

    Process {
        'Calling method: Conversion2PDFApi-GetJobs' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:Conversion2PDFApi.GetJobs(
            ${status}
        )
    }
}

function Submit-PDFGetStream {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [String]
        ${jobid}
    )

    Process {
        'Calling method: Conversion2PDFApi-GetStream' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:Conversion2PDFApi.GetStream(
            ${jobid}
        )
    }
}

function Submit-PDFSubmitJob {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [String]
        ${jobid},
        [Parameter(Position = 1, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [Sphereon.SDK.Pdf.Model.ConversionJob]
        ${job}
    )

    Process {
        'Calling method: Conversion2PDFApi-SubmitJob' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:Conversion2PDFApi.SubmitJob(
            ${jobid},
            ${job}
        )
    }
}

