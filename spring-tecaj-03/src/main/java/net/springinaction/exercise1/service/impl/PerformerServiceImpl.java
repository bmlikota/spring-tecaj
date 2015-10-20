package net.springinaction.exercise1.service.impl;

import net.springinaction.exercise1.dao.repository.PerformerRepository;
import net.springinaction.exercise1.service.PerformerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformerServiceImpl implements PerformerService {

	@Autowired
	private PerformerRepository reposiotry;
	
	@Override
	public long count() {
		return reposiotry.count();
	}

}
