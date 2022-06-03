package com.zensar.Admissions.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.Admissions.model.Disease;
import com.zensar.Admissions.model.Employee;
import com.zensar.Admissions.model.Patients;

@RestController
@RequestMapping("/admissions")
public class PatientResources {
	
@Autowired
	
	private RestTemplate restTemplate;
	
	List<Patients> patients = Arrays.asList(				
		new Patients("p1", "Ram", 23),
		new Patients("p2", "Siva",22),
		new Patients("p3", "Kalai", 37)
		);
	
	@RequestMapping("/patients")
	public List<Patients> getPatients() {
		return patients;
	}
	
	@RequestMapping("/patients/{Id}")
	public Patients getPatientById(@PathVariable("pId") String pId) {
		Patients pat = patients.stream()
				.filter(patient -> pId.equals(patient.getId()))
				.findAny()
				.orElse(null);
		return pat;
	}
	
	
	
	@RequestMapping("/physicians")
	public Employee getRole() {
		Employee role = 
				restTemplate.getForObject("http://Hospital-HRResource/hr/employees", Employee.class);
		return role;
	}
	
	@RequestMapping("/diseases")
	public Disease getDiseases() {
		Disease diseases = 
				restTemplate.getForObject("http://Hospital-PathologyService/pathology/diseases", Disease.class);
				return diseases;
	}

}
