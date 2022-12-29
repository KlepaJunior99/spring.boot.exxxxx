package vl.klepikov.spring.boot.ex.service;

import vl.klepikov.spring.boot.ex.model.Person;

import java.util.List;

public interface Service {

    public List<Person> index();

    public Person show(int id);

    public void save(Person person);

    public void update(Person updatedPerson);

    public void delete(int id);
}
