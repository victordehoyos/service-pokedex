package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Other implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("dream_world") 
    private GenericColor dreamWorld;
    
	@JsonProperty("home") 
    private GenericColor home;
    
	@JsonProperty("official-artwork") 
    private GenericColor officialArtwork;

}
