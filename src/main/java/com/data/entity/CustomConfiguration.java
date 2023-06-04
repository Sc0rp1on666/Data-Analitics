package com.data.entity;


public class CustomConfiguration {
    private int configurationId;
    private String configurationName;
    private int configurationValue;

    public CustomConfiguration(int configurationId, String configurationName, int configurationValue) {
        this.configurationId = configurationId;
        this.configurationName = configurationName;
        this.configurationValue = configurationValue;
    }

    public int getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(int configurationId) {
        this.configurationId = configurationId;
    }

    public String getConfigurationNam() {
        return configurationName;
    }

    public void setConfigurationNam(String configurationName) {
        this.configurationName = configurationName;
    }

    public int getConfigurationValue() {
        return configurationValue;
    }

    public void setConfigurationValue(int configurationValue) {
        this.configurationValue = configurationValue;
    }
}
