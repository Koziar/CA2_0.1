package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String street;
    private String additionalInfo;
    
    @OneToMany(mappedBy = "address", cascade={CascadeType.PERSIST})
    private List<InfoEntity> infoEntities = new ArrayList();
    
    @ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
    @JoinColumn(name="cityInfo_ID")
    private CityInfo cityInfo = new CityInfo();
    
    public Address() {
    }

    public Address(String street, String additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
    }
//    public CityInfo addCityInfo(CityInfo newCityInfo){
//        
//        cityInfo = newCityInfo;
//        return cityInfo;      
//    }

//    public CityInfo getCityInfo() {
//        return cityInfo;
//    }
    
    public CityInfo addCityInfo(CityInfo ci){
        cityInfo.setCity(ci.getCity());
        cityInfo.setZipCode(ci.getZipCode());
        //cityInfo.getAddresses().add(this);
        return cityInfo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public CityInfo getCityInfo()
    {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo)
    {
        this.cityInfo = cityInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", additionalInfo=" + additionalInfo + '}';
    }

}
