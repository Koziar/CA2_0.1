
package facade;

import entity.Person;
import entity.Hobby;
import entity.CityInfo;
import entity.InfoEntity;
import java.util.List;

/**
 *
 * @author wookash
 */
public interface PersonFacadeInterface
{

    public Person addPerson(Person p);

    public Person getPerson(String phone);

    public Person deletePerson(long id);

    public Person editPerson(InfoEntity ie);

    public List<Person> getPersonsWithHobby(Hobby hobby);

    public List<Person> getPersonsWithCity(CityInfo city);

    public Integer CountOfPeopleWithHobby(Hobby hobby);

}
