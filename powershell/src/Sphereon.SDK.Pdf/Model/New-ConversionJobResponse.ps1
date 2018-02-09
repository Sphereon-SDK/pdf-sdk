        function New-ConversionJobResponse {
        [CmdletBinding()]
        Param (
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [Sphereon.SDK.Pdf.Model.ResultResponse]            
            ${result},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[System.DateTime]]            
            ${completionTime},
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [Sphereon.SDK.Pdf.Model.InputResponse]            
            ${input},
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [String]            
            ${jobId},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[System.DateTime]]            
            ${creationTime},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [Sphereon.SDK.Pdf.Model.ConversionTask[]]            
            ${conversionTasks},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[System.DateTime]]            
            ${updateTime},
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [Sphereon.SDK.Pdf.Model.ConversionJob]            
            ${job},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [String]            
            ${statusMessage},
            [Parameter(ValueFromPipelineByPropertyName = $true)]
            [System.Nullable[System.DateTime]]            
            ${queueTime},
            [Parameter(ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
            [String]            
            ${status}
        )

        Process {
        'Creating object: Sphereon.SDK.Pdf.Model.ConversionJobResponse' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        New-Object -TypeName Sphereon.SDK.Pdf.Model.ConversionJobResponse -ArgumentList @(
            ${result},
            ${completionTime},
            ${input},
            ${jobId},
            ${creationTime},
            ${conversionTasks},
            ${updateTime},
            ${job},
            ${statusMessage},
            ${queueTime},
            ${status}
        )
        }
        }
