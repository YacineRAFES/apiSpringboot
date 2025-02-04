package fr.afpa.pompey.helloworldapi.service;

import fr.afpa.pompey.helloworldapi.model.Person;
import fr.afpa.pompey.helloworldapi.repository.PersonRespository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class PersonService {

    @Autowired
    private PersonRespository personRespository;

    public Optional<Person> getPerson(int id){
        return personRespository.findById(id);
    }

    public Iterable<Person> getPersons(){
        return personRespository.findAll();
    }

    public void deletePerson(int id){
        personRespository.deleteById(id);
    }

    public Person savePerson(Person person){
        Person savedPerson = personRespository.save(person);
        return savedPerson;
    }
}
