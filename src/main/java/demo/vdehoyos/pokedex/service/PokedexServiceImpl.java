package demo.vdehoyos.pokedex.service;

import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import demo.vdehoyos.pokedex.model.Pokemon;
import demo.vdehoyos.pokedex.model.PokemonDetail;
import demo.vdehoyos.pokedex.model.Root;
import reactor.core.publisher.Mono;

@Service
public class PokedexServiceImpl implements PokedexService {

	@Autowired
	private WebClient webClient;
	
	private static final Logger logger = LogManager.getLogger(PokedexServiceImpl.class);
	
	@Override
	public Root getAllPokemon(Long limit, Long offset) {
		
		Root allPokemon = webClient
				.get()
				.uri(uriBuilder -> uriBuilder
						.path("/pokemon/")
						.queryParam("limit", limit)
						.queryParam("offset", offset).build())
				.retrieve()
				.bodyToFlux(Root.class)
				.doOnError(throwable -> logger.error("Error al consultar", throwable))
				.blockLast();
		
		
		allPokemon.getPokemons()
				  .stream()
				  .flatMap(poke -> Stream.of(poke))
				  .forEach((Pokemon poke) -> {
					  poke.setDetail(findOne(poke.getName()));
				  });
		
		
		
		
		return allPokemon;
	}

	@Override
	public PokemonDetail findOne(Integer id) {
		Mono<PokemonDetail> pDetail = webClient
				.get()
				.uri("/pokemon/{id}", id)
				.retrieve()
				.bodyToMono(PokemonDetail.class)
				.doOnError(throwable -> logger.error("Error al consultar", throwable));
		
		return pDetail.block();
	}

	@Override
	public PokemonDetail findOne(String name) {
		
		Mono<PokemonDetail> pDetail = webClient
				.get()
				.uri("/pokemon/{name}", name)
				.retrieve()
				.bodyToMono(PokemonDetail.class)
				.doOnError(throwable -> logger.error("Error al consultar", throwable));
		
		return pDetail.block();
	}

	@Override
	public Object geyByURL(String url, Class<?> clazz) {
		Mono<?> obj = webClient
				.get()
				.uri(url)
				.retrieve()
				.bodyToMono(clazz)
				.doOnError(throwable -> logger.error("Error al consultar", throwable));
		
		return obj.block();
	}

}
