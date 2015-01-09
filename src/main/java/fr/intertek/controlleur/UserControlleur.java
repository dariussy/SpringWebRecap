package fr.intertek.controlleur;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.intertek.model.User;
import fr.intertek.service.UserService;

@Controller
public class UserControlleur {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("users", userService.getUsers());
		param.put("nbUsers", userService.getUsers().size());
		return new ModelAndView("list.jsp", param);
	}
	
	@RequestMapping(value = "editUser.do", method = RequestMethod.GET)
	public ModelAndView getUser() {
		Map<String, Object> param = new HashMap<String, Object>();
		User user = new User();
		param.put("user", user);
		return new ModelAndView("newUser.jsp", param);
	}
	
	@RequestMapping(value = "editUser.do", method = RequestMethod.POST)
	public ModelAndView editUser(User user) {
		userService.save(user);
		return listUsers();
	}
}
