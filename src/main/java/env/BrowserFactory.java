package env;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Basic Browser factory configuration.
 */
public class BrowserFactory {

    private Function<DesiredCapabilities, DesiredCapabilities> capabilitiesConf = Function.identity();
    private Function<WebDriver, WebDriver> driverConf                           = Function.identity();

    public BrowserFactory(Supplier<WebDriver> originalDriver) {
        driverConf = d -> originalDriver.get();
    }

    public BrowserFactory setJavascript(boolean isEnabled) {
        capabilitiesConf = capabilitiesConf.andThen(capabilities -> {
            capabilities.setJavascriptEnabled(isEnabled);
            return capabilities;
        });
        return this;
    }

    public BrowserFactory setCapability(String name, Object value) {
        capabilitiesConf = capabilitiesConf.andThen(capabilities -> {
            capabilities.setCapability(name, value);
            return capabilities;
        });
        return this;
    }

    public BrowserFactory setMaximizeWindowOnStart(boolean isToMaximize) {
        if (isToMaximize) {
            driverConf = driverConf.andThen(driver -> {
                driver.manage().window().maximize();
                return driver;
            });
        }
        return this;
    }

    public BrowserFactory setBrowserTimeout(TimeUnit timeout, int value) {
        driverConf = driverConf.andThen(driver -> {
            driver.manage().timeouts().setScriptTimeout(value, timeout);
            return driver;
        });
        return this;
    }

    public BrowserFactory setDriverPath(String key, String value) {
        System.setProperty(key, value);
        return this;
    }

    /**
     * Creates WebDriver with specified configurations.
     * @return WebDriver
     */
    public WebDriver build() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilitiesConf.apply(capabilities);
            WebDriver driver = driverConf.apply(null);
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

