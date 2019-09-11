package com.codeninjas.coppell.ninjamanager.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeninjas.coppell.ninjamanager.entities.Game;
import com.codeninjas.coppell.ninjamanager.entities.GameConcept;
import com.codeninjas.coppell.ninjamanager.service.GameConceptService;
import com.codeninjas.coppell.ninjamanager.service.GameService;

@Controller
public class GameConceptController {
	
	private final GameConceptService gameConceptService;
	private final GameService gameService;
	
	public GameConceptController(GameConceptService gameConceptService , GameService gameService) {
		this.gameConceptService = gameConceptService;
		this.gameService = gameService;
	}
	
	@RequestMapping("games/{id}")
	public String newGameConcept(@ModelAttribute("gameConcept") GameConcept gameConcept , Model model , @PathVariable("id") Long id) {
		Game game = gameService.findGameById(id);
		gameConcept.setGame(game);
		model.addAttribute("theGame", game);
		return "view/GameConcepts.jsp";
	}
	
	@PostMapping("games/{id}")
	public String addGameConcept(@Valid @ModelAttribute("gameConcept") GameConcept gameConcept , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("error");
			return "redirect:games/{id}";
		}else {
			gameConceptService.saveGameConcept(gameConcept);
			return "redirect:games/{id}";
		}
	}
	
}
