package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenerationIi implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("crystal") 
    private GenericColor crystal;
    @JsonProperty("gold") 
    private GenericColor gold;
    @JsonProperty("silver") 
    private GenericColor silver;

}
