package helpers;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.config;

public abstract class baseTest {
    AppiumDriverLocalService service;
    protected AndroidDriver driver;

    //lancer automatiquement le serveur appium
    public AppiumDriverLocalService startAppiumServer() {
        System.out.println("BeforeSuite");
        boolean running = isServerRunning(config.appiumPort);
        if (!running) {
            service = new AppiumServiceBuilder()
            .withAppiumJS(new File(config.appiumJSExecutor))
            .withIPAddress(config.appiumServer)
            .withLogFile(new File(config.appiumLog))
            .withTimeout(Duration.ofSeconds(config.appiumServerTimeOut))
            .usingPort(config.appiumPort).build();
            service.start();
        }
        return service;
    }
    
    public boolean isServerRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSock;
        try {
            serverSock = new ServerSocket(port);
            serverSock.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSock = null;
        }
        return isServerRunning;
    }        
    
    public void emulatorDriver() throws MalformedURLException, InterruptedException {
        System.out.println("BeforeMethod");
        UiAutomator2Options options = new UiAutomator2Options();           
        options.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
        options.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "14");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:deviceName", "emulator-5554");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));    
    }

    //démarer automatiquement le device
    public void startDevice() throws InterruptedException{
        System.out.println("BeforeClass");
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "C:\\Users\\dbrisseau2024\\AppData\\Local\\Android\\Sdk\\emulator\\emulator -avd NPOT -netdelay none -netspeed full");
        
        try {
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }         
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @AfterSuite
    public void stop(){
        driver.quit();
    }

    //méthode pour le scroll automatique afin d'atteindre les articles en bas de page
    public void scrollDown(){
        Dimension size = driver.manage().window().getSize();
            int startX = size.getWidth() / 2;
            int startY = size.getHeight() / 2;
            int endX = startX;
            int endY = (int) (size.getHeight() * 0.25);
            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(sequence));        
    }

}