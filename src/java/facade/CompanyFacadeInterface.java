
package facade;

import entity.Company;
import entity.CityInfo;
import java.util.List;

/**
 *
 * @author wookash
 */
public interface CompanyFacadeInterface
{

    public List<CityInfo> getListOfZipCodes();

    public Company addCompany(Company c);
    
    public List<Company> getCompanies();
    
    public Company getCompanyById(long id);

    public List<Company> getCompaniesByCVR(String cvr);

    public List<Company> getCompaniesByPhone(String phone);

    public Company deleteCompany(long id);

    public Company editCompany(Company c);

    public List<Company> getCompanyWithEmpMoreThan(int num);

}
