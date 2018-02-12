# This is an integration test for the powershell SDK
Import-Module $PSScriptRoot\..\src\Sphereon.SDK.Pdf

#[Sphereon.SDK.Pdf.Api.DebugHelper]::AttachDebugger()

$Script:Conversion2PDFApi = New-Object -TypeName Sphereon.SDK.Pdf.Api.Conversion2PDFApi -ArgumentList @($null)
$AccessToken = ${env:sphereon.tests.accesstoken}
if ($AccessToken -eq $null)
{
    throw [System.IO.IOException]"Please configure environment variable 'sphereon.tests.accesstoken' with a valid Sphereon PDF token"
}

$Script:Conversion2PDFApi.Configuration.AccessToken = $AccessToken



Describe 'Sphereon.SDK.Pdf Conversion2PDFApi' {
    Context 'Conversion2PDFApi'{

        It 'Create Settings' {
            $compression = New-PDFCompression -level 5 -type ADVANCED
            $compression | Should BeOfType Sphereon.SDK.Pdf.Model.Compression

            $inputSettings = New-PDFInputSettings
            $inputSettings | Should BeOfType Sphereon.SDK.Pdf.Model.InputSettings


            $resultSettings = New-PDFResultSettings -compression $compression
            $resultSettings | Should BeOfType Sphereon.SDK.Pdf.Model.ResultSettings


            $Script:conversionSettings = New-PDFConversionSettings -inputSettings $inputSettings -resultSettings $resultSettings
            $conversionSettings | Should BeOfType Sphereon.SDK.Pdf.Model.ConversionSettings
            # Write-Host $conversionSettings | ConvertTo-Json
        }
    }


    Context 'Conversion2PDFApi'{

        It 'Create Job' {
            $Script:jobResponse = Submit-PDFCreateJob -settings $script:conversionSettings
            $jobResponse | Should BeOfType Sphereon.SDK.Pdf.Model.ConversionJobResponse
            $Script:job = $jobResponse.job
            # Write-Host $job | ConvertTo-Json
            $Script:jobId = $job.JobId

        }
    }

    Context 'Conversion2PDFApi' {
        It 'Add Input File' {
            $byteArray = [System.Text.Encoding]::Unicode.GetBytes("POWERSHELL TEST")
            $stream = [System.io.MemoryStream]::new($byteArray)


            $Script:jobResponse = Submit-PDFAddInputFile -jobid $jobId -stream $stream -fileName "test.txt"
            $jobResponse | Should BeOfType Sphereon.SDK.Pdf.Model.ConversionJobResponse
            $Script:job = $jobResponse.job

        }
    }

    Context 'Conversion2PDFApi' {
        It 'Submit Job' {
            $Script:jobResponse = Submit-PDFSubmitJob -jobid $Script:jobId -job $Script:job
            $jobResponse | Should BeOfType Sphereon.SDK.Pdf.Model.ConversionJobResponse

        }
    }


    Context 'Conversion2PDFApi' {
        It 'Get jobs with status' {
            $ret = Submit-PDFGetJobs -status "PROCESSING,DONE,ERROR"
            # Write-Host $ret | ConvertTo-Json
        }
    }


    Context 'Conversion2PDFApi' {
        It 'Wait for job completion' {
            $Script:jobResponse = Submit-PDFGetJob -jobid $jobId
            $Script:job = $jobResponse.job

            $cnt = 0;
            do
            {
                $cnt++;
                $Script:jobResponse = Submit-PDFGetJob -jobid $jobId
                $status = $jobResponse.status
                Write-Host "Processing loop $cnt for job $jobId and status $status"
                Start-Sleep -m 1000

            } while ($status -eq 'PROCESSING' -and $cnt -lt 60)

            $jobResponse | Should BeOfType Sphereon.SDK.Pdf.Model.ConversionJobResponse

            $Script:jobCompleted = $jobResponse.status -eq 'DONE';
        }
    }


    Context 'Conversion2PDFApi' {
        It 'Get Result Stream - PDF' {
            $ret = Submit-PDFGetStream -jobid $jobId
            $ret | Should BeOfType System.Object
            $content = [System.Text.Encoding]::UTF8.GetString($ret)
            $content | Should Match "PDF-1.5"
            $content | Should Match "HELL TEST"
        }
    }

    Context 'Conversion2PDFApi' {
        It 'Delete Job' {
            if (!$jobCompleted)
            {
                # Only needed when job was not completed, since delete on retrieval is the default
                $ret = Submit-PDFDeleteJob -jobid $jobId
            }
        }
    }


}