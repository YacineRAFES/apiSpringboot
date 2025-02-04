package fr.afpa.pompey.helloworldapi.repository;

import fr.afpa.pompey.helloworldapi.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRespository extends CrudRepository<Person, Integer> {

}
