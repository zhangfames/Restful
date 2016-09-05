package com.soft.api.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author zf
 * @version 1.0
 */
@XmlRootElement
public class Mac implements Serializable {
	private static final long serialVersionUID = -5412407796497177784L;
	private Integer serialNumber;
	private String name;

	@XmlElement(name="serialNumber")
	public Integer getSerialNumber() {
		return serialNumber;
	}

	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

}
