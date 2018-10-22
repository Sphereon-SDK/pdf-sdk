package com.sphereon.sdk.pdf.api.premium;

import com.sphereon.sdk.pdf.api.Conversion2PDFApiTest;
import com.sphereon.sdk.pdf.api.util.PngXlsDocSetupAndPdfAssert;
import com.sphereon.sdk.pdf.api.util.SetupAndPdfAssert;
import com.sphereon.sdk.pdf.handler.ApiException;
import com.sphereon.sdk.pdf.model.ConversionSettings;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrePngXlsDocConversion2PDFApiTest extends Conversion2PDFApiTest {

    private final boolean WRITE_TO_FILE = true;
    private SetupAndPdfAssert setUpAndPdfAssert = new PngXlsDocSetupAndPdfAssert();

    @Before
    public void setUp() {
        super.uploadConfigs.addAll(setUpAndPdfAssert.getUploadConfigs());
        super.engine = ConversionSettings.EngineEnum.PREMIUM;
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
        if (WRITE_TO_FILE)
            setUpAndPdfAssert.checkPdfFile(Conversion2PDFApiTest.PDF_DOWNLOAD_PATH);
    }
}
