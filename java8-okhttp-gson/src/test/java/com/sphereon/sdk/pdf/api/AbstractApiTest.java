package com.sphereon.sdk.pdf.api;

import com.sphereon.libs.authentication.api.AuthenticationApi;
import com.sphereon.libs.authentication.api.TokenRequest;
import com.sphereon.libs.authentication.api.config.ApiConfiguration;
import com.sphereon.libs.authentication.api.config.PersistenceMode;
import com.sphereon.libs.authentication.api.config.PersistenceType;
import com.sphereon.sdk.pdf.handler.ApiClient;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public abstract class AbstractApiTest {
    public static final String APPLICATION_NAME = "tests.pdf";
    public static final long TOKEN_VALIDITY_SECONDS = 5400;
    public static final int CONNECTION_TIMEOUT = 40000;


    private static final AuthenticationApi authenticationApi;

    protected Conversion2PDFApi api;

    static {
        ApiConfiguration tokenApiConfig = new ApiConfiguration.Builder()
                                              .withApplication(APPLICATION_NAME)
                                              .withPersistenceType(PersistenceType.SYSTEM_ENVIRONMENT)
                                              .withPersistenceMode(PersistenceMode.READ_WRITE)
                                              .withAutoEncryptSecrets(true)
                                              .build();
        authenticationApi = new AuthenticationApi.Builder().withConfiguration(tokenApiConfig).build();

    }

    @Before
    public void CreateConfigurationApi() {
        api = new Conversion2PDFApi();
        configureApi(api.getApiClient());
    }


    protected void configureApi(ApiClient apiClient) {
        apiClient.setConnectTimeout(CONNECTION_TIMEOUT);
        apiClient.getHttpClient().setReadTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        apiClient.getHttpClient().setWriteTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);

        String gatewayUrl = System.getProperty("tests.pdf.gateway-url");
        if (StringUtils.isNotEmpty(gatewayUrl)) {
            gatewayUrl = System.getenv("tests.pdf.gateway-url");
        }
        if (StringUtils.isNotEmpty(gatewayUrl)) {
            apiClient.setBasePath(gatewayUrl);
        }

        TokenRequest tokenRequest = authenticationApi.requestToken()
                                        .withValidityPeriod(TOKEN_VALIDITY_SECONDS)
                                        .build();
        apiClient.setAccessToken(tokenRequest.execute().getAccessToken());
    }
}