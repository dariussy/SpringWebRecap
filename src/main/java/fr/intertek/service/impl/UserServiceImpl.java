package fr.intertek.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.intertek.dao.UserDAO;
import fr.intertek.model.User;
import fr.intertek.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDAO dao;
	
	/* (non-Javadoc)
	 * @see fr.intertek.service.impl.UserService#save(fr.intertek.model.User)
	 */
	@Transactional
	public User save(User u) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(u.getPassword());
		u.setPassword(hashedPassword);
		return dao.save(u);
	}
	
	/* (non-Javadoc)
	 * @see fr.intertek.service.impl.UserService#delete(java.lang.Integer)
	 */
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see fr.intertek.service.impl.UserService#getUserById(java.lang.Integer)
	 */
	public User getUserById(Integer id) {
		return dao.findOne(id);
	}
	
	/* (non-Javadoc)
	 * @see fr.intertek.service.impl.UserService#getUsers()
	 */
	public List<User> getUsers() {
		return dao.findAll();
	}
	
}
