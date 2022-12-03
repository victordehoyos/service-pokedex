package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ChainLink {
	
	@JsonProperty("is_baby") 
	private boolean isBaby;

	@JsonProperty("species") 
	private PokemonSpecies species;

	@JsonProperty("evolution_details")
	private ArrayList<EvolutionDetail> evolutionDetails;

	@JsonProperty("evolves_to")
	private ArrayList<ChainLink> evolvesTo;

}