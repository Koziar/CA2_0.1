package entity;

import entity.Hobby;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-06T18:41:49")
@StaticMetamodel(Person.class)
public class Person_ extends InfoEntity_ {

    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile ListAttribute<Person, Hobby> hobbies;
    public static volatile SingularAttribute<Person, String> firstName;

}