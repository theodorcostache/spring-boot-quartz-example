package de.costache.scheduledemo.controller.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Repeatable(ExceptionMappings.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionMapping {
	Class<? extends Throwable> exception();

	String message();

	int errorCode();
}
