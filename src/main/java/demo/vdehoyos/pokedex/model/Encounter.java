package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Encounter {
	
	@JsonProperty("min_level")
	private int minLevel;

	@JsonProperty("max_level")
	private int maxLevel;
	
	@JsonProperty("chance")
	private int chance;

}