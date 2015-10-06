
package facade;

import entity.Person;
import entity.Hobby;
import entity.CityInfo;
import entity.InfoEntity;
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
    public Person getPerson(String phone)
    {
        EntityManager em = getEntityManager();
        try {
            Person p = em.find(Person.class, phone);
            if (p == null) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
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
            if (p == null) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public Person editPerson(InfoEntity ie)
    {
        EntityManager em = getEntityManager();
        try {
            Person editP = em.find(Person.class, ie.getId());
            if (editP == null) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        } finally {

        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> getPersonsWithHobby(Hobby hobby)
    {

        EntityManager em = getEntityManager();
        try {
            return em.createQuery("").getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getPersonsWithCity(CityInfo city)
    {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("").getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Integer CountOfPeopleWithHobby(Hobby hobby)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
