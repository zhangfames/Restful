package com.soft.api.controller;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * 
 * @author zf
 * @version 1.0
 *
 */
public class Main {
	public static final String BASE_URI = "http://localhost:8080/REST/";

	public static HttpServer getServer() {
		ResourceConfig rc = new ResourceConfig()
				.packages("com.soft.api.controller");
		return GrizzlyHttpServerFactory.createHttpServer(
				URI.create(Main.BASE_URI), rc);
	}
}
