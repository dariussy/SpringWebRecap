package fr.intertek.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.intertek.model.Evaluation;

public interface EvaluationDAO extends JpaRepository<Evaluation, Integer>{
}
