package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Item extends NamedAPIResource {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("cost")
	private int cost;
	@JsonProperty("fling_power")
	private int flingPower;
	@JsonProperty("attributes")
	private ArrayList<ItemAttribute> attributes;
	@JsonProperty("category")
	private ItemCategory category;
	@JsonProperty("flavor_text_entries")
	private ArrayList<VersionGroupFlavorText> flavorTextEntries;
	@JsonProperty("sprites")
	private ItemSprites sprites;
	@JsonProperty("baby_trigger_for")
	private EvolutionChain babyTriggerFor;

}