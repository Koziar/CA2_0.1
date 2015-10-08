
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import exception.PersonNotFoundException;
import facade.PersonFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author wookash
 */
@Path("person")
public class PersonResource
{

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    PersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory("ca_devPU"));

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public PersonResource()
    {
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("complete")
    @Produces("application/json")
    public Response getAllPersonsDetails()
    {
        List<Person> personsList = facade.getPersons();

        JsonArray personsArray = new JsonArray();

        for (Person person : personsList) {
            JsonObject json = new JsonObject();

            JsonArray jaPhones = new JsonArray();
            JsonObject joPhone = new JsonObject();
            for (Phone phone : person.getPhones()) {

                joPhone.addProperty("number", phone.getNumber());
                joPhone.addProperty("desccription", phone.getDescription());
                jaPhones.add(joPhone);
            }

            JsonArray jaHobbies = new JsonArray();
            JsonObject joHobbie = new JsonObject();
            for (Hobby hobby : person.getHobbies()) {

                joHobbie.addProperty("name", hobby.getName());
                joHobbie.addProperty("description", hobby.getDescription());
                jaHobbies.add(joHobbie);
            }

            json.addProperty("id", person.getId());
            json.addProperty("firstName", person.getFirstName());
            json.addProperty("lastName", person.getLastName());
            json.addProperty("email", person.getEmail());
            json.add("phones", jaPhones);
            json.addProperty("street", person.getAddress().getStreet());
            json.addProperty("city", person.getAddress().getCityInfo().getCity());
            json.addProperty("zipcode", person.getAddress().getCityInfo().getZipCode());
            json.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
            json.add("hobbies", jaHobbies);

            personsArray.add(json);
        }

        String jsonPersons = gson.toJson(personsArray); //perentas before personsList

        return Response.ok(jsonPersons).build();
    }

    @GET
    @Path("complete/{id}")
    @Produces("application/json")
    public Response getSpecificPersonDetails(@PathParam("id") long id) throws PersonNotFoundException
    {
        JsonObject json = new JsonObject();
        Person person = facade.getPersonByID(id);
        if (person == null) {
            throw new PersonNotFoundException("No person with that ID found");
        }
        JsonArray jaPhones = new JsonArray();
        JsonArray jaHobbies = new JsonArray();

        JsonObject joPhone = new JsonObject();
        for (Phone phone : person.getPhones()) {

            joPhone.addProperty("number", phone.getNumber());

            joPhone.addProperty("desccription", phone.getDescription());
            jaPhones.add(joPhone);
        }

        JsonObject joHobbie = new JsonObject();
        for (Hobby hobby : person.getHobbies()) {

            joHobbie.addProperty("name", hobby.getName());
            joHobbie.addProperty("description", hobby.getDescription());
            jaHobbies.add(joHobbie);
        }

        json.addProperty("id", person.getId());
        json.addProperty("firstName", person.getFirstName());
        json.addProperty("lastName", person.getLastName());
        json.addProperty("email", person.getEmail());
        json.add("phones", jaPhones);
        json.addProperty("street", person.getAddress().getStreet());
        json.addProperty("city", person.getAddress().getCityInfo().getCity());
        json.addProperty("zipcode", person.getAddress().getCityInfo().getZipCode());
        json.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
        json.add("hobbies", jaHobbies);

        return Response.ok(gson.toJson(json)).build();
    }

    @GET
    @Path("contactinfo")
    @Produces("application/json")
    public Response getcontactInfoForPersons() throws PersonNotFoundException
    {
        List<Person> personsList = facade.getPersons();
        if (personsList == null) {
            throw new PersonNotFoundException("No person with that ID found");
        } else if (personsList.isEmpty()) {
            throw new PersonNotFoundException("No person with that ID found");
        }
        JsonArray personsArray = new JsonArray();
        JsonArray jaPhones = new JsonArray();

        for (Person person : personsList) {
            JsonObject json = new JsonObject();

            JsonObject joPhone = new JsonObject();
            for (Phone phone : person.getPhones()) {

                joPhone.addProperty("number", phone.getNumber());
                joPhone.addProperty("desccription", phone.getDescription());
                jaPhones.add(joPhone);
            }

            json.addProperty("id", person.getId());
            json.addProperty("firstName", person.getFirstName());
            json.addProperty("lastName", person.getLastName());
            json.addProperty("email", person.getEmail());
            json.add("phones", jaPhones);

            personsArray.add(json);
        }
        return Response.ok(gson.toJson(personsArray)).build();

    }

    @GET
    @Path("contactinfo/{id}")
    @Produces("application/json")
    public Response getcontactInfoForSpecificPerson(@PathParam("id") long id) throws PersonNotFoundException
    {
        Person person = facade.getPersonByID(id);
        if (person == null) {
            throw new PersonNotFoundException("No person with that ID found");
        }
        JsonArray jaPhones = new JsonArray();

        JsonObject json = new JsonObject();

        JsonObject joPhone = new JsonObject();
        for (Phone phone : person.getPhones()) {

            joPhone.addProperty("number", phone.getNumber());
            joPhone.addProperty("desccription", phone.getDescription());
            jaPhones.add(joPhone);
        }

        json.addProperty("id", person.getId());
        json.addProperty("firstName", person.getFirstName());
        json.addProperty("lastName", person.getLastName());
        json.addProperty("email", person.getEmail());
        json.add("phones", jaPhones);

        return Response.ok(gson.toJson(json)).build();

    }

    @GET
    @Path("complete/hobby/{hobby}")
    @Produces("application/json")
    public Response getInfoForPersonsByHobby(@PathParam("hobby") String hobby) throws PersonNotFoundException
    {
        List<Person> personsList = facade.getPersons();
        JsonArray personsArray = new JsonArray();
        if (personsList == null) {
            throw new PersonNotFoundException("No person with that hobby found");
        } else if (personsList.isEmpty()) {
            throw new PersonNotFoundException("No person with that hobby found");
        }
        for (Person person : personsList) {
            JsonObject json = new JsonObject();
            JsonArray jaHobbies = new JsonArray();
            JsonArray jaPhones = new JsonArray();

            for (Hobby h : person.getHobbies()) {
                if (h.getName().equalsIgnoreCase(hobby)) {

                    JsonObject joPhone = new JsonObject();
                    for (Phone pOwned : person.getPhones()) {

                        joPhone.addProperty("number", pOwned.getNumber());
                        joPhone.addProperty("desccription", pOwned.getDescription());
                        jaPhones.add(joPhone);
                    }

                    JsonObject joHobbie = new JsonObject();
                    for (Hobby hOwned : person.getHobbies()) {

                        joHobbie.addProperty("name", hOwned.getName());
                        joHobbie.addProperty("description", hOwned.getDescription());
                        jaHobbies.add(joHobbie);
                    }

                    json.addProperty("id", person.getId());
                    json.addProperty("firstName", person.getFirstName());
                    json.addProperty("lastName", person.getLastName());
                    json.addProperty("email", person.getEmail());
                    json.add("phones", jaPhones);
                    json.addProperty("street", person.getAddress().getStreet());
                    json.addProperty("city", person.getAddress().getCityInfo().getCity());
                    json.addProperty("zipcode", person.getAddress().getCityInfo().getZipCode());
                    json.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
                    json.add("hobbies", jaHobbies);

                    personsArray.add(json);
                }

            }

        }

        return Response.ok(gson.toJson(personsArray)).build();

    }

    @GET
    @Path("complete/phone/{phone}")
    @Produces("application/json")
    public Response getInfoForPersonsByPhone(@PathParam("phone") String phone) throws PersonNotFoundException
    {
        List<Person> personsList = facade.getPersons();
        JsonArray personsArray = new JsonArray();
        if (personsList == null) {
            throw new PersonNotFoundException("No person with that phone found");
        } else if (personsList.isEmpty()) {
            throw new PersonNotFoundException("No person with that phone found");
        }
        for (Person person : personsList) {
            JsonObject json = new JsonObject();
            JsonArray jaHobbies = new JsonArray();
            JsonArray jaPhones = new JsonArray();

            for (Phone p : person.getPhones()) {
                if (p.getNumber().equalsIgnoreCase(phone)) {

                    JsonObject joPhone = new JsonObject();
                    for (Phone pOwned : person.getPhones()) {

                        joPhone.addProperty("number", pOwned.getNumber());
                        joPhone.addProperty("desccription", pOwned.getDescription());
                        jaPhones.add(joPhone);
                    }

                    JsonObject joHobbie = new JsonObject();
                    for (Hobby hOwned : person.getHobbies()) {

                        joHobbie.addProperty("name", hOwned.getName());
                        joHobbie.addProperty("description", hOwned.getDescription());
                        jaHobbies.add(joHobbie);
                    }

                    json.addProperty("id", person.getId());
                    json.addProperty("firstName", person.getFirstName());
                    json.addProperty("lastName", person.getLastName());
                    json.addProperty("email", person.getEmail());
                    json.add("phones", jaPhones);
                    json.addProperty("street", person.getAddress().getStreet());
                    json.addProperty("city", person.getAddress().getCityInfo().getCity());
                    json.addProperty("zipcode", person.getAddress().getCityInfo().getZipCode());
                    json.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
                    json.add("hobbies", jaHobbies);

                    personsArray.add(json);
                }
            }
        }
        return Response.ok(gson.toJson(personsArray)).build();
    }

    @GET
    @Path("complete/city/{city}")
    @Produces("application/json")
    public Response getInfoForPersonsBycity(@PathParam("city") String city) throws PersonNotFoundException
    {
        List<Person> personsList = facade.getPersons();
        JsonArray personsArray = new JsonArray();
        if (personsList == null) {
            throw new PersonNotFoundException("No person with that city found");
        } else if (personsList.isEmpty()) {
            throw new PersonNotFoundException("No person with that city found");
        }
        for (Person person : personsList) {
            JsonObject json = new JsonObject();
            JsonArray jaHobbies = new JsonArray();
            JsonArray jaPhones = new JsonArray();

            for (Phone p : person.getPhones()) {
                if (p.getInfoEntity().getAddress().getCityInfo().getCity().equalsIgnoreCase(city)) {

                    JsonObject joPhone = new JsonObject();
                    for (Phone pOwned : person.getPhones()) {

                        joPhone.addProperty("number", pOwned.getNumber());
                        joPhone.addProperty("desccription", pOwned.getDescription());
                        jaPhones.add(joPhone);
                    }

                    JsonObject joHobbie = new JsonObject();
                    for (Hobby hOwned : person.getHobbies()) {

                        joHobbie.addProperty("name", hOwned.getName());
                        joHobbie.addProperty("description", hOwned.getDescription());
                        jaHobbies.add(joHobbie);
                    }

                    json.addProperty("id", person.getId());
                    json.addProperty("firstName", person.getFirstName());
                    json.addProperty("lastName", person.getLastName());
                    json.addProperty("email", person.getEmail());
                    json.add("phones", jaPhones);
                    json.addProperty("street", person.getAddress().getStreet());
                    json.addProperty("city", person.getAddress().getCityInfo().getCity());
                    json.addProperty("zipcode", person.getAddress().getCityInfo().getZipCode());
                    json.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
                    json.add("hobbies", jaHobbies);

                    personsArray.add(json);
                }
            }
        }
        return Response.ok(gson.toJson(personsArray)).build();
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content)
    {
    }


}
