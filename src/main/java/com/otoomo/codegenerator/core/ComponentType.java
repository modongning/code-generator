package com.otoomo.codegenerator.core;

/**
 * @Author modongning
 * @updateBy modongning
 * @updateBy 2019/10/16 下午3:13
 */
public enum ComponentType {

	INPUT("Input"),
	SELECT("Select");

	ComponentType(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
