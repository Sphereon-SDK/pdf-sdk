package com.sphereon.tools.commands.ms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Configuration {
    @XmlElement
    private String apiKey;

    @XmlElement
    private String importDirectory;

    @XmlElement
    private String exportDirectory;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImportDirectory() {
        return importDirectory;
    }

    public void setImportDirectory(String importDirectory) {
        this.importDirectory = importDirectory;
    }

    public String getExportDirectory() {
        return exportDirectory;
    }

    public void setExportDirectory(String exportDirectory) {
        this.exportDirectory = exportDirectory;
    }
}
