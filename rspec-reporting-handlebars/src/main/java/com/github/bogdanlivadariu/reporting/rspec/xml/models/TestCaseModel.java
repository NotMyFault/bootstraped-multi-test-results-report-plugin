package com.github.bogdanlivadariu.reporting.rspec.xml.models;

import java.util.UUID;

import jakarta.xml.bind.annotation.*;

import com.github.bogdanlivadariu.reporting.rspec.helpers.Constants;
import static com.github.bogdanlivadariu.reporting.rspec.xml.models.BaseModel.*;

@XmlRootElement(name = "testcase")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestCaseModel {
    @XmlElement(name = "system-out")
    private String systemOut;

    @XmlAttribute
    private String time;

    @XmlElement(name = "failure")
    private FailureModel failure;

    @XmlAttribute
    private String classname;

    @XmlAttribute
    private String name;

    @XmlElement(name = "system-err")
    private String systemErr;

    @XmlElement(name = "error")
    private ErrorModel error;

    private String overallStatus;

    private String uniqueID;

    public ErrorModel getError() {
        return error;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void postProcess() {
        if (failure != null) {
            overallStatus = Constants.FAILED;
        } else if (error != null) {
            overallStatus = Constants.ERRORED;
        } else {
            overallStatus = Constants.PASSED;
        }
        uniqueID = UUID.randomUUID().toString();
    }

    public String getSystemOut() {
        return systemOut;
    }

    public String getTime() {
        return time.replace(",", "");
    }

    public FailureModel getFailure() {
        return failure;
    }

    public String getClassname() {
        return classname;
    }

    public String getName() {
        return name;
    }

    public String getSystemErr() {
        return systemErr;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

}
