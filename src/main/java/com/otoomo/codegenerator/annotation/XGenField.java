package com.otoomo.codegenerator.annotation;

import com.otoomo.codegenerator.core.ComponentType;
import com.otoomo.codegenerator.core.Default;
import com.otoomo.codegenerator.core.EnumData;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XGenField {
	String comment() default "";

	boolean key() default false;

	boolean autoIncrease() default false;

	int length() default 0;

	boolean notNull() default false;

	boolean query() default false;

	boolean index() default false;

	boolean uniqueKey() default false;

	boolean bigText() default false;

	boolean ascOrder() default false;

	boolean descOrder() default false;

	Default def() default Default._DEFAULT;

	/**
	 * 前端组件类型
	 *
	 * @return
	 */
	ComponentType componentType() default ComponentType.INPUT;

	/**
	 * 枚举列表键值
	 *
	 * @return
	 */
	EnumData[] enumData() default {};
}
