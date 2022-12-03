package demo.vdehoyos.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResource {
	
	@JsonProperty("url") 
	private String url;
	@JsonProperty("is_fetched") 
	private boolean isFetched;
}