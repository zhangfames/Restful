package com.soft.api.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soft.api.model.Mac;

/**
 * 
 * @author zf
 * @version 1.0
 * @description 只是针对restAPI做了简单的实现，无需实现更多的内容,所以忽略了业务层和DAO层
 */
@Path("apple")
@Consumes({ MediaType.TEXT_PLAIN })
@Produces({ MediaType.TEXT_PLAIN })
public class RestApi {
	private static final Logger log = LoggerFactory.getLogger(RestApi.class);
	private static final String SUCCESS = "success";

	@Path("iphone")
	@GET
	public String getIphone() {
		log.debug("come on");
		return SUCCESS;
	}

	@Path("ipad/{model}")
	@PUT
	public String updateIpad(@PathParam("model") String model, String body) {
		log.debug("model:{},{}", model, body);
		return SUCCESS;
	}

	@Path("mac")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public String addMac(Mac mac) {
		log.debug("MAC:{},{}", mac.getSerialNumber(), mac.getName());
		return SUCCESS;
	}

	@Path("watch/{serialNumber}")
	@DELETE
	public String deleteWatch(@PathParam("serialNumber") Integer serialNumber) {
		log.debug("ID:{}", serialNumber);
		return SUCCESS;
	}
}
