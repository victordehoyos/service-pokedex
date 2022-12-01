package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Response extends ResponseAPI {
	
	@Getter @Setter
	private Integer rowCount;
	@Setter
	private List<PokemonResponse> pokemons;
	
	public List<PokemonResponse> getPokemons() {
		if (CollectionUtils.isEmpty(pokemons)) {
			pokemons = new ArrayList<>();
		}
		return pokemons;
	}
	
	public Response(String message, String code, Integer rowCount, List<PokemonResponse> pokemons) {
		super.setCode(code);
		super.setMessage(message);
		this.setRowCount(rowCount);
		this.setPokemons(pokemons);
	}
	
}
