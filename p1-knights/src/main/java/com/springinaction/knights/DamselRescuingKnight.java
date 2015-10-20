package com.springinaction.knights;
/**
 * No Dependency Injection (DI) Knight implementation.
 * 
 *
 */
public class DamselRescuingKnight {
  private RescueDamselQuest quest;
  
  public DamselRescuingKnight() {
    quest = new RescueDamselQuest();
  }
  
  public void embarkOnQuest() throws QuestException {
    quest.embark();
  }
}
