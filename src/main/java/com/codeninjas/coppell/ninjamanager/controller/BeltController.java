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

import com.codeninjas.coppell.ninjamanager.entities.Belt;
import com.codeninjas.coppell.ninjamanager.entities.Game;
import com.codeninjas.coppell.ninjamanager.repositories.GameRepository;
import com.codeninjas.coppell.ninjamanager.service.BeltService;
import com.codeninjas.coppell.ninjamanager.service.GameService;

@Controller
public class BeltController {
	
	private final BeltService beltService;
	private final GameService gameService;
	
	public BeltController(GameService gameService , BeltService beltService) {
		this.gameService = gameService;
		this.beltService = beltService;
	}
	
	@RequestMapping("/belts")
	public String showAllBelts(Model model) {
		model.addAttribute("belts", beltService.findAllBelts());
		return "/view/AllBelts.jsp";
	}
	
	@RequestMapping("/belts/new")
	public String newBelt(@ModelAttribute("belt") Belt belt) {
		return "/view/BeltForm.jsp";
	}
	
	@PostMapping("/belts")
	public String addBelt(@Valid @ModelAttribute("belt") Belt belt , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/belts";
		}else {
			beltService.saveBelt(belt);
			return "redirect:/belts";
		}
	}
	
	@RequestMapping("/belts/{beltId}/games")
	public String gamesInBelt(@PathVariable("beltId") Long id , Model model , @ModelAttribute("game") Game game) {
		model.addAttribute("belt", beltService.findBeltById(id));
		return "/view/BeltGames.jsp";
	}
	
	@PostMapping("/belts/{beltId}/games")
	public String addGameToBelt(@PathVariable("beltId") Long id ,
								@Valid @ModelAttribute("game") Game game ,
								BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/belts/{beltId}/games";
		}else {
			Belt belt = beltService.findBeltById(id);
			game.setBelt(belt);
			gameService.saveGame(game);
			return "redirect:/belts/{beltId}/games";
		}
		
	}
	
	@DeleteMapping("/belts/{beltId}/{gameId}")
	public String deleteGame(@PathVariable("gameId") Long id) {
		gameService.deleteGameById(id);
		return "redirect:/belts/{beltId}/games";
	}
	
	@DeleteMapping("/belts/{id}")
	public String deleteBelt(@PathVariable("id") Long id) {
		beltService.deleteBeltById(id);
		return "redirect:/belts";
	}
}
