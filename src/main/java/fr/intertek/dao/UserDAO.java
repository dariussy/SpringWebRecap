package fr.intertek.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.intertek.model.User;

public interface UserDAO extends JpaRepository<User, Integer>{

	
	@Query("Select u from User u left join fetch u.profiles where u.login = :login")
	public User findByLogin(@Param("login") String login);
}
