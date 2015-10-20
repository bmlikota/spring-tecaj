package com.springinaction.knights;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component(value = "knight")
public class BraveKnight implements Knight, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
	@Autowired
	@Qualifier("slayDragonQuest")
	private Quest quest;
	
	@Autowired
	private Minstrel minstrel;

	@Autowired
	Apprentice apprentice;
	
	private String beanName;
	
	private ApplicationContext applicationContext;

	
	public void setQuest(Quest quest) {
		this.quest = quest;
	}
	
	//--- life cycle methods --------------------------------------------------
	
	public void embarkOnQuest() throws QuestException {
		try {
			quest.embark();
		} catch (QuestException e) {
			askForHelp();
		}
	}

	// @Override
	// public void embarkOnQuest2() throws QuestException {
	// embarkOnQuest();
	// }
	
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("BeanName is " + beanName);
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Bean is created by beanFactry " + beanFactory);
		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("Bean is created in applicationContext " + applicationContext.getDisplayName() );
		this.applicationContext = applicationContext;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if ( this.quest != null ) {
			System.out.println( "Quest set! ");
		}
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println( "Custom init!");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println( "Destroying bean!");
		
	}
	
	@PreDestroy
	public void customDestroy() {
		System.out.println( "Custom destroy!");
	}

	void askForHelp() {
		apprentice.helpKnight(quest);
	}

}
