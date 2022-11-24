package demo.vdehoyos.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PokemonDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("abilities") 
    private ArrayList<Ability> abilities;
    
    @JsonProperty("base_experience") 
    private int base_experience;
     
    @JsonProperty("forms") 
    private ArrayList<GenericNameUrl> forms;
    
    @JsonProperty("game_indices")
    private ArrayList<GameIndex> game_indices;
    
    @JsonProperty("height") 
    private int height;
      
    @JsonProperty("id") 
    private int id;
     
    @JsonProperty("is_default") 
    private boolean is_default;
     
    @JsonProperty("location_area_encounters") 
    private String location_area_encounters;
     
    @JsonProperty("moves") 
    private ArrayList<Move> moves;
     
    @JsonProperty("name") 
    private String name;
     
    @JsonProperty("order") 
    private int order;
     
    @JsonProperty("species") 
    private GenericNameUrl species;
    
    @JsonProperty("sprites") 
    private Sprites sprites;
    
    @JsonProperty("stats") 
    ArrayList<Stat> stats;
    
    @JsonProperty("types") 
    ArrayList<Type> types;
    
    @JsonProperty("weight") 
    private int weight;
	
}
