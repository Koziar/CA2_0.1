package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Company;
import entity.Phone;
import facade.CompanyFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyById(@PathParam("id") long id) {

        Company company = facade.getCompanyById(id);

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
    public Response getCompaniesContactInfo(@PathParam("id") long id) {

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
    public Response getCompanyContactInfoById(@PathParam("id") long id) {

        Company company = facade.getCompanyById(id);

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
    public Response getCompaniesByCVR(@PathParam("cvr") String cvr) {

        List<Company> companies = facade.getCompaniesByCVR(cvr);

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
    public Response getCompaniesByPhone(@PathParam("phone") String phone) {

        List<Company> companies = facade.getCompaniesByPhone(phone);

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

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {

    }

}
