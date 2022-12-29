package vl.klepikov.spring.boot.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import vl.klepikov.spring.boot.ex.dao.PersonDAOImpl;
import vl.klepikov.spring.boot.ex.model.Person;

import java.util.List;

@Component
public class Service {
    private PersonDAOImpl personDAO;

    @Autowired
    public Service(PersonDAOImpl personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        return personDAO.index();
    }

    @Transactional()
    public Person show(int id) {
        return personDAO.show(id);
    }

    @Transactional
    public void save(Person person) {
        personDAO.save(person);
    }

    @Transactional
    public void update(Person updatedPerson) {
        personDAO.update(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personDAO.delete(id);
    }
}
