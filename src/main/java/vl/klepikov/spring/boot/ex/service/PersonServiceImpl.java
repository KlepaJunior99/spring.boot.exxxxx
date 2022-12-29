package vl.klepikov.spring.boot.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import vl.klepikov.spring.boot.ex.dao.PersonDAO;
import vl.klepikov.spring.boot.ex.model.Person;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> index() {
        return personDAO.index();
    }

    @Transactional()
    @Override
    public Person show(int id) {
        return personDAO.show(id);
    }

    @Transactional
    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Transactional
    @Override
    public void update(Person updatedPerson) {
        personDAO.update(updatedPerson);
    }

    @Transactional
    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }
}
