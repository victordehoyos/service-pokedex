package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationVii implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("icons") 
    private GenericColor icons;
	
    @JsonProperty("ultra-sun-ultra-moon") 
    private GenericColor ultraSunUltraMoon;

}
