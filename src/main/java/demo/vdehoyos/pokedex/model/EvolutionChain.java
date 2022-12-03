package demo.vdehoyos.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EvolutionChain extends APIResource {

	@JsonProperty("id")
	private int id;

	@JsonProperty("baby_trigger_item")
	private Item baby_trigger_item;

	@JsonProperty("chain")
	private ChainLink chain;

}