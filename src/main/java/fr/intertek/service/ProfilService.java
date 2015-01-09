package fr.intertek.service;

import java.util.List;


import fr.intertek.model.Profil;

public interface ProfilService {

	public Profil save(Profil u);

	public void delete(Integer id);

	public Profil getProfilById(Integer id);

	public List<Profil> getUsers();

}