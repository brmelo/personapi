package br.com.projeto.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.personapi.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
