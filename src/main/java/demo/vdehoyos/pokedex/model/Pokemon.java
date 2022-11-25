package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

 
public class Pokemon extends GenericNameUrl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private PokemonDetail detail;

}
