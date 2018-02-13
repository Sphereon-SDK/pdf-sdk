#region Import functions

'API', 'Model', 'Private' | Get-ChildItem -Path {
    Join-Path $PSScriptRoot $_
} -Filter '*.ps1' | ForEach-Object {
    Write-Verbose "Importing file: $($_.BaseName)"
    try {
        . $_.FullName
    } catch {
        Write-Verbose "Can't import function!"
    }
}

#endregion


#region Initialize APIs

'Creating object: Sphereon.SDK.Pdf.Api.Conversion2PDFApi' | Write-Verbose
$Script:Conversion2PDFApi= New-Object -TypeName Sphereon.SDK.Pdf.Api.Conversion2PDFApi -ArgumentList @($null)


#endregion
