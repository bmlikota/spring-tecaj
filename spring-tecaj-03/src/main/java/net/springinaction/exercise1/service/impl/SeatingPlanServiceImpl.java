package net.springinaction.exercise1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springinaction.exercise1.dao.repository.SeatingPlanRepository;
import net.springinaction.exercise1.model.SeatingPlan;
import net.springinaction.exercise1.service.SeatingPlanService;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

	@Autowired
	private SeatingPlanRepository repository;
	
	@Override
	public List<SeatingPlan> findAll() {
		return repository.findAll();
	}

}
