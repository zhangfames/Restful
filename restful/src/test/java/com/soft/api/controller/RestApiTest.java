package com.soft.api.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.soft.api.model.Mac;

/**
 * 
 * @author zf
 * @version 1.0
 *          <p>
 *          该类对restful接口的GET,PUT,POST和DELETE方法进行了测试
 *          </p>
 *
 */
public class RestApiTest {

	private static HttpServer server;
	private static WebTarget target;
	private static final String SUCCESS = "success";

	@BeforeClass
	public static void setUpBeforClass() throws Exception {
		server = Main.getServer();
		server.start();
		Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		server.shutdownNow();

	}

	@Test
	public void testGetIphone() {
		String resp = target.path("apple/iphone")
				.request(MediaType.TEXT_PLAIN_TYPE).get(String.class);
		Assert.assertEquals(SUCCESS, resp);
	}

	@Test
	public void testUpdateIpad() {
		Entity<String> entity = Entity.entity("测试put",
				MediaType.TEXT_PLAIN_TYPE);
		String resp = target.path("apple/ipad/20160905")
				.request(MediaType.TEXT_PLAIN_TYPE).put(entity, String.class);
		Assert.assertEquals(SUCCESS, resp);
	}

	@Test
	public void testAddMac() {
		Mac mac = new Mac();
		mac.setSerialNumber(1010);
		mac.setName("Apple MacBook Pro 15.4英寸笔记本电脑 银色");
		Entity<Mac> entity = Entity.entity(mac, MediaType.APPLICATION_XML_TYPE);
		String resp = target.path("apple/mac")
				.request(MediaType.TEXT_PLAIN_TYPE).post(entity, String.class);
		Assert.assertEquals(SUCCESS, resp);
	}

	@Test
	public void testDeleteWatch() {
		String resp = target.path("apple/watch/201609051")
				.request(MediaType.TEXT_PLAIN_TYPE).delete(String.class);
		Assert.assertEquals(SUCCESS, resp);
	}

}
