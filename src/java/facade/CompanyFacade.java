package facade;

import entity.Company;
import entity.CityInfo;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author wookash
 */
public class CompanyFacade implements CompanyFacadeInterface {

    private EntityManagerFactory emf;

    public CompanyFacade(EntityManagerFactory e) {
        emf = e;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<CityInfo> getListOfZipCodes() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT ci.zipCode FROM CityInfo ci").getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Company addCompany(Company c) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return em.find(Company.class, c.getId());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getCompaniesByCVR(String cvr) {
        EntityManager em = getEntityManager();
        List<Company> companiesWithCvr = new ArrayList();
        try {
            List<Company> companies = em.createQuery("SELECT i FROM InfoEntity i WHERE TYPE(i) = :entityType")
                    .setParameter("entityType", Company.class)
                    .getResultList();
            
            for (Company c : companies) {
                if(c.getCvr().equals(cvr)){
                    
                    companiesWithCvr.add(c);
                }
            }  
        } finally {
            em.close();
        }
        return companiesWithCvr;
    }

    @Override
    public List<Company> getCompaniesByPhone(String phone) {
        EntityManager em = getEntityManager();
        List<Company> companiesWithPhone = new ArrayList();
        try {
            List<Company> companies = em.createQuery("SELECT i FROM InfoEntity i WHERE TYPE(i) = :entityType")
                    .setParameter("entityType", Company.class)
                    .getResultList();
            
            for (Company c : companies) {
                for (Phone p: c.getPhones()) {
                    if(p.getNumber().equals(phone)){
                        companiesWithPhone.add(c);
                    }
                }
            }  
        } finally {
            em.close();
        }
        return companiesWithPhone;

    }

    @Override
    public Company deleteCompany(long id) {
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
    public Company editCompany(Company c) {
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
    public List<Company> getCompanyWithEmpMoreThan(int num) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Company c WHERE c.numEmployees > :NumOfEmpl")
                    .setParameter("NumOfEmpl", num)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getCompanies() {

        EntityManager em = getEntityManager();
        try {
            List<Company> companies = em.createQuery("SELECT i FROM InfoEntity i WHERE TYPE(i) = :entityType")
                    .setParameter("entityType", Company.class)
                    .getResultList();
            return companies;
        } finally {
            em.close();
        }
    }

    @Override
    public Company getCompanyById(long id) {

        EntityManager em = getEntityManager();
    try {
      Company c = em.find(Company.class,id);
       if(c == null){
        //throw new PersonNotFoundException("No Person found with provided id");
      }
       return c;
    } finally {
      em.close();
    }
        
    }

}
