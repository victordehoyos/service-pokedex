package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationV implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("black-white") 
    private GenericColor blackWhite;

}
