package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Phone;
//import exception.CompanyNotFoundException;
import facade.CompanyFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("company")
public class CompanyResource {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    CompanyFacade facade = new CompanyFacade(Persistence.createEntityManagerFactory("ca_devPU"));

    @Context
    private UriInfo context;
    
    @Context
    ServletContext servletContext;

    public CompanyResource() {
    }

    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompaniesAllDetails() {

        List<Company> companies = facade.getCompanies();
        
        
        JsonArray jsonCompanies = new JsonArray();

        for (Company company : companies) {
            JsonObject jsonCompany = new JsonObject();
            jsonCompany.addProperty("id", company.getId());
            jsonCompany.addProperty("name", company.getName());
            jsonCompany.addProperty("cvr", company.getCvr());
            jsonCompany.addProperty("city", company.getAddress().getCityInfo().getCity());
            jsonCompany.addProperty("zipcode", company.getAddress().getCityInfo().getZipCode());
            jsonCompany.addProperty("street", company.getAddress().getStreet());
            //jsonCompany.addProperty("description", company.getDescription());
            jsonCompany.addProperty("email", company.getEmail());
            //jsonCompany.addProperty("additionalInfo", company.getAddress().getAdditionalInfo());

            JsonObject jsonPhone = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (Phone phone : company.getPhones()) {

                jsonPhone.addProperty("number", phone.getNumber());
                jsonPhone.addProperty("description", phone.getDescription());

                jsonArray.add(jsonPhone);
            }
            jsonCompany.add("phones", jsonArray);
            jsonCompanies.add(jsonCompany);
        }

        return Response.ok(gson.toJson(jsonCompanies)).build();
    }

    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyById(@PathParam("id") long id){

        Company company = facade.getCompanyById(id);
        
        //if(company == null)throw new CompanyNotFoundException("A company with the given ID does not exist!");

        JsonObject jsonCompany = new JsonObject();
        jsonCompany.addProperty("id", company.getId());
        jsonCompany.addProperty("name", company.getName());
        jsonCompany.addProperty("cvr", company.getCvr());
        jsonCompany.addProperty("description", company.getDescription());
        jsonCompany.addProperty("email", company.getEmail());
        jsonCompany.addProperty("street", company.getAddress().getStreet());
        jsonCompany.addProperty("zipcode", company.getAddress().getCityInfo().getZipCode());
        jsonCompany.addProperty("city", company.getAddress().getCityInfo().getCity());
        jsonCompany.addProperty("additionalInfo", company.getAddress().getAdditionalInfo());

        JsonObject jsonPhone = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (Phone phone : company.getPhones()) {

            jsonPhone.addProperty("number", phone.getNumber());
            jsonPhone.addProperty("description", phone.getDescription());

            jsonArray.add(jsonPhone);
        }
        jsonCompany.add("phones", jsonArray);

        return Response.ok(gson.toJson(jsonCompany)).build();
    }
    
    @GET
    @Path("contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompaniesContactInfo(){

        List<Company> companies = facade.getCompanies();

        JsonArray jsonCompanies = new JsonArray();

        for (Company company : companies) {
            JsonObject jsonCompany = new JsonObject();
            jsonCompany.addProperty("id", company.getId());
            jsonCompany.addProperty("name", company.getName());
            //jsonCompany.addProperty("cvr", company.getCvr());
            //jsonCompany.addProperty("description", company.getDescription());
            jsonCompany.addProperty("email", company.getEmail());
            jsonCompany.addProperty("street", company.getAddress().getStreet());
            jsonCompany.addProperty("zipcode", company.getAddress().getCityInfo().getZipCode());
            jsonCompany.addProperty("city", company.getAddress().getCityInfo().getCity());
            jsonCompany.addProperty("additionalInfo", company.getAddress().getAdditionalInfo());

            JsonObject jsonPhone = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (Phone phone : company.getPhones()) {

                jsonPhone.addProperty("number", phone.getNumber());
                jsonPhone.addProperty("description", phone.getDescription());

                jsonArray.add(jsonPhone);
            }
            jsonCompany.add("phones", jsonArray);
            jsonCompanies.add(jsonCompany);
        }

        return Response.ok(gson.toJson(jsonCompanies)).build();
    }
    
