package com.sphereon.sdk.pdf.api;

import com.sphereon.sdk.pdf.handler.ApiClient;
import com.sphereon.sdk.pdf.model.ConversionJobResponse;
import com.sphereon.sdk.pdf.model.ConversionSettings;
import com.sphereon.sdk.pdf.model.ErrorResponse;
import java.io.File;
import com.sphereon.sdk.pdf.model.StreamLocation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for Conversion2PDFApi
 */
public class Conversion2PDFApiTest {

    private Conversion2PDFApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(Conversion2PDFApi.class);
    }

    
    /**
     * Upload a file
     *
     * Upload an image, office or pdf for conversion to PDF. Please note that you can upload multiple files. Conversion will not be started yet.
     */
    @Test
    public void addInputFileTest() {
        String jobid = null;
        File stream = null;
        String fileName = null;
        // ConversionJobResponse response = api.addInputFile(jobid, stream, fileName);

        // TODO: test validations
    }
    
    /**
     * Add Input Stream Location(s)
     *
     * Add image, office or pdf input stream location(s) from the storage API for conversion to PDF. Please note that you can upload multiple files. Conversion will not be started yet.
     */
    @Test
    public void addInputStreamLocationsTest() {
        String jobid = null;
        List<StreamLocation> inputStreamLocations = null;
        // ConversionJobResponse response = api.addInputStreamLocations(jobid, inputStreamLocations);

        // TODO: test validations
    }
    
    /**
     * Create a PDF conversion job
     *
     * Create a PDF conversion job using optional settings supplied, otherwise defaults will be used
     */
    @Test
    public void createJobTest() {
        ConversionSettings settings = null;
        // ConversionJobResponse response = api.createJob(settings);

        // TODO: test validations
    }
    
    /**
     * Delete a job manually
     *
     * Delete the PDF job and all related files.
     */
    @Test
    public void deleteJobTest() {
        String jobid = null;
        // ConversionJobResponse response = api.deleteJob(jobid);

        // TODO: test validations
    }
    
    /**
     * Job definition and state
     *
     * Get the PDF job definition and current state. Please note that you can differentiate based on http response status.
     */
    @Test
    public void getJobTest() {
        String jobid = null;
        // ConversionJobResponse response = api.getJob(jobid);

        // TODO: test validations
    }
    
    /**
     * Get all jobs
     *
     * Get all PDF job definitions and their current state.
     */
    @Test
    public void getJobsTest() {
        List<String> status = null;
        // ConversionJobResponse response = api.getJobs(status);

        // TODO: test validations
    }
    
    /**
     * Get the current result stream
     *
     * Get the PDF as binary stream/file.  Our API generation does not allow changing the media type based on the Accepted header unfortunately.&lt;br/&gt;This means we use a seperate path postfix with the value &#39;/stream&#39;.  This API only returns the PDF when the response status.
     */
    @Test
    public void getStreamTest() {
        String jobid = null;
        // byte[] response = api.getStream(jobid);

        // TODO: test validations
    }
    
    /**
     * Submit PDF job for processing
     *
     * Start PDF conversion. Convert the previously uploaded file(s) to PDF. The settings supplied with the job in the request body are used for the conversion. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request.
     */
    @Test
    public void submitJobTest() {
        String jobid = null;
        String bodySettingsResultFileFormat = null;
        String bodyJobId = null;
        List<String> bodySettingsInputLifecycleApplicableJobStatusses = null;
        String bodySettingsInputLifecycleAction = null;
        String bodySettingsInputLifecycleType = null;
        String bodySettingsInputStorageLocationId = null;
        String bodySettingsInputStorageLocationContainerId = null;
        String bodySettingsInputStorageLocationFolderPath = null;
        List<String> bodySettingsResultLifecycleApplicableJobStatusses = null;
        String bodySettingsResultLifecycleAction = null;
        String bodySettingsResultLifecycleType = null;
        String bodySettingsResultStorageLocationId = null;
        String bodySettingsResultStorageLocationContainerId = null;
        String bodySettingsResultStorageLocationFolderPath = null;
        Integer bodySettingsResultCompressionLevel = null;
        String bodySettingsResultCompressionType = null;
        List<String> bodySettingsJobLifecycleApplicableJobStatusses = null;
        String bodySettingsJobLifecycleAction = null;
        String bodySettingsJobLifecycleType = null;
        String bodySettingsOcrMode = null;
        Integer bodySettingsQualityFactor = null;
        String bodySettingsContainerConversion = null;
        String bodySettingsEngine = null;
        String bodySettingsVersion = null;
        String bodySettingsOwner = null;
        // ConversionJobResponse response = api.submitJob(jobid, bodySettingsResultFileFormat, bodyJobId, bodySettingsInputLifecycleApplicableJobStatusses, bodySettingsInputLifecycleAction, bodySettingsInputLifecycleType, bodySettingsInputStorageLocationId, bodySettingsInputStorageLocationContainerId, bodySettingsInputStorageLocationFolderPath, bodySettingsResultLifecycleApplicableJobStatusses, bodySettingsResultLifecycleAction, bodySettingsResultLifecycleType, bodySettingsResultStorageLocationId, bodySettingsResultStorageLocationContainerId, bodySettingsResultStorageLocationFolderPath, bodySettingsResultCompressionLevel, bodySettingsResultCompressionType, bodySettingsJobLifecycleApplicableJobStatusses, bodySettingsJobLifecycleAction, bodySettingsJobLifecycleType, bodySettingsOcrMode, bodySettingsQualityFactor, bodySettingsContainerConversion, bodySettingsEngine, bodySettingsVersion, bodySettingsOwner);

        // TODO: test validations
    }
    
}
