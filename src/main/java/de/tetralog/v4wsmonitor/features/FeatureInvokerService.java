package de.tetralog.v4wsmonitor.features;

import cucumber.api.cli.Main;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.java.JavaBackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class FeatureInvokerService {
    @Value("${cucumber.reporter.class}")
    private String reporterClass;
    @Value("${cucumber.reporter.path}")
    private String reportPath;
    @Value("${cucumber.reporter.report-name-link-time-pattern}")
    private String reportNameLinkPattern;

    @Autowired
    private DateFormatter df;

    public String fireTest(List<String> features){
        String reportSuffix = df.print(new Date(), Locale.GERMAN);
        String featuresJoined = features.stream()
                .collect(Collectors.joining("_"));
        String reportName = featuresJoined
                .substring(0, Math.min(featuresJoined.length(), 40))
                .concat(reportNameLinkPattern)
                .concat(reportSuffix)
                .concat(".html");
        executeTests(features, reportName);
        return reportName;
    }

    private void executeTests(List<String> features, String reportName) {
        try {
            List<String> args = features.stream()
                    .map(f -> "src/main/resources/" + f + ".feature")
                    .collect(Collectors.toList());
            args.add("-g");
            args.add("de.tetralog.v4wsmonitor.test");
            args.add("-p");
            args.add("html:" + reportPath + reportName);
            runtimeRun(args);
//            mainRun(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException("Could not execute tests: ", throwable);
        }
    }
    private void mainRun(List<String> args) throws IOException {
        Main.run(args.toArray(new String[args.size()]), Thread.currentThread().getContextClassLoader());
    }
    private void runtimeRun(List<String> args) throws IOException {
//        args.add(reporterClass + ":" + reportPath + reportName);
        RuntimeOptions runtimeOptions = new RuntimeOptions(args);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ResourceLoader resourceLoader = new MultiLoader(classLoader);
//        ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
        JavaBackend backend = new JavaBackend(resourceLoader);
        Runtime runtime = new Runtime(resourceLoader,
                classLoader,
                Collections.singletonList(backend),
                runtimeOptions,
                null);
        runtime.run();
    }
}
