package com.sphereon.sdk.pdf.api.advanced;

import com.sphereon.sdk.pdf.api.Conversion2PDFApiTest;
import com.sphereon.sdk.pdf.api.util.PDFReadUtils;
import com.sphereon.sdk.pdf.handler.ApiException;
import com.sphereon.sdk.pdf.model.ConversionSettings;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdvPngPdfTxtPptConversion2PDFApiTest extends Conversion2PDFApiTest {

    private final boolean WRITE_TO_FILE = true;

    @Before
    public void setUp() {
        super.uploadConfigs.add(new FileUploadConfig("image.png",Conversion2PDFApiTest.class.getResource("/image.png")));
        super.uploadConfigs.add(new FileUploadConfig("pdf-sample.pdf",Conversion2PDFApiTest.class.getResource("/pdf-sample.pdf")));
        super.uploadConfigs.add(new FileUploadConfig("CharlieBrown.txt",Conversion2PDFApiTest.class.getResource("/CharlieBrown.txt")));
        super.uploadConfigs.add(new FileUploadConfig("3Pages.ppt",Conversion2PDFApiTest.class.getResource("/3Pages.ppt")));
        super.engine = ConversionSettings.EngineEnum.ADVANCED;
        super.writeToFile = WRITE_TO_FILE;

    }
    @Test
    public void _010_CreateJob() throws ApiException {
        super._010_CreateJob();
    }
    @Test
    public void _020_UploadFile() throws ApiException {
        super._020_UploadFile();
    }
    @Test
    public void _030_submitJob() throws ApiException{
        super._030_submitJob();
    }
    @Test
    public void _040_getJob() throws ApiException {
        super._040_getJob();
    }
    @Test
    public void _050_getPDF() throws ApiException, InterruptedException {
        super._050_getPDF();
    }
    @Test
    public void _060_deleteJob() throws ApiException {
        super._060_deleteJob();
    }
    @Test
    public void _70_checkGeneratedPdf() throws IOException{
        PDDocument doc = null;
        try {
            doc = PDDocument.load(new File(Conversion2PDFApiTest.PDF_DOWNLOAD_PATH));
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
