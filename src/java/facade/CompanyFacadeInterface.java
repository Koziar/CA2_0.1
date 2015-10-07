
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

    public Company getCompanyByCVR(String cvr);

    public Company getCompanyByPhone(String phone);

    public Company deleteCompany(long id);

    public Company editCompany(Company c);

    public List<Company> getCompanyWithEmpMoreThan(int num);

}
