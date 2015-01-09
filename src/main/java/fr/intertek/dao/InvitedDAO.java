package fr.intertek.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.intertek.model.Invited;

public interface InvitedDAO extends JpaRepository<Invited, Integer>{
}
