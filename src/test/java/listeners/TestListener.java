package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import tests.BaseTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private final String screenshotsPath = System.getProperty("user.dir") + "/screenshots";

    @Override
    public void onStart(ITestContext context) {
        File screenshotsDir = new File(screenshotsPath);
        if (screenshotsDir.exists() && screenshotsDir.isDirectory()) {
            File[] files = screenshotsDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }
            System.out.println("🧹Previous screenshots removed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("💥Test Failed: " + result.getName());

        Object testClass = result.getInstance();

        try {
            WebDriver driver = ((BaseTest) testClass).getDriver();

            if (driver != null) {
                File screenshotsDir = new File(screenshotsPath);
                if (!screenshotsDir.exists()) screenshotsDir.mkdirs();

                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String screenshotName = result.getName() + "_" + timestamp + ".png";

                System.out.println("📸Taking screenshot on: " + screenshotsDir + "\\" + screenshotName);
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File(screenshotsDir, screenshotName));
                System.out.println("✅Screenshot successfully saved");
            } else {
                System.err.println("❌Null driver. Could not take screenshot.");
            }
        } catch (Exception e) {
            System.err.println("❌Error taking screenshot.");
            e.printStackTrace();
        }
    }

    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onFinish(ITestContext context) {}
}