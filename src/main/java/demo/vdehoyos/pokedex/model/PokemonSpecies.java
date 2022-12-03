package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PokemonSpecies extends NamedAPIResource {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("order")
	private int order;
	@JsonProperty("gender_rate")
	private int genderRate;
	@JsonProperty("capture_rate")
	private int captureRate;
	@JsonProperty("base_happiness")
	private int baseHappiness;
	@JsonProperty("is_baby")
	private boolean isBaby;
	@JsonProperty("hatch_counter")
	private int hatchCounter;
	@JsonProperty("has_gender_differences")
	private boolean hasGenderDifferences;
	@JsonProperty("forms_switchable")
	private boolean formsSwitchable;
	@JsonProperty("evolvesFromSpecies")	
	private PokemonSpecies evolves_from_species;

	@JsonProperty("evolution_chain")
	private EvolutionChain evolutionChain;

	@JsonProperty("form_descriptions")
	private ArrayList<Description> formDescriptions;

}
