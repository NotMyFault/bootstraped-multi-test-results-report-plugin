package com.github.bogdanlivadariu.reporting.junit.builder;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import jakarta.xml.bind.JAXBException;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class JUnitReportBuilderTest {

    @Test(expected = NullPointerException.class)
    public void npeTest() throws IOException, JAXBException {
        List<String> xmlReports = null;
        new JUnitReportBuilder(xmlReports, "out");
    }

    @Test
    public void processedReportsTest() throws FileNotFoundException, JAXBException {
        List<String> xmlReports = new ArrayList<>();
        String report = this.getClass().getClassLoader().getResource("valid-report-1.xml").getPath();
        xmlReports.add(report);
        JUnitReportBuilder builder = new JUnitReportBuilder(xmlReports, "out");
        assertEquals("reports count is not right", 1, builder.getProcessedTestSuites().size());
        xmlReports.clear();
        builder = new JUnitReportBuilder(xmlReports, "out");
        assertEquals("reports count is not right", 0, builder.getProcessedTestSuites().size());
    }

    @Test
    public void processedReportsSuitesTest() throws FileNotFoundException, JAXBException {
        List<String> xmlReports = new ArrayList<>();
        String report = this.getClass().getClassLoader().getResource("valid-report-2.xml").getPath();
        xmlReports.add(report);
        JUnitReportBuilder builder = new JUnitReportBuilder(xmlReports, "out");
        assertEquals("reports count is not right", 2, builder.getProcessedTestSuites().size());
        xmlReports.clear();
        builder = new JUnitReportBuilder(xmlReports, "out");
        assertEquals("reports count is not right", 0, builder.getProcessedTestSuites().size());
    }
}
