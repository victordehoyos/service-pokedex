package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Sprites implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("back_default") 
    private String backDefault;
    
    @JsonProperty("back_female") 
    private Object backFemale;
    
    @JsonProperty("back_shiny") 
    private String backShiny;
    
    @JsonProperty("back_shiny_female") 
    private Object backShinyFemale;
    
    @JsonProperty("front_default") 
    private String frontDefault;
    
    @JsonProperty("front_female") 
    private Object frontFemale;
    
    @JsonProperty("front_shiny") 
    private String frontShiny;
    
    @JsonProperty("front_shiny_female") 
    private Object frontShinyFemale;
    
    @JsonProperty("other") 
    private Other other;
    
    @JsonProperty("versions") 
    private Versions versions;

}
