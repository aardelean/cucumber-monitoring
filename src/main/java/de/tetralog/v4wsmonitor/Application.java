package de.tetralog.v4wsmonitor;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.resource.DefaultResourceSupplier;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;

import java.io.File;

public class Application {

	public static void main(final String[] args) {
		Undertow server = Undertow.builder()
				.addHttpListener(7070, "localhost")
				.setHandler(Handlers.path()
                        .addExactPath("fire", new FireFeatureHandler(args[0]))
                        .addPrefixPath("reports", new ResourceHandler(
                                new DefaultResourceSupplier(
                                        new FileResourceManager(new File(args[0])))
                        ))
                        .addPrefixPath("version",
                                exchange -> exchange.getResponseSender().send("1.0"))
                ).build();
		server.start();
	}
}
