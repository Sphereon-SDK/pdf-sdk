# pdf-sdk-java8-okhttp-gson

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.sphereon.sdk</groupId>
    <artifactId>pdf-sdk-java8-okhttp-gson</artifactId>
    <version>1.1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.sphereon.sdk:pdf-sdk-java8-okhttp-gson:1.1.0-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/pdf-sdk-java8-okhttp-gson-1.1.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.sphereon.sdk.pdf.handler.*;
import com.sphereon.sdk.pdf.handler.auth.*;
import com.sphereon.sdk.pdf.handler.model.*;
import com.sphereon.sdk.pdf.api.ConversionPDFApi;

import java.io.File;
import java.util.*;

public class ConversionPDFApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure OAuth2 access token for authorization: oauth2schema
        OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
        oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

        ConversionPDFApi apiInstance = new ConversionPDFApi();
        String jobid = "jobid_example"; // String | jobid
        File stream = new File("/path/to/file.txt"); // File | The (additional) binary image or PDF (file/inputstream) to convert to PDF
        try {
            ConversionJobResponse result = apiInstance.addInputFile(jobid, stream);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConversionPDFApi#addInputFile");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://gw.api.cloud.sphereon.com/pdf/1.1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ConversionPDFApi* | [**addInputFile**](docs/ConversionPDFApi.md#addInputFile) | **POST** /conversion2pdf/jobs/{jobid}/streams/multipart | Upload a file
*ConversionPDFApi* | [**addInputStreamLocations**](docs/ConversionPDFApi.md#addInputStreamLocations) | **POST** /conversion2pdf/jobs/{jobid}/streams/location | Add Input Stream Location(s)
*ConversionPDFApi* | [**createJob**](docs/ConversionPDFApi.md#createJob) | **POST** /conversion2pdf/jobs | Create a PDF conversion job
*ConversionPDFApi* | [**deleteJob**](docs/ConversionPDFApi.md#deleteJob) | **DELETE** /conversion2pdf/jobs/{jobid} | Delete a job manually
*ConversionPDFApi* | [**getJob**](docs/ConversionPDFApi.md#getJob) | **GET** /conversion2pdf/jobs/{jobid} | Job definition and state
*ConversionPDFApi* | [**getJobs**](docs/ConversionPDFApi.md#getJobs) | **GET** /conversion2pdf/jobs | Get all jobs
*ConversionPDFApi* | [**getStream**](docs/ConversionPDFApi.md#getStream) | **GET** /conversion2pdf/jobs/{jobid}/streams/result | Get the current result stream
*ConversionPDFApi* | [**submitJob**](docs/ConversionPDFApi.md#submitJob) | **PUT** /conversion2pdf/jobs/{jobid} | Submit PDF job for processing


## Documentation for Models

 - [CSVSettings](docs/CSVSettings.md)
 - [Compression](docs/Compression.md)
 - [ConversionJob](docs/ConversionJob.md)
 - [ConversionJobResponse](docs/ConversionJobResponse.md)
 - [ConversionSettings](docs/ConversionSettings.md)
 - [ConversionTask](docs/ConversionTask.md)
 - [ConversionTaskInput](docs/ConversionTaskInput.md)
 - [Error](docs/Error.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [InputResponse](docs/InputResponse.md)
 - [InputSettings](docs/InputSettings.md)
 - [Lifecycle](docs/Lifecycle.md)
 - [ResultResponse](docs/ResultResponse.md)
 - [ResultSettings](docs/ResultSettings.md)
 - [StorageLocation](docs/StorageLocation.md)
 - [StreamLocation](docs/StreamLocation.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### oauth2schema

- **Type**: OAuth
- **Flow**: application
- **Authorizatoin URL**: 
- **Scopes**: 
  - global: accessEverything


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

dev@sphereon.com

