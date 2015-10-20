package com.springinaction.knights;

public class SlayDragonQuest implements Quest {

	@Override
	public void embark() throws QuestException {
		System.out.println("Dragon is dead!");
	}

}
