package demo.vdehoyos.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Effect {
	
	@JsonProperty("effect")
	private String effect;
}