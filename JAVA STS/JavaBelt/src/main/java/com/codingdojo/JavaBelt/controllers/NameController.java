package com.codingdojo.JavaBelt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.JavaBelt.models.NameClass;
import com.codingdojo.JavaBelt.models.User;
import com.codingdojo.JavaBelt.services.NameService;
import com.codingdojo.JavaBelt.services.UserService;


@Controller
public class NameController {
	
//	@Autowired
//	private UserService userService;
	@Autowired
	private NameService nameService;
	
	
	@GetMapping("/books/new")
	public String newName(@ModelAttribute("name1") NameClass name1) {
		
		
		
		return "newName.jsp";
	}
	
	
	@PostMapping("/books/new")
	public String createName(@Valid @ModelAttribute("name1") NameClass name1, BindingResult result) {
		if (result.hasErrors()) {
			return "newName.jsp";
		}
		else {
			
			nameService.createName(name1);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/edit/{id}") 
	public String editName(@PathVariable("id") Long id, Model model) {
		NameClass thisName = nameService.findName(id);
		model.addAttribute("thisName", thisName);
		return "edit.jsp";
	}

	
	@PutMapping("edit/{id}")
	public String update(@Valid @ModelAttribute("thisName") NameClass editedName, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			nameService.updateName(editedName);
			return "redirect:/show/{id}";
		}
	}
	
	@DeleteMapping ("/delete/{id}")
	public String destroy(@PathVariable ("id") Long id, RedirectAttributes flash) {
		nameService.deleteName(id);
		flash.addFlashAttribute ("deleteSuccess", "Name has been deleted!");
		return "redirect:/home";
	}
	
	
	
	
	
}
