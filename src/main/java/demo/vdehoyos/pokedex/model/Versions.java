package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Versions implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("generation-i") 
    private GenerationI generationI;
    
	@JsonProperty("generation-ii") 
    private GenerationIi generationIi;
    
	@JsonProperty("generation-iii") 
    private GenerationIii generationIii;
    
	@JsonProperty("generation-iv") 
    private GenerationIv generationIv;
    
	@JsonProperty("generation-v") 
    private GenerationV generationV;
    
	@JsonProperty("generation-vi") 
    private GenerationVi generationVi;
    
	@JsonProperty("generation-vii") 
    private GenerationVii generationVii;
    
	@JsonProperty("generation-viii") 
    private GenerationViii generationViii;

}
