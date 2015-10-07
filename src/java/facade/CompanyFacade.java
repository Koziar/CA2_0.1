
package facade;

import entity.Company;
import entity.CityInfo;
import java.util.List;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author wookash
 */
public class CompanyFacade implements CompanyFacadeInterface
{

    private EntityManagerFactory emf;

    public CompanyFacade(EntityManagerFactory e)
    {
        emf = e;
    }

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    @Override
    public List<CityInfo> getListOfZipCodes()
    {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT ci.zipCode FROM CityInfo ci").getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Company addCompany(Company c)
    {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    @Override
    public Company getCompanyByCVR(String cvr)
    {
        EntityManager em = getEntityManager();
        try {
            return (Company) em.createQuery("SELECT c FROM Company c WHERE c.cvr = :cvr")
                    .setParameter("cvr", cvr)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Company getCompanyByPhone(String phone)
    {
//        EntityManager em = getEntityManager();
//        try {
//            return (Company) em.createQuery("SELECT c FROM Company c WHERE  ")
//                    .setParameter("cPhone",)
//        } finally {
//            em.close();
//        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Company deleteCompany(long id)
    {
        EntityManager em = getEntityManager();
        Company c = em.find(Company.class, id);
        if (c == null) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }

    }

    @Override
    public Company editCompany(Company c)
    {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.refresh(c);
            em.getTransaction().commit();
            return em.find(Company.class, c.getId());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getCompanyWithEmpMoreThan(int num)
    {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Company c WHERE c.numEmployees > :NumOfEmpl")
                    .setParameter("NumOfEmpl", num)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
