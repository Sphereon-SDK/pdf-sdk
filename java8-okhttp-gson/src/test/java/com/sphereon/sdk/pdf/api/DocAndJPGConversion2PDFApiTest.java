package com.sphereon.sdk.pdf.api;

import com.sphereon.sdk.pdf.api.util.PDFReadUtils;
import com.sphereon.sdk.pdf.handler.ApiException;
import com.sphereon.sdk.pdf.model.ConversionJob;
import com.sphereon.sdk.pdf.model.ConversionJobResponse;
import com.sphereon.sdk.pdf.model.ConversionSettings;
import com.sphereon.sdk.pdf.model.Lifecycle;
import org.apache.commons.collections.MultiMap;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocAndJPGConversion2PDFApiTest extends Conversion2PDFApiTest {

    private final boolean WRITE_TO_FILE = true;

    @Before
    public void setUp() {
        super.UPLOAD_CONFIG.add(new FileUploadConfig(2, "4Pages4TestingPDFConversion.doc", Conversion2PDFApiTest.class.getResource("/4Pages4TestingPDFConversion.doc")));
        super.UPLOAD_CONFIG.add(new FileUploadConfig("blue-flower.jpeg", Conversion2PDFApiTest.class.getResource("/blue-flower.jpeg")));
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
                Assert.assertEquals(9, doc.getNumberOfPages());
                Assert.assertEquals(0, PDFReadUtils.getImagesFromPdf(doc, 0).size());
                Assert.assertEquals(0, PDFReadUtils.getImagesFromPdf(doc, 1).size());
                Assert.assertEquals(2, PDFReadUtils.getImagesFromPdf(doc, 2).size());
                Assert.assertEquals(0, PDFReadUtils.getImagesFromPdf(doc, 3).size());
                Assert.assertEquals(0, PDFReadUtils.getImagesFromPdf(doc, 4).size());
                Assert.assertEquals(0, PDFReadUtils.getImagesFromPdf(doc, 5).size());
                Assert.assertEquals(2, PDFReadUtils.getImagesFromPdf(doc, 6).size());
                Assert.assertEquals(0, PDFReadUtils.getImagesFromPdf(doc, 7).size());
                Assert.assertEquals(1, PDFReadUtils.getImagesFromPdf(doc, 8).size());

            } finally {
                doc.close();
            }
        }
    }
}