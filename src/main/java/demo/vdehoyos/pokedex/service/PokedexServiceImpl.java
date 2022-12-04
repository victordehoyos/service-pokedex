package demo.vdehoyos.pokedex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import demo.vdehoyos.pokedex.model.ChainLink;
import demo.vdehoyos.pokedex.model.EvolutionChain;
import demo.vdehoyos.pokedex.model.Pokemon;
import demo.vdehoyos.pokedex.model.PokemonDetail;
import demo.vdehoyos.pokedex.model.PokemonDetailResponse;
import demo.vdehoyos.pokedex.model.PokemonResponse;
import demo.vdehoyos.pokedex.model.PokemonSpecies;
import demo.vdehoyos.pokedex.model.Response;
import demo.vdehoyos.pokedex.model.Root;
import lombok.EqualsAndHashCode;
import reactor.core.publisher.Mono;

@Service
@EqualsAndHashCode
public class PokedexServiceImpl implements PokedexService {

	public static WebClient webClient;
	private ArrayList<PokemonResponse> evolutions;

	private static final Logger logger = LogManager.getLogger(PokedexServiceImpl.class);

	@Autowired
	public PokedexServiceImpl(WebClient webClient) {
		PokedexServiceImpl.webClient = webClient;
	}

	@Override
	@Cacheable("response")
	public Response getAllPokemon(Long limit, Long offset) {
		logger.debug("Ejecutando método getAllPokemon(Long limit, Long offset)");
		try {
			Root rootClass = webClient.get()
					.uri(uriBuilder -> uriBuilder.path("/pokemon/").queryParam("limit", limit)
							.queryParam("offset", offset).build())
					.retrieve().bodyToFlux(Root.class)
					.doOnError(throwable -> logger.error("Error al consultar", throwable)).blockLast();

			if (!Objects.isNull(rootClass) && !CollectionUtils.isEmpty(rootClass.getPokemons())) {
				Response response = new Response();

				response.setCode("M001");
				response.setMessage("Servicio consultado correctamente");

				response.setRowCount(rootClass.getCount());

				rootClass.getPokemons().stream().flatMap(poke -> Stream.of(poke)).forEach((Pokemon poke) -> {
					PokemonDetail det = findOne(poke.getName());

					response.getPokemons().add(convertToResponse(det));
				});

				return response;
			} else {
				return new Response("No se encontraron registros que mostrar", "M002", 0, new ArrayList<>());
			}

		} catch (Exception e) {
			logger.error("Ha ocurrido un error al consultar. Detalle: " + e.getMessage());
			return new Response("Ocurrió un error al procesar la transacción", "E002", 0, new ArrayList<>());
		}
	}

	private PokemonResponse convertToResponse(PokemonDetail det) {
		PokemonResponse pokemonResponse = new PokemonResponse();
		pokemonResponse.setId(Long.valueOf(det.getId()));
		pokemonResponse.setWeight(Double.valueOf(det.getWeight()) / 10);
		pokemonResponse.setHeight(Double.valueOf(det.getHeight()) / 10);
		pokemonResponse.setName(det.getName());
		pokemonResponse.setUrlImg(det.getSprites().getOther().getOfficialArtwork().getFrontDefault());

		List<String> abilities = det.getAbilities().stream().map(a -> a.getAbilityDetail().getName())
				.collect(Collectors.toList());

		pokemonResponse.setAbilities(abilities);

		List<String> types = det.getTypes().stream().map(t -> t.getType().getName()).collect(Collectors.toList());

		pokemonResponse.setTypes(types);

		pokemonResponse.setDescription("");

		return pokemonResponse;
	}

	@Override
	public PokemonDetail findOne(Integer id) {
		return findOnePokemon(id);
	}

	@Override
	@Cacheable("pokemonDetailResponse")
	public PokemonDetailResponse getPokemonDetail(String name) {
		logger.debug("Ejecutando método getPokemonDetail(String name)");
		PokemonDetailResponse responseDetail = new PokemonDetailResponse();

		try {

			PokemonDetail pd = findOne(name);

			if (pd != null) {
				responseDetail.setCode("M001");
				responseDetail.setMessage("Servicio ejecutado correctamente");

				PokemonResponse response = null;
				response = convertToResponse(pd);

				PokemonSpecies sp = (PokemonSpecies) PokedexServiceImpl.getObjectByURL(pd.getSpecies().getUrl(),
						PokemonSpecies.class);
 
				EvolutionChain chain = (EvolutionChain) PokedexServiceImpl
						.getObjectByURL(sp.getEvolutionChain().getUrl(), EvolutionChain.class);

				evolutions = new ArrayList<PokemonResponse>();

				getEvo(chain.getChain());

				response.setEvolutions(evolutions);

				responseDetail.setResponse(response);

				return responseDetail;
			}

			responseDetail.setCode("M002");
			responseDetail.setMessage("No se encontró la información solicitada");
		} catch (WebClientResponseException e) {
			logger.error("Error ocurrido con el componente WebClient - Detalle: " + e.getMessage());
			responseDetail.setCode(String.valueOf(e.getRawStatusCode()));
			responseDetail.setMessage("No se encontró la información solicitada");
			responseDetail.setResponse(null);
		} catch (Exception e) {
			logger.debug("Error al realizar la consulta - Detalle: " + e.getMessage());
			responseDetail.setCode("E001");
			responseDetail.setMessage("Se presentó un error al realizar la consulta. Detalle: " + e.getMessage());
			responseDetail.setResponse(null);
		}

		return responseDetail;
	}
	
	public PokemonDetail findOnePokemon(Object name) {

		Mono<PokemonDetail> pDetail = webClient.get().uri("/pokemon/{name}", name).retrieve()
				.bodyToMono(PokemonDetail.class).doOnError(throwable -> logger.error("Error al consultar", throwable));

		return pDetail.block();
	}

	public Object getByURL(String url, Class<?> clazz) {
		Mono<?> obj = webClient.get().uri(url).retrieve().bodyToMono(clazz)
				.doOnError(throwable -> logger.error("Error al consultar", throwable));

		return obj.block();
	}

	public static Object getObjectByURL(String url, Class<?> clazz) {
		Mono<?> obj = PokedexServiceImpl.webClient.get().uri(url).retrieve().bodyToMono(clazz)
				.doOnError(throwable -> logger.error("Error al consultar", throwable));

		return obj.block();
	}

	@Override
	@Cacheable("response2")
	public Response getAllPokemon() {
		return getAllPokemon(null, null);
	}

	@Override
	@Cacheable("pokemonDetail")
	public PokemonDetail findOne(String name) {
		return findOnePokemon(name);
	}

	public void getEvo(ChainLink c) {
		if (c.getEvolvesTo().size() > 0) {
			evolutions.add(convertToResponse(findOne(c.getSpecies().getName())));
			getEvo(c.getEvolvesTo().get(0));
		} else {
			evolutions.add(convertToResponse(findOne(c.getSpecies().getName())));
		}
	}
}