    @GET
    @Path("contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyContactInfoById(@PathParam("id") long id){

        Company company = facade.getCompanyById(id);
        
        //if(company == null)throw new CompanyNotFoundException("A company with the given ID does not exist!");
        
        JsonObject jsonCompany = new JsonObject();
        jsonCompany.addProperty("id", company.getId());
        jsonCompany.addProperty("name", company.getName());
        //jsonCompany.addProperty("cvr", company.getCvr());
        //jsonCompany.addProperty("description", company.getDescription());
        jsonCompany.addProperty("email", company.getEmail());
        jsonCompany.addProperty("street", company.getAddress().getStreet());
        jsonCompany.addProperty("zipcode", company.getAddress().getCityInfo().getZipCode());
        jsonCompany.addProperty("city", company.getAddress().getCityInfo().getCity());
        jsonCompany.addProperty("additionalInfo", company.getAddress().getAdditionalInfo());

        JsonObject jsonPhone = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (Phone phone : company.getPhones()) {

            jsonPhone.addProperty("number", phone.getNumber());
            jsonPhone.addProperty("description", phone.getDescription());

            jsonArray.add(jsonPhone);
        }
        jsonCompany.add("phones", jsonArray);

        return Response.ok(gson.toJson(jsonCompany)).build();
    }
    
    @GET
    @Path("complete/cvr/{cvr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompaniesByCVR(@PathParam("cvr") String cvr){

        List<Company> companies = facade.getCompaniesByCVR(cvr);
        
//        if(companies == null)throw new CompanyNotFoundException("A company with the given CVR does not exist!");
//        else if(companies.isEmpty())throw new CompanyNotFoundException("A company with the given CVR does not exist!");

        JsonArray jsonCompanies = new JsonArray();

        for (Company company : companies) {
            JsonObject jsonCompany = new JsonObject();
            jsonCompany.addProperty("id", company.getId());
            jsonCompany.addProperty("name", company.getName());
            jsonCompany.addProperty("cvr", company.getCvr());
            jsonCompany.addProperty("description", company.getDescription());
            jsonCompany.addProperty("email", company.getEmail());
            jsonCompany.addProperty("street", company.getAddress().getStreet());
            jsonCompany.addProperty("zipcode", company.getAddress().getCityInfo().getZipCode());
            jsonCompany.addProperty("city", company.getAddress().getCityInfo().getCity());
            jsonCompany.addProperty("additionalInfo", company.getAddress().getAdditionalInfo());

            JsonObject jsonPhone = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (Phone phone : company.getPhones()) {

                jsonPhone.addProperty("number", phone.getNumber());
                jsonPhone.addProperty("description", phone.getDescription());

                jsonArray.add(jsonPhone);
            }
            jsonCompany.add("phones", jsonArray);
            jsonCompanies.add(jsonCompany);
        }

        return Response.ok(gson.toJson(jsonCompanies)).build();
    }
    
