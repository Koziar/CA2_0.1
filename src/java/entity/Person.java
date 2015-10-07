package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("Person")
public class Person extends InfoEntity {
    //private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "persons", cascade={CascadeType.PERSIST})
    private List<Hobby> hobbies = new ArrayList();

    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Hobby addHobby(Hobby newHobby) {
        
        hobbies.add(newHobby);
        newHobby.addPerson(this);
        return newHobby;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}
