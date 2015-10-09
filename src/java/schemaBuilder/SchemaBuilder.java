/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schemaBuilder;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
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
            List<Company> companyList = new ArrayList();
            for (int i = 0; i < 25; i++) {
                Person p = new Person(sm.getRandomFName(), sm.getRandomLName(), sm.email());
                p.addHobby(sm.getRandomHobby());
                p.addAddress(sm.getRandomAddress()).addCityInfo(sm.getRandomCityInfo());
                p.addPhone(sm.getRandomPhone());
                personList.add(p);
                
                Company c = new Company(sm.getRandomName(), sm.getRandomDescription(), 
                sm.getRandomCVR(), sm.getRandomNumEmployees(), sm.getRandomMarketValue(), sm.email());
                c.addAddress(sm.getRandomAddress()).addCityInfo(sm.getRandomCityInfo());
                c.addPhone(sm.getRandomPhone());
                companyList.add(c);
            }
            em.getTransaction().begin();
            for (int i = 0; i < 25; i++) {
                em.persist(personList.get(i));
                em.persist(companyList.get(i));
            }
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public String getRandomCVR() {
        ArrayList<String> cvr = new ArrayList();
        cvr.add("926224");
        cvr.add("764774");
        cvr.add("587882");
        cvr.add("246536");
        cvr.add("593677");
        cvr.add("359763");
        cvr.add("833246");
        cvr.add("999867");
        cvr.add("724547");
        cvr.add("285653");
        cvr.add("584762");
        cvr.add("943398");
        cvr.add("892252");
        cvr.add("476738");
        cvr.add("737556");
        cvr.add("847746");
        cvr.add("489927");
        cvr.add("848954");
        cvr.add("385483");
        cvr.add("688789");
        cvr.add("428769");
        cvr.add("688979");
        cvr.add("263872");
        cvr.add("693986");
        cvr.add("359288");
        cvr.add("438682");
        int index = random.nextInt(cvr.size());
        return cvr.get(index);
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

    public String getRandomDescription() {

        ArrayList<String> description = new ArrayList();
        description.add("Lots of opportunity to work in a fast-paced field with a variety of authors, and employees who are at the top of the industry. Learned a LOT.");
        description.add("Not a lot of growth opportunity internally, a lot of favoritism. Longtime employees could get away with a lot, and some of them were rude, entitled.");
        description.add("Great legacy publishing company. Lots of pride in employees");
        description.add("Weak on culture and still behind the 8 ball in terms of digital, which I don't think they will every get.");
        description.add("Fantastic people, awesome benefits and bonuses, free books, 401k matching, great work-life balance, the best books in the industry, summer Fridays, European vacation time.");
        description.add("Everyone loves it there so it can be difficult to advance.");
        description.add("Very talented publishing staff, which makes this a terrific place for people who want to go into the Publishing field.");
        description.add("EXCELLENT benefits unparalleled vacation days free books");
        description.add("Low salaries. Takes a long time to get promoted. Not the most tech-savvy group of people.");
        description.add("Great benefits, lots of corporate perks. Great name to add to your resume.");
        description.add("Awesome Benefits, great atmosphere, creative environment, enjoyable work, decent hours");
        description.add("salary, rate of promotions in finance, high turnover, limited bonus structure, industry changing");
        description.add("Lots of responsibility and challenges with very little direction. Everything is up to you to decide how to solve. The environment is great if you like solving your own problems your own way.");
        description.add("Management doesn't seem to understand basic concepts. They seem to value profit over ethics and maintaining relationships with their suppliers.");

        int index = random.nextInt(description.size());
        return description.get(index);
    }

    public String getRandomMarketValue(){
        
        ArrayList<String> marketValue = new ArrayList();
        marketValue.add("9887633");
        marketValue.add("2837822");
        marketValue.add("3366759");
        marketValue.add("7488894");
        marketValue.add("7893892");
        marketValue.add("9943364");
        marketValue.add("8277559");
        marketValue.add("7724467");
        marketValue.add("2763443");
        marketValue.add("3588957");
        marketValue.add("8884632");
        marketValue.add("4357939");
        marketValue.add("2936694");
        marketValue.add("3284598");
        marketValue.add("9475836");
        marketValue.add("8345438");
        
        int index = random.nextInt(marketValue.size());

        return marketValue.get(index);
    }
    
    public Hobby getRandomHobby(){
        
        ArrayList<Hobby> hobby = new ArrayList();
        
        hobby.add(new Hobby("Aircraft Spotting", "lot of fun"));
        hobby.add(new Hobby("Airbrushing", "lot of fun"));
        hobby.add(new Hobby("Airsofting", "lot of fun"));
        hobby.add(new Hobby("Acting", "lot of fun"));
        hobby.add(new Hobby("Aeromodeling", "lot of fun"));
        hobby.add(new Hobby("Amateur Astronomy", "lot of fun"));
        hobby.add(new Hobby("Amateur Radio", "lot of fun"));
        hobby.add(new Hobby("Animals/pets/dogs", "lot of fun"));
        hobby.add(new Hobby("Archery", "lot of fun"));
        hobby.add(new Hobby("Arts", "lot of fun"));
        hobby.add(new Hobby("Aquarium (Freshwater & Saltwater)", "lot of fun"));
        hobby.add(new Hobby("Astrology", "lot of fun"));
        hobby.add(new Hobby("Astronomy", "lot of fun"));
        hobby.add(new Hobby("Backgammon", "lot of fun"));
        hobby.add(new Hobby("Badminton", "lot of fun"));
        hobby.add(new Hobby("Baseball", "lot of fun"));
        hobby.add(new Hobby("Base Jumping", "lot of fun"));
        
        int index = random.nextInt(hobby.size());

        return hobby.get(index);
    }
    
    public Phone getRandomPhone(){
        
       ArrayList<Phone> phone = new ArrayList();
       phone.add(new Phone("+4550333777", "call and you will see"));
       phone.add(new Phone("+4550333771", "call and you will see"));
       phone.add(new Phone("+4550333772", "call and you will see"));
       phone.add(new Phone("+4550333773", "call and you will see"));
       phone.add(new Phone("+4550333774", "call and you will see"));
       phone.add(new Phone("+4550333775", "call and you will see"));
       phone.add(new Phone("+4550333776", "call and you will see"));
       phone.add(new Phone("+4550333778", "call and you will see"));
       phone.add(new Phone("+4550333779", "call and you will see"));
       phone.add(new Phone("+4550333717", "call and you will see"));
       phone.add(new Phone("+4550333727", "call and you will see"));
       phone.add(new Phone("+4550333737", "call and you will see"));
       phone.add(new Phone("+4550333747", "call and you will see"));
       phone.add(new Phone("+4550333757", "call and you will see"));
       phone.add(new Phone("+4550333767", "call and you will see"));
       phone.add(new Phone("+4550333787", "call and you will see"));
       phone.add(new Phone("+4550333797", "call and you will see"));
       phone.add(new Phone("+4550333177", "call and you will see"));
       phone.add(new Phone("+4550333277", "call and you will see"));
       phone.add(new Phone("+4550333377", "call and you will see"));
       phone.add(new Phone("+4550333477", "call and you will see"));

       int index = random.nextInt(phone.size());

        return phone.get(index);
    }
    
    public Address getRandomAddress(){
        
        ArrayList<Address> address = new ArrayList();
        address.add(new Address("Vesterbrogade 3", "Radisson Blu Royal Hotel"));
        address.add(new Address("Kongens Nytorn 8", "Dansk Design Center"));
        address.add(new Address("Bernstorffsgade 5", "Danish Museum of Art & Design"));
        address.add(new Address("Kongens Nytorv 18", "Taschen"));
        address.add(new Address("Strandgade 93", "Illums Bolighus "));
        address.add(new Address("Hammerichsgade1", "Royal Copenhagen Store"));
        address.add(new Address("Hammerichsgade1", "The Little Mermaid"));
        address.add(new Address("Bådsmandsstræde 43", "Freetown Christiania"));
        address.add(new Address("Langelinie 19", "Tivoli"));
        address.add(new Address("H. C. Andersens Boulevard 27", "Radisson Blu Royal Hotel"));
        address.add(new Address("Bredgade 68", "Andersen Bakery (for breakfast and hotdogs)"));
        address.add(new Address("Østergade 2A", "Fiat (Italian restaurant)"));
        address.add(new Address("Amagertorv 10", "The Paul"));
        address.add(new Address("Amagertorv 6", "Nyhavn"));
        
        int index = random.nextInt(address.size());

        return address.get(index);
    }
    
    public CityInfo getRandomCityInfo(){
        
        ArrayList<CityInfo> cityInfo = new ArrayList();
        cityInfo.add(new CityInfo(2830,"Scanning"));
        cityInfo.add(new CityInfo(2840,"Høje Taastrup"));
        cityInfo.add(new CityInfo(2850,"København C"));
        cityInfo.add(new CityInfo(2860,"Sjælland USF P"));
        cityInfo.add(new CityInfo(2870,"Sjælland USF B"));
        cityInfo.add(new CityInfo(2880,"eBrevsprækken"));
        cityInfo.add(new CityInfo(2890,"Udbetaling"));
        cityInfo.add(new CityInfo(2310,"Kommuneservice"));
        cityInfo.add(new CityInfo(2320,"Københavns Pakkecenter"));
        cityInfo.add(new CityInfo(2330,"Københavns Pakke BRC"));
        cityInfo.add(new CityInfo(2340,"Skovlunde"));
        cityInfo.add(new CityInfo(2350,"Ballerup"));
        cityInfo.add(new CityInfo(2360,"Måløv"));
        cityInfo.add(new CityInfo(2370,"Smørum"));
        cityInfo.add(new CityInfo(2380,"Kastrup"));
        cityInfo.add(new CityInfo(2390,"Kongens Lyngby"));
        cityInfo.add(new CityInfo(2400,"Gentofte"));
        
        int index = random.nextInt(cityInfo.size());

        return cityInfo.get(index);
    }
    
    public String getRandomName(){
        
        ArrayList<String> name = new ArrayList();
        name.add("A.P. Møller - Mærsk");
        name.add("Danske Bank");
        name.add("ISS");
        name.add("United Shipping & Trading Company");
        name.add("Novo Nordisk");
        name.add("Wrist Group");
        name.add("Carlsberg");
        name.add("DONG Energy");
        name.add("Arla Foods");
        name.add("Danish Crown");
        name.add("DSV");
        name.add("Vestas Wind Systems");
        name.add("Nykredit");
        name.add("DLG");
        name.add("Coop Danmark");
        name.add("Danfoss");
        name.add("Nordea Bank Danmark");
        name.add("Skandinavisk Holding");
        name.add("TDC");
        name.add("Statoil Refining Denmark");
        int index = random.nextInt(name.size());

        return name.get(index);
    }
    
    public int getRandomNumEmployees() {

        ArrayList<Integer> numEmployees = new ArrayList();
        numEmployees.add(97379);
        numEmployees.add(48357);
        numEmployees.add(48284);
        numEmployees.add(75932);
        numEmployees.add(32948);
        numEmployees.add(25795);
        numEmployees.add(53978);
        numEmployees.add(89448);
        numEmployees.add(49828);
        numEmployees.add(98979);
        numEmployees.add(98677);
        numEmployees.add(78652);
        numEmployees.add(43275);
        numEmployees.add(26367);
        numEmployees.add(87962);
        numEmployees.add(46582);
        numEmployees.add(27755);
        numEmployees.add(42647);
        numEmployees.add(83637);
        numEmployees.add(32288);
        numEmployees.add(38426);
        numEmployees.add(64654);
        numEmployees.add(95694);
        int index = random.nextInt(numEmployees.size());

        return numEmployees.get(index);
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
        lastName.add("Burchard");
        lastName.add("Hambleton");
        lastName.add("Copp");
        lastName.add("Buis");
        lastName.add("Learned");
        lastName.add("Boggan");
        lastName.add("Begley");
        lastName.add("Policastro");
        lastName.add("Bergquist");
        lastName.add("Shell");
        lastName.add("Dimery");
        lastName.add("Alverson");
        lastName.add("Mak");
        lastName.add("Penaflor");
        int index = random.nextInt(lastName.size());

        return lastName.get(index);

    }

    public String email() {

        ArrayList<String> email = new ArrayList();
        email.add("info@jdkarting.com");
        email.add("orders@universal-info.com");
        email.add("info@lymebuddies.com");
        email.add("editorial@acoua-info.com");
        email.add("webmaster@braco-info.com");
        email.add("info@ghazipurinfo.com");
        email.add("info@ptaainfo.com");
        email.add("gnanainfo.hyd@gmail.com");
        email.add("sales@dmcinfo.com");
        email.add("info@bundeenainfo.com");
        email.add("info@burrburton.org");
        email.add("niraj@bestmediainfo.com");
        email.add("dimensimaket@mail.compin");
        email.add("dinhvuvanhung@mail.com");
        email.add("e.gabion@mail.com");
        email.add("teatromascaras1@mail.com");
        email.add("butnguyentu@mail.com");
        email.add("livia@intelligenzia.com.br");
        email.add("jaimy.dehaas@mail.com");
        email.add("guardbabu@mail.com");
        email.add("marlon201011@mail.com");
        email.add("briannamc@mail.com");
        email.add("mistresscristal@mail.com");
        email.add("azharalichana@mail.com");
        email.add("victor_farias@live.com");
        email.add("margheritalogiudice@mail.com");
        int index = random.nextInt(email.size());
        return email.get(index);

    }

}