package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Stat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("base_stat") 
    private int baseStat;
    
	@JsonProperty("effort") 
    private int effort;
    
	@JsonProperty("stat") 
    private GenericNameUrl stat;

}
