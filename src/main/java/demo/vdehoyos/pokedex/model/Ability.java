package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Ability implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("ability") 
	private GenericNameUrl abilityDetail;
    
    @JsonProperty("is_hidden") 
    private boolean is_hidden;
    
    @JsonProperty("slot") 
    private int slot;

}
