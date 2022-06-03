package com.zensar.pathology.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.zensar.pathology.exception.DiseaseNotFoundException;
import com.zensar.pathology.model.Disease;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	private List<Disease> diseases = Arrays.asList(
		new Disease("d1", "feaver", "paracetamol"),
		new Disease("d2", "Headache", "Panadol capsule"),
		new Disease("d3", "Caugh", "benadril syrup")
	);
	
	@RequestMapping("/diseases")
	public Disease getDiseases() {
		Disease diseasesList = new Disease();
		diseasesList.setDiseases(diseases);
		return diseasesList;
	}
	
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) throws DiseaseNotFoundException{
		
		Disease dis = diseases.stream()
			.filter(disease -> Id.equals(disease.getId()))
			.findAny()
			.orElse(null);	
		
		return dis;
	}	
}
