package com.otoomo.codegenerator.core;

/**
 * @Author modongning
 * @updateBy modongning
 */
public enum Default {

	_DEFAULT(-1),
	DEFAULT_INT_ZERO(0),
	DEFAULT_INT_ONE(1),
	DEFAULT_STR_EMPTY(""),
	DEFAULT_STR_NULL(null);

	private Object value;

	Default(Object value) {
		this.value = value;
	}

	/**
	 * 覆盖
	 * @return
	 */
	@Override
	public String toString() {
		return value+"";
	}
}
