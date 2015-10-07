package entity;

import entity.CityInfo;
import entity.InfoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-07T12:47:13")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Long> id;
    public static volatile ListAttribute<Address, InfoEntity> infoEntities;
    public static volatile SingularAttribute<Address, CityInfo> cityInfo;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> additionalInfo;

}