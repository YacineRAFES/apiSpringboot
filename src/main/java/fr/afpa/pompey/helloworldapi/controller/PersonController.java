package fr.afpa.pompey.helloworldapi.controller;

import fr.afpa.pompey.helloworldapi.model.Person;
import fr.afpa.pompey.helloworldapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @GetMapping("/persons")
    public Iterable<Person> getAllPersons(){
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable("id") Integer id){
        Optional<Person> person = personService.getPerson(id);
        return person.orElse(null);
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable("id") Integer id, @RequestBody Person person){
        Optional<Person> personOptional = personService.getPerson(id);
        if(personOptional.isPresent()){
            Person personToUpdate = personOptional.get();

            String prenom = person.getPrenom();
            if(prenom != null){
                personToUpdate.setPrenom(prenom);
            }

            String nom = person.getNom();
            if(nom != null){
                personToUpdate.setNom(nom);
            }

            personService.savePerson(personToUpdate);
            return personToUpdate;
        }else{
            return null;
        }
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") Integer id){
        personService.deletePerson(id);
    }
}
