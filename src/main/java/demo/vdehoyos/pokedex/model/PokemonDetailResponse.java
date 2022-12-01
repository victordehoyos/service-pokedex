package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class PokemonDetailResponse extends ResponseAPI implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private PokemonResponse response;
	
}
