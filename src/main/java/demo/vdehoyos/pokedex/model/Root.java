package demo.vdehoyos.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Root implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("previous")
	private String previous;
	
	@JsonProperty("results")
	private ArrayList<Pokemon> pokemons;
	
	@JsonProperty("count")
	private int count;
	
	@JsonProperty("next")
	private String next;

}
