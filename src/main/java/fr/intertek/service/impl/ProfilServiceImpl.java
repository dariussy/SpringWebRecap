package fr.intertek.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.intertek.dao.ProfilDAO;
import fr.intertek.model.Profil;
import fr.intertek.service.ProfilService;

@Service
public class ProfilServiceImpl implements ProfilService {
	
	@Autowired
	public ProfilDAO dao;
	
	@Transactional
	public Profil save(Profil u) {
		return dao.save(u);
	}
	
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}
	
	public Profil getProfilById(Integer id) {
		return dao.findOne(id);
	}
	
	public List<Profil> getUsers() {
		return dao.findAll();
	}
	
}
