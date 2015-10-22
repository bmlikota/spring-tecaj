package net.springinaction.exercise1.service;

import java.util.List;

import net.springinaction.exercise1.model.SeatingPlan;

public interface SeatingPlanService {

	List<SeatingPlan> findAll();
}
