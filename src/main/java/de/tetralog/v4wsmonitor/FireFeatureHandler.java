package de.tetralog.v4wsmonitor;

import cucumber.api.cli.Main;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class FireFeatureHandler implements HttpHandler {
    private static final String FEATURE_PARAM_NAME = "feature";
    private static final String REPORT_PARAM_NAME = "reportName";
    private String reportPath;

    public FireFeatureHandler(String reportPath) {
        this.reportPath = reportPath;
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        Deque<String> featureParams = exchange.getQueryParameters().get(FEATURE_PARAM_NAME);
        List<String> features = new ArrayList<>();
        String featureParam;
        while((featureParam = featureParams.poll())!= null) {
            features.add(featureParam);
        }
        String reportName = exchange.getQueryParameters().get(REPORT_PARAM_NAME).getFirst();
        ForkJoinPool.commonPool().execute(() -> executeTests(features, reportName));
        exchange.getResponseSender().send("Report can be seen at: " + exchange.getHostAndPort() + "/reports/" + reportName);
    }

    private void executeTests(List<String> features, String reportName) {
        try {
            List<String> args = features.stream()
                    .map(f -> "classpath:" + f + ".feature")
                    .collect(Collectors.toList());
            args.add("-g");
            args.add("de.tetralog.v4wsmonitor.test");
            args.add("-p");
            args.add("com.cucumber.listener.ExtentCucumberFormatter:" + reportPath + reportName);
            mainRun(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException("Could not execute tests: ", throwable);
        }
    }
    private void mainRun(List<String> args) throws IOException {
        Main.run(args.toArray(new String[args.size()]), Thread.currentThread().getContextClassLoader());
    }
}
