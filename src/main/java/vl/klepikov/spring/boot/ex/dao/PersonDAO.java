package vl.klepikov.spring.boot.ex.dao;

import vl.klepikov.spring.boot.ex.model.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> index() ;

    public Person show(int id);

    public void save(Person person);

    public void update(Person updatedPerson);

    public void delete(int id) ;
}
