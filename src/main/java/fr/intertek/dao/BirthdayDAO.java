package fr.intertek.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.intertek.model.Birthday;

public interface BirthdayDAO extends JpaRepository<Birthday, Integer>{
}
