package de.tetralog.v4wsmonitor.reports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Value("${cucumber.reporter.path}")
    private String reportPath;
    @Value("${host}")
    private String host;
    @Value("${server.port}")
    private Integer port;

    public List<String> getAllReports() {
        Path path = Paths.get(reportPath);
        List<String> result;
        if(path.toFile().isDirectory()) {
            result = Arrays.stream(path.toFile().listFiles())
                    .map(f -> f.getName())
                    .map(n -> host + ":" + port + "/reports/" + n)
                    .collect(Collectors.toList());
        } else {
            result = Collections.EMPTY_LIST;
        }
        return result;
    }

    public byte[] getReport(@PathVariable("name") String name) throws IOException {
        Path path =  Paths.get(reportPath + name);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Files.lines(path).map(line -> line.getBytes()).forEach(wrapper(baos::write));
        return baos.toByteArray();
    }

    private <T, E extends Exception> Consumer<T> wrapper(ConsumerWithException<T, E> fe) {
        return arg -> {
            try {
                fe.accept(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface
    public interface ConsumerWithException<T, E extends Exception> {
        void accept(T t) throws E;
    }
}
