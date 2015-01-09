package fr.intertek.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.intertek.model.Profil;

public interface ProfilDAO extends JpaRepository<Profil, Integer>{
}
