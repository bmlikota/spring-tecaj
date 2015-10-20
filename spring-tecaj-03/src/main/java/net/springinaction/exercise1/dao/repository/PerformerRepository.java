package net.springinaction.exercise1.dao.repository;

import net.springinaction.exercise1.model.Performer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformerRepository extends JpaRepository<Performer, Long> {
}
