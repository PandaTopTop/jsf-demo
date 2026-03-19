package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Person;

import java.util.Optional;

@ApplicationScoped
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public Optional<Person> getPersonById(Integer id){
        TypedQuery<Person> query= em.createQuery("SELECT p FROM Person p WHERE p.id = :personId", Person.class);

        query.setParameter("personId",id);

        return query.getResultStream().findFirst();
    }
}
