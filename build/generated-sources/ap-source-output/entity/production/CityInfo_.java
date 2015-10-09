package entity.production;

import entity.Address;
import entity.CityInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-09T22:03:56")
@StaticMetamodel(CityInfo.class)
public class CityInfo_ { 

    public static volatile SingularAttribute<CityInfo, Long> id;
    public static volatile SingularAttribute<CityInfo, Integer> zipCode;
    public static volatile ListAttribute<CityInfo, Address> addresses;
    public static volatile SingularAttribute<CityInfo, String> city;

}