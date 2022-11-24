package demo.vdehoyos.pokedex.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Move implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("move") 
    private GenericNameUrl move;
    @JsonProperty("version_group_details") 
    private ArrayList<VersionGroupDetail> versionGroupDetails;

}
