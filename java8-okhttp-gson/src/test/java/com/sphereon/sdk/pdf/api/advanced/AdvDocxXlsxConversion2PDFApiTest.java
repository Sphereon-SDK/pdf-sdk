package com.sphereon.sdk.pdf.api.advanced;

import com.sphereon.sdk.pdf.api.Conversion2PDFApiTest;
import com.sphereon.sdk.pdf.api.util.DocxXlsxSetupAndPdfAssert;
import com.sphereon.sdk.pdf.api.util.PDFReadUtils;
import com.sphereon.sdk.pdf.api.util.SetupAndPdfAssert;
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
    private SetupAndPdfAssert setupAndPdfAssert = new DocxXlsxSetupAndPdfAssert();

    @Before
    public void setUp() {
        super.uploadConfigs.addAll(setupAndPdfAssert.getUploadConfigs());
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
        if (WRITE_TO_FILE)
            setupAndPdfAssert.checkPdfFile(Conversion2PDFApiTest.PDF_DOWNLOAD_PATH);
    }
}