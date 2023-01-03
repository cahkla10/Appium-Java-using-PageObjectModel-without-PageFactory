package setups;

import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import helpers.GlobalVariables;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;

public class DriverSetup extends DriverPool{
    private AppiumDriverLocalService service;

    protected void setDriver() throws MalformedURLException {
        switch (System.getProperty("device")){
            case "android":
                Capabilities capabilities = new Capabilities();
                AppiumDriver driver = new AndroidDriver(new URL(GlobalVariables.APPIUMURL), capabilities.android());
                setDriverInstance(driver);
                System.out.println("Driver: " + driver + "is running!");
                break;
            /*
            case "ios":
                break;
            */
        }
    }

    protected void startAppium(){
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        String service_url = service.getUrl().toString();
        System.out.println("Appium Service: " + service_url + "is running!");
    }

    protected void stopAppium(){
        service.stop();
        String service_url = service.getUrl().toString();
        System.out.println("Appium Service: " + service_url + "is stopped!");
    }
}