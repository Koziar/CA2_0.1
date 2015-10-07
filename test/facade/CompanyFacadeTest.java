package facade;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author terziev
 */
public class CompanyFacadeTest {

    private CompanyFacade facade;
    private final String puName = "ca_devPU";
    private long idForFacebook = -1;

    public CompanyFacadeTest() {

        facade = new CompanyFacade(Persistence.createEntityManagerFactory(puName, null));
    }

    @Before
    public void setUp() {

        EntityManager em = facade.getEntityManager();
        try {
            
            em.getTransaction().begin();
            em.createQuery("delete from Phone").executeUpdate();
            em.createQuery("delete from Hobby").executeUpdate();
            em.createQuery("delete from InfoEntity").executeUpdate();
            em.createQuery("delete from Address").executeUpdate();
            em.createQuery("delete from CityInfo").executeUpdate();
            //em.createQuery("delete from hobby_infoentity").executeUpdate();

            //add company 1
            Company c = new Company("Microsoft", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com");
            Phone p = new Phone("0101010101", "just some description");
            Address a = new Address("Norgaardsvej 30", "whatever");
            CityInfo ci = new CityInfo(2100, "Kobenhavn V");

            a.addCityInfo(ci);
            c.addPhone(p);
            c.addAddress(a);
            //em.persist(ci);
            //em.persist(a);
            em.persist(c);

            //add company 2
            Company c1 = new Company("Google", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com");
            Phone p1 = new Phone("0101010101", "just some description");
            Address a1 = new Address("Norgaardsvej 31", "whatever");
            CityInfo ci1 = new CityInfo(2300, "Kobenhavn H");
            a1.addCityInfo(ci1);
            c1.addPhone(p1);
            c1.addAddress(a1);
            //em.persist(ci1);
            em.persist(c1);

            //add company 3
            Company c2 = new Company("Facebook", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com");
            Phone p2 = new Phone("0101010101", "just some description");
            Address a2 = new Address("Norgaardsvej 32", "whatever");
            CityInfo ci2 = new CityInfo(2800, "Lyngby");
            a2.addCityInfo(ci2);
            c2.addPhone(p2);
            c2.addAddress(a2);
            //em.persist(ci2);
            em.persist(c2);
            
            //add persons
            Person person1 = new Person("Aleksandar", "Terziev", "yyyyyyyy@gmail.com");
            Person person2 = new Person("Lukasz", "Koziarski", "llllllll@gmail.com");
            Person person3 = new Person("Georgina", "Thomasen", "gggggggggg@gmail.com");
            
            Phone p3 = new Phone("0101010101", "just some description");
            Address a3 = new Address("Norgaardsvej 32", "whatever");
            CityInfo ci3 = new CityInfo(2800, "Lyngby");
            a3.addCityInfo(ci3);
            Hobby hobby = new Hobby("Snowboarding", "whatever description");
            
            person1.addPhone(p3);
            person1.addAddress(a3);
            person1.addHobby(hobby);
            
            person2.addPhone(p3);
            person2.addAddress(a3);
            person2.addHobby(hobby);
            
            person3.addPhone(p3);
            person3.addAddress(a3);
            person3.addHobby(hobby);
            
            em.persist(person1);
            em.persist(person2);
            em.persist(person3);
            
            em.getTransaction().commit();
            idForFacebook = c.getId();
        } finally {
            em.close();
        }
    }

    @Test
    public void addCompanyTest() {

        Company c2 = new Company("Lenovo", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com");
        Phone p2 = new Phone("0101010101", "just some description");
        Address a2 = new Address("Norgaardsvej 32", "whatever");
        CityInfo ci2 = new CityInfo(2800, "Lyngby");
        a2.addCityInfo(ci2);
        c2.addAddress(a2);
        c2.addPhone(p2);
        
        Company newCompany = facade.addCompany(c2);
        assertEquals("Lenovo", newCompany.getName());
        newCompany = facade.getCompanyByID(newCompany.getId());
        assertEquals("Lenovo", newCompany.getName());
    }

    @Test
    public void getCompanyByPhoneTest() {

        Company c2 = new Company("Lenovo", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com");
        Phone p2 = new Phone("0101010101", "just some description");
        Address a2 = new Address("Norgaardsvej 32", "whatever");
        CityInfo ci2 = new CityInfo(2800, "Lyngby");
        a2.addCityInfo(ci2);
        c2.addAddress(a2);
        c2.addPhone(p2);
        
        Company newCompany = facade.addCompany(c2);
        assertEquals("Lenovo", newCompany.getName());

        List<Company> companies = facade.getCompanyByPhone("01202032");
        System.out.println("------------------------------------");
        for (Company company : companies) {
            System.out.println(company.toString());
        }
        System.out.println("----------------------------------------");
    }

}
