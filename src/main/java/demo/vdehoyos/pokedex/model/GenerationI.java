package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationI implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("red-blue") 
    private GenericColor redBlue;
    
    @JsonProperty("yellow") 
    private GenericColor yellow;

}
