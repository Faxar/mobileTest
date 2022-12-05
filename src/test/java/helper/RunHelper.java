package helper;

import config.ConfigReader;
import driver.EmulatorDriver;

public class RunHelper {

    private RunHelper(){
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        String deviceHost = ConfigReader.testConfig.deviceHost();

        if ("emulator".equals(deviceHost)) {
            return EmulatorDriver.class;
        }
        throw new RuntimeException("Configuration file doesn't have deviceHost parameter");
    }
}
