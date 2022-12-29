package vl.klepikov.spring.boot.ex.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vl.klepikov.spring.boot.ex.model.Person;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Person> index() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Transactional()
    public Person show(int id) {
        return entityManager.find(Person.class,id);
    }

    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public void update(Person updatedPerson) {
        entityManager.merge(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}