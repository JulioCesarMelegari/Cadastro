package br.com.JCM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.JCM.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
