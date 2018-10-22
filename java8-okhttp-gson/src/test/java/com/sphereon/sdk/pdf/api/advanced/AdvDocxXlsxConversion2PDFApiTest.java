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
public class AdvDocxXlsxConversion2PDFApiTest extends Conversion2PDFApiTest {

    private final boolean WRITE_TO_FILE = true;

    @Before
    public void setUp() {
        super.uploadConfigs.add(new FileUploadConfig("11Sheets.xlsx",Conversion2PDFApiTest.class.getResource("/11Sheets.xlsx")));
        super.uploadConfigs.add(new FileUploadConfig(2, "4Pages.docx", Conversion2PDFApiTest.class.getResource("/4Pages.docx")));
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
                String allText = PDFReadUtils.getTextFromPdfPage(doc,1,19);
                Assert.assertEquals(19, doc.getNumberOfPages());
                Assert.assertTrue(PDFReadUtils.getTextFromPdfPage(doc,1,1).contains("Estimating template guidelines"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"Estimating template guidelines"));
                Assert.assertEquals(2,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,1,19),"Pre-estimate checklist"));
                Assert.assertEquals(2,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,2,2),"Pre-estimate checklist"));
                Assert.assertEquals(2,StringUtils.countMatches(allText,"Project Assumptions"));
                Assert.assertEquals(2,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,3,3),"Project Assumptions"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"Project Estimate Summary"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,4,4),"Project Estimate Summary"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"Effort estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,5,5),"Effort estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"Resource type estimate checklist"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,5,5),"Resource type estimate checklist"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"Indirect estimate checklist"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,5,5),"Indirect estimate checklist"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"Hardware Cost estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,6,6),"Hardware Cost estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"Software Cost estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,7,7),"Software Cost estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"Network Cost estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,8,8),"Network Cost estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(allText,"On-going support estimate"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,9,9),"On-going support estimate"));
                Assert.assertEquals(3,StringUtils.countMatches(allText,"Admin costs not in overhead"));
                Assert.assertEquals(2,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,10,10),"Admin costs not in overhead"));
                Assert.assertEquals(2,StringUtils.countMatches(allText,"Risk & Change"));
                Assert.assertEquals(1,StringUtils.countMatches(PDFReadUtils.getTextFromPdfPage(doc,11,11),"Risk & Change"));
                Assert.assertEquals(96, StringUtils.countMatches(allText,"Lorem ipsum dolor sit amet"));
                Assert.assertEquals(2, PDFReadUtils.getImagesFromPdfPage(doc, 13).size());
                Assert.assertEquals(2, PDFReadUtils.getImagesFromPdfPage(doc, 17).size());

            } finally {
                doc.close();
            }
        }
    }
}