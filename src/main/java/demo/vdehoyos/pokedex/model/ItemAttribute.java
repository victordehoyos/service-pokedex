package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ItemAttribute extends NamedAPIResource {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("items")
	private ArrayList<Item> items;
	@JsonProperty("descriptions")
	private ArrayList<Description> descriptions;

}