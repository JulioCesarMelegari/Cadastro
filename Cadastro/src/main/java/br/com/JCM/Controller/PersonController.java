package br.com.JCM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.JCM.Model.Person;
import br.com.JCM.Services.PersonServices2;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	//para ambiente de teste chamar PersonServices
	@Autowired
	private PersonServices2 services;
	
	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return services.findAll();
	}
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") Long id) { //para teste String id
		return services.findById(id); 
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return services.create(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return services.update(person);
	}
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE) 
	public void delete(@PathVariable("id") Long id) { //para teste String id
			services.delete(id);
	}

}
