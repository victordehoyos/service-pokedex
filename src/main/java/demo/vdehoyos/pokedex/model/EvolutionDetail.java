package demo.vdehoyos.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EvolutionDetail {
	
	@JsonProperty("item")
	private Item item;
	@JsonProperty("trigger")
	private EvolutionTrigger trigger;
	@JsonProperty("gender")
	private int gender;
	@JsonProperty("held_item")
	private Item heldItem;
	
}