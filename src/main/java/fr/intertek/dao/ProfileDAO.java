package fr.intertek.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.intertek.model.Profile;

public interface ProfileDAO extends JpaRepository<Profile, Integer>{
}
