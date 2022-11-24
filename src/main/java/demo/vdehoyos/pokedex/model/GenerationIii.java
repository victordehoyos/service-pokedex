package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationIii implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("emerald") 
    private GenericColor emerald;
	
    @JsonProperty("firered-leafgreen") 
    private GenericColor fireredLeafgreen;
    
    @JsonProperty("ruby-sapphire") 
    private GenericColor rubySapphire;

}
