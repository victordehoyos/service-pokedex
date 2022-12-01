package demo.vdehoyos.pokedex.model;

import com.github.oscar0812.pokeapi.models.evolution.ChainLink;

import lombok.Data;

@Data
public class EvolutionChain {
	
	private String url;
	private boolean is_fetched;
	
	private int id;
	private Item baby_trigger_item;
	private ChainLink chain;

}
