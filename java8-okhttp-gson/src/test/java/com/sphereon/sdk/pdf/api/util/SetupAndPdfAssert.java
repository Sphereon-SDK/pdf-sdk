package com.sphereon.sdk.pdf.api.util;

import com.sphereon.sdk.pdf.api.Conversion2PDFApiTest;

import java.io.IOException;
import java.util.List;

public interface SetupAndPdfAssert {
    public List<Conversion2PDFApiTest.FileUploadConfig> getUploadConfigs();
    public void checkPdfFile(String pdfDownloadPath) throws IOException;
}
