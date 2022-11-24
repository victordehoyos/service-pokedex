package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenericColor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("back_default") 
    private String backDefault;
	
    @JsonProperty("back_gray") 
    private String backGray;
    
    @JsonProperty("back_transparent") 
    private String backTransparent;
    
    @JsonProperty("front_default") 
    private String frontDefault;
    
    @JsonProperty("front_gray") 
    private String frontGray;
    
    @JsonProperty("front_transparent") 
    private String frontTransparent;

}
