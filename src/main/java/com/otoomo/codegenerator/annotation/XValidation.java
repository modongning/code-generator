package com.otoomo.codegenerator.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XValidation {
	boolean notNull() default false;
	int length();
	boolean number();
	boolean decimal();
	boolean mail();
	boolean phone();
	boolean mobile();
}
