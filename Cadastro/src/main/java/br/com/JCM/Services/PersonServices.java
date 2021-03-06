package br.com.JCM.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.JCM.Model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Julio Cesar");
		person.setLastName("Melegari");
		person.setAddress("Av. José Alves Nendo, 1256");
		person.setGender("masculino");
		return person;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0; i <8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
		
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Primeiro Nome" + i);
		person.setLastName("Sobrenome" +i);
		person.setAddress("Maringa- Paraná" + i);
		person.setGender("masculino");
		return person;
	}
	
}






