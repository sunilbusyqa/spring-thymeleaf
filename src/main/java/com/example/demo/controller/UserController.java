package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**
 * Documentation
 *
 * @author Sunil Dabburi
 * @since 1.0.0
 */
@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<User> userList = service.listAll();
		model.addAttribute("userList", userList);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "new_user";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		service.save(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String saveUser() {
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_user");
		User user = service.get(id);
		mav.addObject("user", user);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
