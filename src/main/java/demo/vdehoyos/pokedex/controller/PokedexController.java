package demo.vdehoyos.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.vdehoyos.pokedex.model.Root;
import demo.vdehoyos.pokedex.service.PokedexService;

@RestController
@RequestMapping(value = "/pokemon")
public class PokedexController {
	
	@Autowired
	private PokedexService service;

	@GetMapping("/all")
	public Root getAll(@RequestParam("limit") Long limit, @RequestParam("offset") Long offset) {
		try {
			return service.getAllPokemon(Long.valueOf(limit), Long.valueOf(offset));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
