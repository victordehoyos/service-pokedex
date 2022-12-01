package demo.vdehoyos.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.vdehoyos.pokedex.model.PokemonDetailResponse;
import demo.vdehoyos.pokedex.model.Response;
import demo.vdehoyos.pokedex.service.PokedexService;

@RestController
@RequestMapping(value = "/pokemon")
public class PokedexController {
	
	@Autowired
	private PokedexService service;

	@GetMapping("/all")
	public Response getAll(@RequestParam(name = "limit", required = false) Long limit, @RequestParam(name = "offset", required = false) Long offset) {
		try {
			
			if(limit == null && offset == null) {
				return service.getAllPokemon();
			}
			
			return service.getAllPokemon(limit, offset);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/{name}")
	public PokemonDetailResponse findPokemon(@PathVariable("name") String name) {
		return service.getPokemonDetail(name);
	}
	
}
