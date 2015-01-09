package fr.intertek.service;

import java.util.List;


import fr.intertek.model.Profile;

public interface ProfileService {

	public Profile save(Profile u);

	public void delete(Integer id);

	public Profile getProfilById(Integer id);

	public List<Profile> getProfiles();

}