package com.sphereon.sdk.pdf.api.util;

import com.sphereon.sdk.pdf.api.Conversion2PDFApiTest;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvMsgSetupAndPdfAssert implements SetupAndPdfAssert {
    List<Conversion2PDFApiTest.FileUploadConfig> uploadConfigs = new ArrayList<>();

    public List<Conversion2PDFApiTest.FileUploadConfig> getUploadConfigs() {
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("tsvSample.tsv", Conversion2PDFApiTest.class.getResource("/tsvSample.tsv")));
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("example.msg", Conversion2PDFApiTest.class.getResource("/example.msg")));
        return uploadConfigs;
    }
    public void checkPdfFile(String pdfDownloadPath) throws IOException {
        PDDocument doc = null;
        try {
            doc = PDDocument.load(new File(pdfDownloadPath));
            Assert.assertEquals(2, doc.getNumberOfPages());
            Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,1,1),"Big Farm Way"));
            Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,2,2),"MSG test file"));
        } finally {
            doc.close();
        }

    }
}
