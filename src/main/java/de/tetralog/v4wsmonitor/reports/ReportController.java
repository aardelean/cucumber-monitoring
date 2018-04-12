package de.tetralog.v4wsmonitor.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(path = "/reports", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping(path = "/reports/{name}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<byte[]> getReport(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(reportService.getReport(name));
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
