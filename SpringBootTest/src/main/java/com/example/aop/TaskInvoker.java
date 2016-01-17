package com.example.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TaskInvoker {
/*
	@Before("execution(* com.example.service.*.*(..))")
	public void before(JoinPoint joinPoint){
		String args = Arrays.toString(joinPoint.getArgs());
		Class clazz = joinPoint.getTarget().getClass();
		String name = joinPoint.getSignature().getName();
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.info(String.format("[AOP invoke before] %s#%s param:%s%n", clazz, name, args));
	}

	@After("execution(* com.example.service.*.*(..))")
	public void after(JoinPoint joinPoint){
		String args = Arrays.toString(joinPoint.getArgs());
		Class clazz = joinPoint.getTarget().getClass();
		String name = joinPoint.getSignature().getName();
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.info(String.format("[AOP invoke after] %s#%s param:%s%n", clazz, name, args));
	}

	@AfterReturning(value = "execution(* com.example.service.*.*(..))", returning="retVal")
	public void afterReturnning(Object retVal){
		System.out.println("AFTERAFTERAFTERAFTERAFTER");
	}
*/
	@Around("execution(* com.example.service.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Class<?> clazz = joinPoint.getTarget().getClass();
		String name = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		Logger logger = LoggerFactory.getLogger(clazz);

		logger.info(String.format("[AOP invoke around before] %s#%s param:%s%n", clazz, name, args));
//		System.out.println("このログは、@Aroundを使って、メソッド処理「前」に実行しています。");
 
		// 対象メソッド呼出
		Object message = joinPoint.proceed();

 		logger.info(String.format("[AOP invoke around after] %s#%s param:%s%n", clazz, name, args));
//		System.out.println("このログは、@Aroundを使って、メソッド処理「後」に実行しています。");
 
 		// メソッドの戻り値を返却しています。
 		return message;
	}
}
