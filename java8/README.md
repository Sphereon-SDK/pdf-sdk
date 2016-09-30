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
    <version>0.1.5-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.sphereon.sdk:pdf-sdk-java8:0.1.5-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/pdf-sdk-java8-0.1.5-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.sphereon.sdk.pdf.handler.*;
import com.sphereon.sdk.pdf.handler.auth.*;
import com.sphereon.sdk.pdf.handler.model.*;
import com.sphereon.sdk.pdf.api.ImagePDFApi;

import java.io.File;
import java.util.*;

public class ImagePDFApiExample {

    public static void main(String[] args) {
        
        ImagePDFApi apiInstance = new ImagePDFApi();
        String jobid = "jobid_example"; // String | jobid
        try {
            PDFJobResponse result = apiInstance.deleteJobUsingDELETE(jobid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ImagePDFApi#deleteJobUsingDELETE");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://gw.api.cloud.sphereon.com/pdf/0.1.4*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ImagePDFApi* | [**deleteJobUsingDELETE**](docs/ImagePDFApi.md#deleteJobUsingDELETE) | **DELETE** /image2pdf/{jobid} | Delete a job manually
*ImagePDFApi* | [**getJobUsingGET**](docs/ImagePDFApi.md#getJobUsingGET) | **GET** /image2pdf/{jobid} | Job definition and state
*ImagePDFApi* | [**getPDFUsingGET**](docs/ImagePDFApi.md#getPDFUsingGET) | **GET** /image2pdf/{jobid}/stream | Get the current result stream
*ImagePDFApi* | [**submitJobUsingPUT**](docs/ImagePDFApi.md#submitJobUsingPUT) | **PUT** /image2pdf/{jobid} | Submit PDF job for processing
*ImagePDFApi* | [**uploadImageUsingPOST**](docs/ImagePDFApi.md#uploadImageUsingPOST) | **POST** /image2pdf | Upload (first) image


## Documentation for Models

 - [Compression](docs/Compression.md)
 - [Image2PDFSettings](docs/Image2PDFSettings.md)
 - [Lifecycle](docs/Lifecycle.md)
 - [Link](docs/Link.md)
 - [OcrEngineTask](docs/OcrEngineTask.md)
 - [PDFJob](docs/PDFJob.md)
 - [PDFJobResponse](docs/PDFJobResponse.md)
 - [VndError](docs/VndError.md)
 - [VndErrors](docs/VndErrors.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### default

- **Type**: OAuth
- **Flow**: implicit
- **Authorizatoin URL**: https://gw.api.cloud.sphereon.com/authorize
- **Scopes**: N/A


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

dev@sphereon.com

