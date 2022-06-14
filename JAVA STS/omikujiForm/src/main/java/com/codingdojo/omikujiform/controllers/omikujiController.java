package com.codingdojo.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class omikujiController {
	
	@RequestMapping("/")
	public String form() { 
		return "Form.jsp";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String formMethod(
		@RequestParam(value="number") Integer number,
		@RequestParam(value="city") String city,
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="livingThing") String livingThing,
		@RequestParam(value="quote") String quote,
		HttpSession sesh) {
		
		sesh.setAttribute("number", number);
		sesh.setAttribute("city", city);
		sesh.setAttribute("person", person);
		sesh.setAttribute("hobby", hobby);
		sesh.setAttribute("livingThing", livingThing);
		sesh.setAttribute("quote", quote);
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String result() {
		return "result.jsp";
	}
}
