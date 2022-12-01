package demo.vdehoyos.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PokemonResponse implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double weight;
	private Double height;
	private String name;
	private String urlImg;
	private List<String> types;
	private List<String> abilities;
	private String description;
	private ArrayList<PokemonResponse> evolutions;
	
}
