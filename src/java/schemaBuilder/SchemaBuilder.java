/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schemaBuilder;

import entity.Address;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cookie
 */
public class SchemaBuilder {

    Random random = new Random();

    public static void main(String[] args) {

        Persistence.generateSchema("ca_devPU", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ca_devPU");
        EntityManager em = emf.createEntityManager();
        SchemaBuilder sm = new SchemaBuilder();
        sm.getRandomFName();
        try {
            List<Person> personList = new ArrayList();
            for (int i = 0; i < 25; i++) {
                Person p = new Person(sm.getRandomFName(), sm.getRandomLName(), sm.email());
//                System.out.println(p);
                personList.add(p);

            }
            em.getTransaction().begin();
            for (int i = 0; i < 25; i++) {
                em.persist(personList.get(i));
//                System.out.println(personList.get(i));
            }
            Address address1 = new Address("Street One", "");
            Address address2 = new Address("Street Two", "over the garage");

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public String getRandomFName() {
        ArrayList<String> firstName = new ArrayList();
        firstName.add("Georgina");
        firstName.add("Lukaszzzzz");
        firstName.add("Alex");
        firstName.add("john");
        firstName.add("Sanne");
        firstName.add("Adolph");
        firstName.add("Betty");
        firstName.add("Bob");
        firstName.add("Greta");
        firstName.add("James");
        firstName.add("Helga");
        firstName.add("Findus");
        firstName.add("Dana");
        firstName.add("Fox");
        firstName.add("Cookie");
        firstName.add("Doctor");
        firstName.add("Lynda");
        firstName.add("Neil");
        firstName.add("Juno");
        firstName.add("Trip");
        firstName.add("Ulla");
        firstName.add("Werther");
        firstName.add("Scarlett");
        firstName.add("Rhett");
        firstName.add("Vera");

        int index = random.nextInt(firstName.size());

        return firstName.get(index);
    }

    public String getRandomLName() {
        ArrayList<String> lastName = new ArrayList();
        lastName.add("Bond");
        lastName.add("Hitler");
        lastName.add("Stewart");
        lastName.add("Who");
        lastName.add("Sørensen");
        lastName.add("Garbo");
        lastName.add("Armstrong");
        lastName.add("O'Neil");
        lastName.add("Mulder");
        lastName.add("Scully");
        int index = random.nextInt(lastName.size());

        return lastName.get(index);

    }

    public String email() {
        ArrayList<String> email = new ArrayList();
        email.add("1@email.com");
        email.add("2@email.com");
        email.add("3@email.com");
        email.add("4@email.com");
        email.add("5@email.com");
        email.add("6@email.com");
        email.add("7@email.com");
        email.add("8@email.com");
        email.add("9@email.com");
        email.add("10@email.com");
        int index = random.nextInt(email.size());
        return email.get(index);

    }

}
