package com.sphereon.sdk.pdf.api.util;

import com.sphereon.sdk.pdf.api.Conversion2PDFApiTest;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PngPdfTxtPptSetupAndPdfAssert implements SetupAndPdfAssert {
    List<Conversion2PDFApiTest.FileUploadConfig> uploadConfigs = new ArrayList<>();

    public List<Conversion2PDFApiTest.FileUploadConfig> getUploadConfigs() {
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("image.png",Conversion2PDFApiTest.class.getResource("/image.png")));
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("pdf-sample.pdf",Conversion2PDFApiTest.class.getResource("/pdf-sample.pdf")));
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("CharlieBrown.txt",Conversion2PDFApiTest.class.getResource("/CharlieBrown.txt")));
        uploadConfigs.add(new Conversion2PDFApiTest.FileUploadConfig("3Pages.ppt",Conversion2PDFApiTest.class.getResource("/3Pages.ppt")));
        return uploadConfigs;
    }
    public void checkPdfFile(String pdfDownloadPath) throws IOException {
        PDDocument doc = null;
        try {
            doc = PDDocument.load(new File(pdfDownloadPath));
            Assert.assertEquals(6, doc.getNumberOfPages());
            String allText = PDFReadUtils.getTextFromPdfPage(doc,1,8);

            Assert.assertEquals(1, PDFReadUtils.getImagesFromPdfPage(doc, 0).size());
            Assert.assertEquals(1, PDFReadUtils.getImagesFromPdfPage(doc, 1).size());

            Assert.assertEquals(1, StringUtils.countMatches(allText,"Adobe Acrobat PDF Files"));
            Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,2,2),"Adobe Acrobat PDF Files"));
            Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,3,3),"oh, good grief"));
            Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,4,4),"How To Use PowerPoint"));
            Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,5,5),"Advanced AutoShapes"));
            Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,6,6),"Embedding Video"));

        } finally {
            doc.close();
        }

    }
}
