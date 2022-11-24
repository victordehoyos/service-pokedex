package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GameIndex implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("game_index") 
    private int game_index;
    
	@JsonProperty("version") 
    private GenericNameUrl version;

}
