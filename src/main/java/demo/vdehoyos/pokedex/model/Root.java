package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
	
	private String previous;
	private ArrayList<Pokemon> pokemons;
	private int count;
	private String next;

	@JsonProperty("count")
	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@JsonProperty("next")
	public String getNext() {
		return this.next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	@JsonProperty("previous")
	public String getPrevious() {
		return this.previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	@JsonProperty("results")
	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(ArrayList<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

}
