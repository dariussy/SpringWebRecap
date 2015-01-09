package fr.intertek.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.intertek.model.User;

public interface UserDAO extends JpaRepository<User, Integer>{
}
