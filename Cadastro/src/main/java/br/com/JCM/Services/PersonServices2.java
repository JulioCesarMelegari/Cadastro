package br.com.JCM.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.JCM.Model.Person;
import br.com.JCM.exception.ResourceNotFoundException;
import br.com.JCM.repository.PersonRepository;

@Service
public class PersonServices2 {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		return repository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Nao encontramos nenhum registro para este ID"));
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId()).
				orElseThrow(()-> new ResourceNotFoundException("Nao encontramos nenhum registro para este ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
		}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Nao encontramos nenhum registro para este ID"));
		repository.delete(entity);
	}
}






