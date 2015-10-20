package com.springinaction.knights;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class KnightDecorator implements BeanPostProcessor, BeanFactoryAware {

	private BeanFactory beanFactory;

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Knight) {
			System.out.println("**** AFTER - Bean name = " + beanName + " / bean = " + bean);
			return bean; // Ovako mogu unistiti bean
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Knight) {
			Knight knight = (Knight) bean;
			Weapon weapon = null;
			if (knight.getQuest() instanceof SlayDragonQuest) {
				weapon = (Weapon) beanFactory.getBean("holyLance");
			} else {
				weapon = (Weapon) beanFactory.getBean("sword");
			}
			knight.setWeapon(weapon);
 			System.out.println("**** BEFORE - Bean name = " + beanName + " / bean = " + bean);
		}
		return bean;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
