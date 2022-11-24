package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationVi implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("omegaruby-alphasapphire") 
    private GenericColor omegarubyAlphasapphire;
    @JsonProperty("x-y") 
    private GenericColor xY;

}
