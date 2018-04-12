package de.tetralog.v4wsmonitor.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeatureInvokerController {

    @Value("${cucumber.reporter.class}")
    private String reporterClass;
    @Value("${cucumber.reporter.path}")
    private String reportPath;
    @Value("${host}")
    private String host;
    @Value("${server.port}")
    private Integer port;

    @Autowired
    private DateFormatter df;

    @Autowired
    private FeatureInvokerService service;

    @GetMapping(path = "/start")
    public String startFeature(@RequestParam("feature") List<String> features) {
        return host + ":" + port + "/report/" + service.fireTest(features);
    }

}
