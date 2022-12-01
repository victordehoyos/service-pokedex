package demo.vdehoyos.pokedex.model;

import java.util.ArrayList;

import com.github.oscar0812.pokeapi.models.evolution.EvolutionChain;
import com.github.oscar0812.pokeapi.models.items.ItemAttribute;
import com.github.oscar0812.pokeapi.models.items.ItemCategory;
import com.github.oscar0812.pokeapi.models.items.ItemFlingEffect;
import com.github.oscar0812.pokeapi.models.items.ItemHolderPokemon;
import com.github.oscar0812.pokeapi.models.items.ItemSprites;
import com.github.oscar0812.pokeapi.models.utility.GenerationGameIndex;
import com.github.oscar0812.pokeapi.models.utility.MachineVersionDetail;
import com.github.oscar0812.pokeapi.models.utility.Name;
import com.github.oscar0812.pokeapi.models.utility.VerboseEffect;
import com.github.oscar0812.pokeapi.models.utility.VersionGroupFlavorText;

import lombok.Getter;
import lombok.Setter;

public class Item extends NamedAPIResource {
	
	@Getter @Setter
	private int id;
	@Getter @Setter
	private int cost;
	@Getter @Setter
	private int fling_power;
	@Getter @Setter
	private ItemFlingEffect fling_effect;
	@Getter @Setter
	private ArrayList<ItemAttribute> attributes;
	@Getter @Setter
	private ItemCategory category;
	@Getter @Setter
	private ArrayList<VerboseEffect> effect_entries;
	@Getter @Setter
	private ArrayList<VersionGroupFlavorText> flavor_text_entries;
	@Getter @Setter
	private ArrayList<GenerationGameIndex> game_indices;
	@Getter @Setter
	private ArrayList<Name> names;
	@Getter @Setter
	private ItemSprites sprites;
	@Getter @Setter
	private ArrayList<ItemHolderPokemon> held_by_pokemon;
	@Getter @Setter
	private EvolutionChain baby_trigger_for;
	@Getter @Setter
	private ArrayList<MachineVersionDetail> machines;

}
