package facade;

import entity.Company;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CompanyFacadeTest {

    private CompanyFacade facade;
    private final String puName = "ca_devPU";//change to your PU name
    private long idForFacebook = -1;

    public CompanyFacadeTest() {

        facade = new CompanyFacade(Persistence.createEntityManagerFactory(puName, null));
    }

    @Before
    public void setUpClass() {

        EntityManager em = facade.getEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from InfoEntity").executeUpdate();
            Company c = new Company("Microsoft", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com");
            em.persist(c);
            em.persist(new Company("Google", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com"));
            em.persist(new Company("Facebook", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com"));
            em.getTransaction().commit();
            idForFacebook = c.getId();
        } finally {
            em.close();
        }
    }

    @Test
    public void addCompanyTest() {

        Company newCompany = facade.addCompany(new Company("Lenovo", "whatever", "01202032", 111111, "market value whatever", "xxxx@gmail.com"));
        assertEquals("Lenovo", newCompany.getName());
        newCompany = facade.getCompanyByID(newCompany.getId());
        assertEquals("Lenovo", newCompany.getName());
    }

}
