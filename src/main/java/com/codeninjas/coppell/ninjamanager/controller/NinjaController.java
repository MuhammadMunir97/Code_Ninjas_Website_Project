package com.codeninjas.coppell.ninjamanager.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeninjas.coppell.ninjamanager.entities.CompletedGame;
import com.codeninjas.coppell.ninjamanager.entities.Ninja;
import com.codeninjas.coppell.ninjamanager.service.BeltService;
import com.codeninjas.coppell.ninjamanager.service.CompletedGameService;
import com.codeninjas.coppell.ninjamanager.service.GameService;
import com.codeninjas.coppell.ninjamanager.service.NinjaService;

@Controller
public class NinjaController {
	
	private final NinjaService ninjaService;
	private final BeltService beltService;
	private final CompletedGameService completedGameService;
	private final GameService gameService;
	
	public NinjaController(NinjaService ninjaService ,
							BeltService beltService ,
							CompletedGameService completedGameService,
							GameService gameService) {
		this.ninjaService = ninjaService;
		this.beltService = beltService;
		this.completedGameService = completedGameService;
		this.gameService = gameService;
	}
	
	@RequestMapping("/ninjas")
	public String showAllNinjas(Model model) {
		model.addAttribute("ninjas" , ninjaService.findAllNinjas());
		return "view/AllNinjas.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja) {
		return "view/NinjaForm.jsp";
	}
	
	@PostMapping("/ninjas")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/ninjas";
		}else {
			ninjaService.saveNinja(ninja);
			return "redirect:/ninjas";
		}
	}
	
	@RequestMapping("/ninjas/{ninjaId}")
	public String ninjaReport(@PathVariable("ninjaId") Long id , Model model , @ModelAttribute("completedGame") CompletedGame completedGame) {
		Ninja ninja = ninjaService.findNinjaById(id);
		model.addAttribute("currentNinja", ninja);
		model.addAttribute("completedGames", completedGameService.findCompGameByNinja(id));
		model.addAttribute("games", gameService.findByGamesNotInNinja(ninja));
		return "view/Ninja.jsp";
	}
	
	@PostMapping("/ninjas/{ninjaId}")
	public String ninjaReport(@PathVariable("ninjaId") Long id,
											@Valid @ModelAttribute("completedGame") CompletedGame completedGame ,
											BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/ninjas/{ninjaId}";
		}else {
			completedGame.setNinja(ninjaService.findNinjaById(id));
			completedGameService.saveCompletedGame(completedGame);
			return "redirect:/ninjas/{ninjaId}";
		}
	}
			
			
	@DeleteMapping("/ninjas/{id}")
	public String deleteNinja(@PathVariable("id") Long id) {
		ninjaService.deleteNinjaById(id);
		return "redirect:/ninjas";
	}
}
