package demo.vdehoyos.pokedex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VersionGroupDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("level_learned_at") 
    private int levelLearnedAt;
    
	@JsonProperty("move_learn_method") 
    private GenericNameUrl moveLearnMethod;
    
	@JsonProperty("version_group") 
    private GenericNameUrl versionGroup;

}
