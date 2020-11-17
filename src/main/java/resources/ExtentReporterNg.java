package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
  static ExtentReports extent;
    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir")+"\\target\\Surefire suite\\index2.html";
        ExtentSparkReporter reporter= new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("QA Academy Project");
        reporter.config().setReportName("Web Automation Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Rashed Rahman");
        return extent;
    }
}

    /*<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
<Appenders>
<Console name="Console" target="SYSTEM_OUT">
<PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
</Console>
</Appenders>
<Loggers>
<Root level="trace">
<AppenderRef ref="Console"/>
</Root>
</Loggers>
</Configuration>*/