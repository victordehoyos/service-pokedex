package demo.vdehoyos.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VersionGroupFlavorText {
	
	@JsonProperty("text")
	private String text;
}