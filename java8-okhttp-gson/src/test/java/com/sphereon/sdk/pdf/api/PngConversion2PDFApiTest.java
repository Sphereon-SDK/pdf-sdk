package com.sphereon.sdk.pdf.api;

import com.sphereon.sdk.pdf.api.util.PDFReadUtils;
import com.sphereon.sdk.pdf.handler.ApiException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PngConversion2PDFApiTest extends Conversion2PDFApiTest  {

    private final boolean WRITE_TO_FILE = true;

    @Before
    public void setUp() {
        super.UPLOAD_CONFIG.add(new FileUploadConfig("image.png",Conversion2PDFApiTest.class.getResource("/image.png")));
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
            Assert.assertEquals(1, doc.getNumberOfPages());
            Assert.assertEquals(1, PDFReadUtils.getImagesFromPdfPage(doc, 0).size());
        } finally {
            doc.close();
        }
    }
}
