package de.tetralog.v4wsmonitor.features;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class HealthCheckScheduler {

    @Autowired
    private FeatureInvokerService service;

    @Value("#{'${cucumber.healthCheck.features}'.split(',')}")
    private List<String> features;

    @Scheduled(fixedRate = 900_000)
    public void reportCurrentTime() {
        log.info("New Health Check Report generated: {}", service.fireTest(features));
    }
}
