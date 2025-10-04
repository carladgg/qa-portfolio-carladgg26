package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        Object testClass = result.getInstance();

        try {
            // Acceder al campo driver usando reflection
            Field driverField = testClass.getClass().getDeclaredField("driver");
            driverField.setAccessible(true); // permite acceder a private/protected
            WebDriver driver = (WebDriver) driverField.get(testClass);

            // Crear nombre único para el screenshot
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = result.getName() + "_" + timestamp + ".png";
            String path = System.getProperty("user.dir") + "/screenshots/" + screenshotName;

            // Tomar screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(path));

            System.out.println("Screenshot guardado en: " + path);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.err.println("No se pudo acceder al driver para tomar screenshot.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error al tomar screenshot.");
            e.printStackTrace();
        }
    }

    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}

