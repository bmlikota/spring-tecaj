package com.springinaction.knights;

import org.springframework.stereotype.Component;

@Component
public class BraveApprentice implements Apprentice {

	@Override
	public void helpKnight(Quest quest) {
		System.out.println("************* Apprentice helps!");
	}

}
