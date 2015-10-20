package com.springinaction.knights;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class KnightDecorator implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if ( bean instanceof Knight ) {
			System.out.println( " Bean " + beanName + " decoreted before creation!");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if ( bean instanceof Knight ) {
			System.out.println( " Bean " + beanName + " decoreted after creation!");
		}
		return bean;
	}

}
