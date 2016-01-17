package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.User;
import com.example.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	String list(Model model){
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "users/list";
	}
}
