package fr.intertek.controlleur;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.intertek.model.User;
import fr.intertek.service.UserService;

@Controller
@RequestMapping("/user")
public class UserControlleur {
	
	@Autowired
	public UserService userService;
	
	/**
	 * List des utilisateurs de la BD
	 * @return tableau de la liste des utilisateurs
	 */
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("users", userService.getUsers());
		param.put("nbUsers", userService.getUsers().size());
		return new ModelAndView("list.jsp", param);
	}
	/**
	 * Fonction permettant l'edition d'un utilisateur
	 * @param user (informations de l'utilisateur à charger)
	 * @return formulaire d'édition de l'utilisateur
	 */
	public ModelAndView getUser(User user) {
		Map<String, Object> param = new HashMap<String, Object>();
		user.setPassword("");
		param.put("user", user);
		return new ModelAndView("newUser.jsp", param);
	}
	/**
	 * fonction chargant les information de l'utilisateur a partir de son id
	 * @param UserId : id de l'utilisateur sur le quel on souhaite éditer les informations 
	 * @return vers formulaire d'dition utilisateur
	 */
	@RequestMapping(value = "editUser.do", method = RequestMethod.GET)
	public ModelAndView chargeUserFromId(Integer UserId) {
		User user = userService.getUserById(UserId);
		return getUser(user);
	}
	/**
	 * Fonction permettant la cration d'un nouveau utilisateur
	 * @return formulaire de création utilisateur
	 */
	@RequestMapping(value = "newUser.do", method = RequestMethod.GET)
	public ModelAndView newUser() {
		return getUser(new User());
	}
	/**
	 * Creation utilisateur
	 * @param user information de l'utilisateur à crée ou modifier
	 * @return list des utilisateurs
	 */
	@RequestMapping(value = "saveUser.do", method = RequestMethod.POST)
	public ModelAndView editUser(@Valid User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return getUser(user);
		}
		userService.save(user);
		return listUsers();
	}
	
}
