package com.springinaction.knights;

import org.springframework.stereotype.Component;

@Component
public class MakeRoundTableRounderQuest implements Quest {

  public void embark() throws QuestException {
    System.out.println("Making round table rounder");
  }

}
