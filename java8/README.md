# pdf-sdk-java8

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
    <artifactId>pdf-sdk-java8</artifactId>
    <version>0.3.1-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.sphereon.sdk:pdf-sdk-java8:0.3.1-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/pdf-sdk-java8-0.3.1-SNAPSHOT.jar
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
        try {
            PDFJobResponse result = apiInstance.deleteJob(jobid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ConversionPDFApi#deleteJob");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ConversionPDFApi* | [**deleteJob**](docs/ConversionPDFApi.md#deleteJob) | **DELETE** /pdf/0.3.1/conversion2pdf/{jobid} | Delete a job manually
*ConversionPDFApi* | [**getJob**](docs/ConversionPDFApi.md#getJob) | **GET** /pdf/0.3.1/conversion2pdf/{jobid} | Job definition and state
*ConversionPDFApi* | [**getJobs**](docs/ConversionPDFApi.md#getJobs) | **GET** /pdf/0.3.1/conversion2pdf | Get all jobs
*ConversionPDFApi* | [**getStream**](docs/ConversionPDFApi.md#getStream) | **GET** /pdf/0.3.1/conversion2pdf/{jobid}/stream | Get the current result stream
*ConversionPDFApi* | [**submitJob**](docs/ConversionPDFApi.md#submitJob) | **PUT** /pdf/0.3.1/conversion2pdf/{jobid} | Submit PDF job for processing
*ConversionPDFApi* | [**uploadAdditionalFile**](docs/ConversionPDFApi.md#uploadAdditionalFile) | **POST** /pdf/0.3.1/conversion2pdf/{jobid} | Upload an additional file
*ConversionPDFApi* | [**uploadFile**](docs/ConversionPDFApi.md#uploadFile) | **POST** /pdf/0.3.1/conversion2pdf | Upload first file


## Documentation for Models

 - [Compression](docs/Compression.md)
 - [ConversionSettings](docs/ConversionSettings.md)
 - [ConversionTask](docs/ConversionTask.md)
 - [Error](docs/Error.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [Lifecycle](docs/Lifecycle.md)
 - [PDFJob](docs/PDFJob.md)
 - [PDFJobResponse](docs/PDFJobResponse.md)


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

