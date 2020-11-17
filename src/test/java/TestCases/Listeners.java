package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.BaseProject;
import resources.ExtentReporterNg;

import java.io.IOException;

public class Listeners extends BaseProject implements ITestListener {
    ExtentTest test;
    ExtentReports extent = new ExtentReporterNg().getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();


    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }


    public void onTestSuccess(ITestResult result) {

        extentTest.get().log(Status.PASS,"Status Passed");
    }

    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;

        String testMethodName= result.getMethod().getMethodName();
        try {
            System.out.println("in try block");
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            extentTest.get().addScreenCaptureFromPath(getScreeshotPath(testMethodName, driver),result.getMethod().getMethodName());
            //getScreeshotPath(testMethodName, driver);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
    }

