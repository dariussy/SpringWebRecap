package fr.intertek.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.intertek.model.Idea;

public interface IdeaDAO extends JpaRepository<Idea, Integer>{
}
