package de.tetralog.v4wsmonitor.reports;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Component
@Slf4j
public class CleanupScheduler {

    @Value("${cucumber.reporter.path}")
    private String reportPath;
    @Value("${cucumber.reporter.report-name-link-time-pattern}")
    private String reportNameLinkPattern;
    @Value("${schedulers.cheanUpJob.reportsMaxLifeTime}")
    private Long maxLifeTime;
    @Autowired
    private DateFormatter df;

    @Scheduled(fixedRate=86_400_000)
    public void deleteOldReports(){
        File reportsDirectory = Paths.get(reportPath).toFile();
        if (reportsDirectory.isDirectory()) {
            Arrays.stream(reportsDirectory.listFiles())
                    .filter(f -> isOlderThanMaxLifeTime(extractTimeValue(f.getName())))
                    .forEach(f -> f.delete());
        }
    }

    private String extractTimeValue(String reportName) {
        return reportName.substring(reportName.indexOf(reportNameLinkPattern) + reportNameLinkPattern.length(),
                reportName.indexOf(".html"));
    }

    private boolean isOlderThanMaxLifeTime(String dateTime) {
        try {
            Date date = df.parse(dateTime, Locale.GERMAN);
            return new Date().getTime() > date.getTime() + maxLifeTime;
        } catch (ParseException e) {
            log.error("Could not parse " + dateTime + " from reportName", e);
            return false;
        }
    }
}
