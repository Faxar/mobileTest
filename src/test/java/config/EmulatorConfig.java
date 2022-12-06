package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/test/resources/emulator.properties"
})

public interface EmulatorConfig extends Config {
    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("app")
    String app();

    @Key("remoteURL")
    String remoteURL();

    @Key("automationName")
    String automationName();
}
