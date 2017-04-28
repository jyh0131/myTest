package com.dgit.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class SampleAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
    //@Before("execution(* com.dgit.service.MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("-------------------------");
		logger.info("-------------------------");
		System.out.println("startLog");
		logger.info(Arrays.toString(jp.getArgs()));
	}
    
    @Around("execution(* com.dgit.service.MessageService*.*(..))")
    public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
    	long startTime = System.currentTimeMillis();
    	
    	Object result = pjp.proceed();//proxy를 통해 target 메소드를 실행한다.
    	
    	long endTime = System.currentTimeMillis();
    	
    	logger.info("-------------------------");
    	logger.info("time :" +( endTime - startTime));
    	logger.info("-------------------------");
    	
    	return result;
    }
}



















