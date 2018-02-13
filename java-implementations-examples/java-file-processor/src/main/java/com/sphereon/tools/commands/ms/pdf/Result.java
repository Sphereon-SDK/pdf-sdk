package com.sphereon.tools.commands.ms.pdf;

import com.sphereon.sdk.pdf.model.ConversionJobResponse;

public class Result {
    private byte[] stream;
    private String statusMessage;
    private ConversionJobResponse.StatusEnum status;

    public void setStream(byte[] stream) {

        this.stream = stream;
    }

    public byte[] getStream() {
        return stream;
    }

    public void setStatus(ConversionJobResponse.StatusEnum status) {

        this.status = status;
    }

    public void setMessage(String statusMessage) {

        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public ConversionJobResponse.StatusEnum getStatus() {
        return status;
    }
}
