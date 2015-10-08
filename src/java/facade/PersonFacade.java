
package facade;

import entity.Person;
import entity.Hobby;
import entity.CityInfo;
import exception.PersonNotFoundException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

/**
 *
 * @author wookash
 */
public class PersonFacade implements PersonFacadeInterface
{

    private EntityManagerFactory emf;

    public PersonFacade(EntityManagerFactory e)
    {
        emf = e;
    }

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    @Override
    public Person addPerson(Person p)
    {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }

    }

    @Override
    public Person getPersonByPhone(String phone)
    {
        EntityManager em = getEntityManager();
        try {
            return (Person) em.createQuery("SELECT p FROM Person p JOIN p.phones h WHERE h.number = :phoneNumber")
                    .setParameter("phoneNumber", phone)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public Person getPersonByID(long id)
    {
        EntityManager em = getEntityManager();
        try {
            Person p = em.find(Person.class, id);
            
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public Person deletePerson(long id)
    {
        EntityManager em = getEntityManager();
        try {
            Person p = em.find(Person.class, id);
            

            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public Person editPerson(Person p)
    {
        EntityManager em = getEntityManager();
        try {

            
            em.getTransaction().begin();
            em.refresh(p);
            em.getTransaction().commit();
            return em.find(Person.class, p.getId());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getPersonsWithHobby(Hobby hobby)
    {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.name = :hobbyName")
                    .setParameter("hobbyName", hobby.getName())
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getPersonsWithCity(CityInfo city)
    {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Person p JOIN p.address.cityInfo c WHERE c.city = :cityName")
                    .setParameter("cityName", city.getCity())
                    .getResultList();

        } finally {
                    em.close();
        }
    }

    @Override
    public Integer CountOfPersonsWithHobby(Hobby hobby)
    {
        EntityManager em = getEntityManager();
        try {
            List<Person> list = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.name = :hobbyName")
                    .setParameter("hobbyName", hobby.getName())
                    .getResultList();

            return list.size();

        } finally {

        }
    }

    @Override
    public List<Person> getPersons()
    {
        EntityManager em = getEntityManager();
        try {
            List<Person> persons = em.createQuery("SELECT i FROM InfoEntity i WHERE TYPE(i) = :entityType")
                    .setParameter("entityType", Person.class)
                    .getResultList();
            return persons;
        } finally {
            em.close();
        }
    }

}
