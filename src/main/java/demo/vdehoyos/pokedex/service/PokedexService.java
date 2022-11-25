package demo.vdehoyos.pokedex.service;

import demo.vdehoyos.pokedex.model.PokemonDetail;
import demo.vdehoyos.pokedex.model.Root;

public interface PokedexService {
	
	public Root getAllPokemon(Long limit, Long offset);
		
	public PokemonDetail findOne(Integer id);
	public PokemonDetail findOne(String name);
	
	public Object geyByURL(String url, Class<?> clazz);

}
