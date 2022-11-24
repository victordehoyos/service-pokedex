package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Type implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("slot") 
    private int slot;
    
	@JsonProperty("type") 
    private GenericNameUrl type;

}
