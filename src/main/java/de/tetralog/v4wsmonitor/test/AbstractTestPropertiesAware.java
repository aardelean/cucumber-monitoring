package de.tetralog.v4wsmonitor.test;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class AbstractTestPropertiesAware {

    private Properties properties;

    public AbstractTestPropertiesAware() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getDefaultUser() {
        return get("default.user");
    }

    protected String getDefaultPass() {
        return get("default.pass");
    }

    protected String getTestEnv() {
        return get("test");
    }

    protected String getProdEnv() {
        return get("prod");
    }

    protected String getLocalEnv() {
        return get("local");
    }

    protected String get(String key) {
        return properties.getProperty(key);
    }
}
