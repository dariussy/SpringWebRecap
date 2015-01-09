package fr.intertek.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.intertek.dao.ProfileDAO;
import fr.intertek.model.Profile;
import fr.intertek.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	public ProfileDAO dao;
	
	@Transactional
	public Profile save(Profile u) {
		return dao.save(u);
	}
	
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}
	
	public Profile getProfilById(Integer id) {
		return dao.findOne(id);
	}
	
	public List<Profile> getProfiles() {
		return dao.findAll();
	}
	
}
