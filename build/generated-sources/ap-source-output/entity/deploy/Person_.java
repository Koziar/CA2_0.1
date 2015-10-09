package entity.deploy;

import entity.Hobby;
import entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-09T22:03:56")
@StaticMetamodel(Person.class)
public class Person_ extends InfoEntity_ {

    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile ListAttribute<Person, Hobby> hobbies;
    public static volatile SingularAttribute<Person, String> firstName;

}