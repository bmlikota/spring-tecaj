package net.springinaction.exercise1.dao.repository;

import net.springinaction.exercise1.model.SeatingPlan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatingPlanRepository extends JpaRepository<SeatingPlan, Long> {

	List<SeatingPlan> findById(Long id);
}
