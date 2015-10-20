package com.springinaction.knights;

import org.springframework.stereotype.Component;

@Component
public class SlayDragonQuest implements Quest {

	@Override
	public void embark() throws QuestException {
		// System.out.println("Dragon is dead!");
		throw new QuestException();
	}

}
