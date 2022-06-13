package com.codingdojo.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.fruityloops.Item;

@Controller 
public class ViewContollers {
	
//	@RequestMapping ("/")
//	public String Index(Model model) {
//		model.addAttribute("someKey", 100);
//		return "index.jsp";
//	}
	
    @RequestMapping("/")
    public String index(Model model) {
        
        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75));
        model.addAttribute("fruitList", fruits);
        // Add fruits your view model here
        
        return "index.jsp";
    }
}