    @GET
    @Path("complete/phone/{phone}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompaniesByPhone(@PathParam("phone") String phone){

        List<Company> companies = facade.getCompaniesByPhone(phone);
        
//        if(companies == null)throw new CompanyNotFoundException("A company with the given Phone does not exist!");
//        else if(companies.isEmpty())throw new CompanyNotFoundException("A company with the given Phone does not exist!");

        JsonArray jsonCompanies = new JsonArray();

        for (Company company : companies) {
            JsonObject jsonCompany = new JsonObject();
            jsonCompany.addProperty("id", company.getId());
            jsonCompany.addProperty("name", company.getName());
            jsonCompany.addProperty("cvr", company.getCvr());
            jsonCompany.addProperty("description", company.getDescription());
            jsonCompany.addProperty("email", company.getEmail());
            jsonCompany.addProperty("street", company.getAddress().getStreet());
            jsonCompany.addProperty("zipcode", company.getAddress().getCityInfo().getZipCode());
            jsonCompany.addProperty("city", company.getAddress().getCityInfo().getCity());
            jsonCompany.addProperty("additionalInfo", company.getAddress().getAdditionalInfo());

            JsonObject jsonPhone = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (Phone p : company.getPhones()) {

                jsonPhone.addProperty("number", p.getNumber());
                jsonPhone.addProperty("description", p.getDescription());

                jsonArray.add(jsonPhone);
            }
            jsonCompany.add("phones", jsonArray);
            jsonCompanies.add(jsonCompany);
        }

        return Response.ok(gson.toJson(jsonCompanies)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewCompany(String newPerson) {
        
        JsonObject jo = new JsonParser().parse(newPerson).getAsJsonObject();
        //
        String name = jo.get("name").getAsString();
        String cvr = jo.get("cvr").getAsString();
        String description = jo.get("description").getAsString();
        int numEmployees = jo.get("numEmployees").getAsInt();
        String marketValue = jo.get("marketValue").getAsString();
        String email = jo.get("email").getAsString();
        String street = jo.get("street").getAsString();
        int zipcode = jo.get("zipcode").getAsInt();
        String city = jo.get("city").getAsString();
        String additionalInfoAddress = jo.get("additionalInfoAddress").getAsString();
        String additionalInfo = jo.get("additionalInfo").getAsString();
        
        JsonArray jPhones = new JsonArray();
        jPhones = jo.getAsJsonArray("phones");
        ArrayList<Phone> phones = new ArrayList();
        
        for (JsonElement jp : jPhones) {
            Phone p = new Phone(jp.getAsJsonObject().get("number").getAsString(), 
                    jp.getAsJsonObject().get("description").getAsString());
            phones.add(p); 
        }
        Company newCompany = new Company(name, description, cvr, numEmployees, marketValue, email);
        Address newCompanyAddress = new Address(street, additionalInfoAddress);
        CityInfo newCompanyAddressCityInfo = new CityInfo(zipcode, city);
        newCompanyAddress.addCityInfo(newCompanyAddressCityInfo);
        
        for (Phone phone : phones) {
            newCompany.addPhone(phone);
        }
        newCompany.addAddress(newCompanyAddress);
        
        Company createdCompany = facade.addCompany(newCompany);
        //=========================================================
        
        //if(company == null)throw new CompanyNotFoundException("A company with the given ID does not exist!");

        JsonObject jsonCompany = new JsonObject();
        jsonCompany.addProperty("id", createdCompany.getId());
        jsonCompany.addProperty("name", createdCompany.getName());
        jsonCompany.addProperty("cvr", createdCompany.getCvr());
        jsonCompany.addProperty("description", createdCompany.getDescription());
        jsonCompany.addProperty("email", createdCompany.getEmail());
        jsonCompany.addProperty("street", createdCompany.getAddress().getStreet());
        jsonCompany.addProperty("zipcode", createdCompany.getAddress().getCityInfo().getZipCode());
        jsonCompany.addProperty("city", createdCompany.getAddress().getCityInfo().getCity());
        jsonCompany.addProperty("additionalInfo", createdCompany.getAddress().getAdditionalInfo());

        JsonObject jsonPhone = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        System.out.println("==============================");
        System.out.println(createdCompany.getPhones().toString());
        System.out.println("================================");
        for (Phone phone : createdCompany.getPhones()) {

            jsonPhone.addProperty("number", phone.getNumber());
            jsonPhone.addProperty("description", phone.getDescription());

            jsonArray.add(jsonPhone);
        }
        jsonCompany.add("phones", jsonArray);

        return Response.ok(gson.toJson(jsonCompany)).build();

    }
    
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {

    }

}
