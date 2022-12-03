package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NamedAPIResourceList {
	
	@JsonProperty("count")
	private int count;
	@JsonProperty("next")
	private String next;
	@JsonProperty("previous")
	private boolean previous;
	@JsonProperty("results")
	private ArrayList<NamedAPIResource> results;

}