package com.springinaction.knights;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApprenticeLogger {

	@Pointcut(value = "execution(* com.springinaction.knights.Apprentice.helpKnight(com.springinaction.knights.Quest)) && args(quest)", argNames = "quest")
	public void apprenticeAskedForHelp(Quest quest) {
		
	}

	@Around("com.springinaction.knights.ApprenticeLogger.apprenticeAskedForHelp(Quest)")
	public void logCallForHelp(ProceedingJoinPoint joinPoint) throws Throwable  {
		System.out.println("******** Before help knight : quest = " + joinPoint.getArgs()[0].getClass().getSimpleName());
		joinPoint.proceed();
		System.out.println("******** After help knight : quest = " + joinPoint.getArgs()[0].getClass().getSimpleName());
	}
}
