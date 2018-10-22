package com.sphereon.sdk.pdf.api.util;

import com.sphereon.sdk.pdf.api.Conversion2PDFApiTest;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocJpgDwgSetupAndPdfAssert implements SetupAndPdfAssert {
    List<Conversion2PDFApiTest.FileUploadConfig> uploadConfigs = new ArrayList<>();

    public List<Conversion2PDFApiTest.FileUploadConfig> getUploadConfigs() {
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig(2, "4Pages.doc", Conversion2PDFApiTest.class.getResource("/4Pages.doc")));
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("blue-flower.jpeg", Conversion2PDFApiTest.class.getResource("/blue-flower.jpeg")));
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("autocad.dwg", Conversion2PDFApiTest.class.getResource("/autocad.dwg")));
        return uploadConfigs;
    }
    public void checkPdfFile(String pdfDownloadPath) throws IOException {
        PDDocument doc = null;
        try {
            doc = PDDocument.load(new File(pdfDownloadPath));
            String allText = PDFReadUtils.getTextFromPdfPage(doc,1,9);
            Assert.assertEquals(10, doc.getNumberOfPages());
            Assert.assertEquals(0, PDFReadUtils.getImagesFromPdfPage(doc, 0).size());
            Assert.assertEquals(0, PDFReadUtils.getImagesFromPdfPage(doc, 1).size());
            Assert.assertEquals(2, PDFReadUtils.getImagesFromPdfPage(doc, 2).size());
            Assert.assertEquals(0, PDFReadUtils.getImagesFromPdfPage(doc, 3).size());
            Assert.assertEquals(0, PDFReadUtils.getImagesFromPdfPage(doc, 4).size());
            Assert.assertEquals(0, PDFReadUtils.getImagesFromPdfPage(doc, 5).size());
            Assert.assertEquals(2, PDFReadUtils.getImagesFromPdfPage(doc, 6).size());
            Assert.assertEquals(0, PDFReadUtils.getImagesFromPdfPage(doc, 7).size());
            Assert.assertEquals(1, PDFReadUtils.getImagesFromPdfPage(doc, 8).size());
            Assert.assertEquals(96, StringUtils.countMatches(allText,"Lorem ipsum dolor sit amet"));
        } finally {
            doc.close();
        }

    }
}
