package com.springinaction.knights;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Minstrel {

	@Pointcut("execution(* com.springinaction.knights.Knight.embarkOnQuest(..))")
	public void quest() {
	}

	@Before("quest()")
	public void singBeforeQuest() {
		System.out.println("--> Fa la la; The knight is so brave!");
	}

	@After("quest()")
	public void singAfterQuest() {
		System.out.println("--> Tee hee he; The brave knight did embark on a quest!");
	}

	@AfterThrowing("quest()")
	public void singAfterQuestFailed() {
		System.out.println("--> The brave knight failed the quest!");
	}
}
