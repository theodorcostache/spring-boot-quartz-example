package de.costache.scheduledemo.controller.exception;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerExceptionInterceptor {

	@Around("execution(* de.costache.scheduledemo.controller..* (..))")
	public Object errorInterceptor(ProceedingJoinPoint pjp) throws Throwable {
		try {
			return pjp.proceed();
		} catch (Exception e) {

			MethodSignature signature = (MethodSignature) pjp.getSignature();
			Method method = signature.getMethod();

			ExceptionMapping[] exceptionMappings = method.getAnnotationsByType(ExceptionMapping.class);

			for (ExceptionMapping mapping : exceptionMappings) {
				throw new ControllerException(mapping.errorCode(), mapping.message());
			}

			throw new ControllerException(e);
		}
	}
}
