package fr.intertek.service;

import java.util.List;

import fr.intertek.model.User;

public interface UserService {

	public User save(User u);

	public void delete(Integer id);

	public User getUserById(Integer id);

	public List<User> getUsers();

}