package demo.vdehoyos.pokedex.service;

import demo.vdehoyos.pokedex.model.PokemonDetail;
import demo.vdehoyos.pokedex.model.PokemonDetailResponse;
import demo.vdehoyos.pokedex.model.Response;

public interface PokedexService {
	
	public Response getAllPokemon(Long limit, Long offset);
	public Response getAllPokemon();
		
	public PokemonDetail findOne(Integer id);
	public PokemonDetail findOne(String name);
	public PokemonDetailResponse getPokemonDetail(String name);
	
	//public Object getByURL(String url, Class<?> clazz);

}
