package com.codingdojo.DojosAndNinjas.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.services.DojoService;
import com.codingdojo.DojosAndNinjas.services.NinjaService;

@Controller
public class ViewController {
	
	@Autowired 
    private final DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
    public ViewController(DojoService dojoService){
        this.dojoService = dojoService;
    }
    
	@RequestMapping("/")
	public String allDojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> allDaDojos = dojoService.allDojos();
		
		model.addAttribute("allDaDojos", allDaDojos);
		return "NewDojo.jsp";
	}

	@PostMapping("/")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model)
			
	{
		if (result.hasErrors()) {
			// NEED TO 
			List<Dojo> allDaDojos = dojoService.allDojos();
			model.addAttribute("allDaDojos", allDaDojos);
            return "allDojos.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
	   

	}
	
	@GetMapping("/edit/{id}") 
	public String editDojo(@PathVariable("id") Long id, Model model) {
		Dojo thisDojo = dojoService.findDojo(id);
		model.addAttribute("thisDojo", thisDojo);
		return "edit.jsp";
	}
	
	@GetMapping("/show/{id}") 
	public String showOne(@PathVariable("id") Long id, Model model) {
		Dojo thisDojo = dojoService.findDojo(id);
		model.addAttribute("thisDojo", thisDojo);
		
		List<Ninja> allDaNinjas = ninjaService.allNinjas();
		model.addAttribute("allDaNinjas", allDaNinjas);
		
		return "showAll.jsp";
	}
	
	@PutMapping("edit/{id}")
	public String update(@Valid @ModelAttribute("thisDojo") Dojo editedDojo, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			dojoService.updateDojo(editedDojo);
			return "redirect:/";
		}
	}
	
	@DeleteMapping ("/{id}")
	public String destroy(@PathVariable ("id") Long id, RedirectAttributes flash) {
		dojoService.deleteDojo(id);
		flash.addFlashAttribute ("deleteSuccess", "Dojo has been deleted!");
		return "redirect:/";
	}
	//================================NINJA===============================
	
	@GetMapping("/ninja")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Dojo> allDaDojos = dojoService.allDojos();
		model.addAttribute("allDaDojos", allDaDojos);
		
		List<Ninja> allDaNinjas = ninjaService.allNinjas();
		model.addAttribute("allDaNinjas", allDaNinjas);
		
		
		return "NewNinja.jsp";
	}
	
	@PostMapping("/ninja")
	public String createNinja(@Valid @ModelAttribute("thisNinja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "NewNinja.jsp";
		}
		else {
			
			ninjaService.createNinja(ninja);
			return "redirect:/ninja";
		}
	}
	

	
	
	
	
}
