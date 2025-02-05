package com.github.bogdanlivadariu.reporting.junit.xml.models;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseModel {
    @XmlAttribute
    private String message;

    @XmlAttribute
    private String type;

    @XmlValue
    private String value;

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @XmlRootElement(name = "error")
    public static class ErrorModel extends BaseModel {}

    @XmlRootElement(name = "failure")
    public static class FailureModel extends BaseModel {}
}
