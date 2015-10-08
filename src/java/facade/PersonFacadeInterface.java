
package facade;

import entity.Person;
import entity.Hobby;
import entity.CityInfo;
import entity.InfoEntity;
import exception.PersonNotFoundException;
import java.util.List;

/**
 *
 * @author wookash
 */
public interface PersonFacadeInterface
{

    public Person addPerson(Person p);

    public Person getPersonByPhone(String phone);
    //This should provide a Person with all details
    public Person getPersonByID(long id);
    
    public List<Person> getPersons();

    public Person deletePerson(long id);

    public Person editPerson(Person p);

    public List<Person> getPersonsWithHobby(Hobby hobby);

    public List<Person> getPersonsWithCity(CityInfo city);

    public Integer CountOfPersonsWithHobby(Hobby hobby);

}
