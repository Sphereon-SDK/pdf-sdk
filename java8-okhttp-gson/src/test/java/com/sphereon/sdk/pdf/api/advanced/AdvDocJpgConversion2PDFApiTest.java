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
public class AdvDocJpgConversion2PDFApiTest extends Conversion2PDFApiTest {

    private final boolean WRITE_TO_FILE = true;

    @Before
    public void setUp() {
        super.uploadConfigs.add(new FileUploadConfig(2, "4Pages.doc", Conversion2PDFApiTest.class.getResource("/4Pages.doc")));
        super.uploadConfigs.add(new FileUploadConfig("blue-flower.jpeg", Conversion2PDFApiTest.class.getResource("/blue-flower.jpeg")));
        super.uploadConfigs.add(new FileUploadConfig("autocad.dwg", Conversion2PDFApiTest.class.getResource("/autocad.dwg")));
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
    public void _030_submitJob() throws ApiException {
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
        if (WRITE_TO_FILE) {
            PDDocument doc = null;
            try {
                doc = PDDocument.load(new File(Conversion2PDFApiTest.PDF_DOWNLOAD_PATH));
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
}