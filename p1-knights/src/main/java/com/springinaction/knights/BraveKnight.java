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

/**
 * Dependency Injection (DI) Knight implementation.
 * 
 * Receives quest from outside (Spring application container).
 * 
 * @author domagoj
 *
 */
@Component("knight")
public class BraveKnight implements Knight, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

	public BraveKnight() {
		// empty constructor
	}

	@Autowired
	@Qualifier(value = "damselQuest")
	private Quest quest;

	private String beanName;

	private Weapon weapon;

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public BraveKnight(Quest quest) {
		this.quest = quest;
	}

	public void embarkOnQuest() throws QuestException {
		System.out.println("**** Going on a Quest - Using weapon = " + weapon);
		quest.embark();
	}

	public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("**** Bean namse is = " + beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		System.out.println("**** Bean is created by factory = " + factory);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("**** Bean resides in ApplicationContext = " + applicationContext);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (quest != null) {
			System.out.println("**** " + beanName + " : I have quest - great!");
		}
		if (weapon != null) {
			System.out.println("**** " + beanName + " : I also have a weapons - super great!");
		}
	}

	@PostConstruct
	public void init() {
		System.out.println("**** " + beanName + " - Custom INIT invoked!");
	}

	@PreDestroy
	public void preDestroy() throws Exception {
		System.out.println("**** " + beanName + " - Returning weapon to armory - " + weapon);
	}

}
