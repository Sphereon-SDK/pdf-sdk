package com.sphereon.sdk.pdf.api.util;

import com.sphereon.sdk.pdf.api.Conversion2PDFApiTest;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvTifXmlSetupAndPdfAssert implements SetupAndPdfAssert {
    List<Conversion2PDFApiTest.FileUploadConfig> uploadConfigs = new ArrayList<>();

    public List<Conversion2PDFApiTest.FileUploadConfig> getUploadConfigs() {
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("csvSample.csv", Conversion2PDFApiTest.class.getResource("/csvSample.csv")));
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("sample.tif", Conversion2PDFApiTest.class.getResource("/sample.tif")));
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("food.xml", Conversion2PDFApiTest.class.getResource("/food.xml")));
        return uploadConfigs;
    }
    public void checkPdfFile(String pdfDownloadPath) throws IOException {
        PDDocument doc = null;
        try {
            doc = PDDocument.load(new File(pdfDownloadPath));
            String allText = PDFReadUtils.getTextFromPdfPage(doc,1,3);
            Assert.assertEquals(3, doc.getNumberOfPages());
            Assert.assertEquals(1, StringUtils.countMatches(allText,"PassKeyPassword"));
            Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,1,1),"PassKeyPassword"));
            Assert.assertEquals(1, PDFReadUtils.getImagesFromPdfPage(doc, 1).size());
            Assert.assertEquals(2, StringUtils.countMatches(allText,"breakfast_menu"));
            Assert.assertEquals(2,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,3,3),"breakfast_menu"));
        } finally {
            doc.close();
        }

    }
}
