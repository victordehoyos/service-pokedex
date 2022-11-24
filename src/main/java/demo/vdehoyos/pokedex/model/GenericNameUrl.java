package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GenericNameUrl implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("name") 
    private String name;
    @JsonProperty("url") 
    private String url;

}
