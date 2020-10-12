package com.bitmascot.webportal.controller;

import com.bitmascot.webportal.model.Information;
import com.bitmascot.webportal.model.Location;
import com.bitmascot.webportal.model.Users;
import com.bitmascot.webportal.service.ProfileService;
import com.bitmascot.webportal.service.UserService;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProfileService profileService;

	@GetMapping("/showLoginPage")
	public String showLoginPage(@ModelAttribute("oUsers") Users oUsers, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("SignUpMessage", " ");
		return "login";
	}

	@GetMapping("/registration")
	public String registration(@ModelAttribute("oUsers") Users oUsers, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("SignUpMessage", " ");
		return "registration";
	}


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("oUsers") Users oUsers, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("SignUpMessage", "Successfully Registered.Please Login");
		userService.save(oUsers);
		return "login";


	}

	BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String show(Model model, HttpServletRequest request, @ModelAttribute("oUsers") Users oUsers) {
		//	model.addAttribute("ousers", new Users());
		//Users ousers= new Users();
		HttpSession session = request.getSession(true);
		session.setAttribute("MAILID", oUsers.getEmail());
		session.setAttribute("NAME", oUsers.getUser_name());
		String json = new Gson().toJson(userService.listPersons());
		System.out.println("Json12" + json);
		boolean userExists = userService.checkLogin(oUsers.getEmail(),
				oUsers.getPassword());
		if (userExists) {
		model.addAttribute("listPersons", profileService.postList());
			return "home";
		} else {
			return "registration";
		}
	}


	@RequestMapping(value = "/poststatus", method = RequestMethod.POST)
	public String profile(Model model, @ModelAttribute("information") Information information,HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        String mailId = (String) session.getAttribute("MAILID");
        String name = (String) session.getAttribute("NAME");
        information.setMailId(mailId);
        information.setUser_name(name);
		profileService.save(information);
		return "profile";
	}

	@RequestMapping(value = "/profile")
	public String profile1(Model model, @ModelAttribute("information") Information information, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String mailId = (String) session.getAttribute("MAILID");
		String json = new Gson().toJson(userService.getlocation());
		System.out.println("Json" + json);


		Map<String, String> locationMap = new HashMap<String, String>();
		JSONArray topArray = null;
		topArray = new JSONArray(json);
		for(int i = 0; i < topArray.length(); i++){
			JSONObject c = topArray.getJSONObject(i);
			int id =  c.getInt("id");
			String str = Integer.toString(id);
			String city =c.getString("city");
			locationMap.put(str,city);
			model.addAttribute("locationList", locationMap);
			model.addAttribute("listProfile", profileService.listOfProfilePost(mailId));
			String json1= new Gson().toJson(userService.getlocation());
			System.out.println("Json" + json);
		}
		return "profile";

	}
}


