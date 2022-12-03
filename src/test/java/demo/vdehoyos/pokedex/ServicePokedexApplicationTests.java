package demo.vdehoyos.pokedex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;

import demo.vdehoyos.pokedex.model.PokemonDetailResponse;
import demo.vdehoyos.pokedex.model.Response;
import demo.vdehoyos.pokedex.service.PokedexServiceImpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ServicePokedexApplicationTests {

	PokedexServiceImpl impl = new PokedexServiceImpl(WebClient.create("https://pokeapi.co/api/v2"));
	
	@Test
	public void getPokemonDetail_Test() {
		PokemonDetailResponse response = impl.getPokemonDetail("pikachu");
		assertThat(response).isNotNull();
		assertThat(response.getCode()).isEqualTo("M001");
		assertThat(response.getResponse()).isNotNull();
		assertThat(response.getResponse().getName()).isEqualTo("pikachu");
	}
	
	@Test
	public void getAllPokemon_Test() {
		Response response = impl.getAllPokemon(Long.valueOf(1), Long.valueOf(0));
		assertThat(response).isNotNull();
		assertThat(response.getCode()).isEqualTo("M001");
		assertThat(response.getRowCount()).isEqualTo(1154);
		assertThat(response.getPokemons()).isNotNull();
		assertThat(response.getPokemons()).hasSize(1);
		
	}
}
