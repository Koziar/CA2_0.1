/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author wookash
 */
public class TestOfPersonFacade
{

    PersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory("ca_devPU"));
    private long idForLukasz = 1;
    
    public TestOfPersonFacade()
    {
    }

    @Before
    public void setUp()
    {
        EntityManager em = facade.getEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM InfoEntity").executeUpdate();
            
            Person p = new Person("Lukasz", "Koziarski", "testmail@mail.com");
            em.persist(p);
            em.persist(new Person("Anna", "Boh", "123@456.com"));
            em.persist(new Person("John", "Hoh", "654@321.com"));
            em.getTransaction().commit();
            idForLukasz = p.getId();
        } finally {
            em.close();
        }
    }

    @Test
    public void testAddPerson()
    {
        Person newPerson = facade.addPerson(new Person("Tester", "Testerowski", "abc@d.com"));
        assertEquals("Tester", newPerson.getFirstName());
        newPerson = facade.getPersonByID(newPerson.getId());
        assertEquals("Tester", newPerson.getFirstName());
    }

    @Test
    public void testGetPersonByID(){
        Person p = facade.getPersonByID(idForLukasz);
        assertEquals(p.getFirstName(), "Lukasz");
    }
    
    @Test
    public void testGetPersonsWithHobby(){
        Hobby hobby = new Hobby("sport", "desc");
        Person p = facade.addPerson(new Person("a", "b", "c"));
        
        facade.getPersonsWithHobby(hobby);
    }
    
    @Test
    public void testGetPersonsWithCity(){
        CityInfo ci = new CityInfo(2800, "Lyngby");
        
        facade.getPersonsWithCity(ci);
    }
    
    @Test
    public void testCountOfPersonsWithHobby(){
     
        Hobby hobby = new Hobby("programming", "yeaaah");
        facade.CountOfPersonsWithHobby(hobby);
    }
}
