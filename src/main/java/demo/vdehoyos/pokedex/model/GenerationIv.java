package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationIv implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("diamond-pearl") 
    private GenericColor diamondPearl;
	
    @JsonProperty("heartgold-soulsilver") 
    private GenericColor heartgoldSoulsilver;
    
    @JsonProperty("platinum") 
    private GenericColor platinum;

}
