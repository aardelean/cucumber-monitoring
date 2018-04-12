package de.tetralog.v4wsmonitor;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
                glue = {"de.tetralog.v4wsmonitor"},
                features = {"classpath:f2.feature"})
public class V4wsMonitorApplicationTests {

}
