package com.otoomo.codegenerator.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface XGenModel {
	String comment();
	boolean updateAble() default true;
}
