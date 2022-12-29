package vl.klepikov.spring.boot.ex.service;

import vl.klepikov.spring.boot.ex.model.Person;
import java.util.List;

public interface PersonService {

    List<Person> index();

    Person show(int id);

    void save(Person person);

    void update(Person updatedPerson);

    void delete(int id);
}
