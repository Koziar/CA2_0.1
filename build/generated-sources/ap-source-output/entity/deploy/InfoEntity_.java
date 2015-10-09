package entity.deploy;

import entity.Address;
import entity.InfoEntity;
import entity.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-09T22:03:56")
@StaticMetamodel(InfoEntity.class)
public abstract class InfoEntity_ { 

    public static volatile SingularAttribute<InfoEntity, Long> id;
    public static volatile SingularAttribute<InfoEntity, String> email;
    public static volatile SingularAttribute<InfoEntity, Address> address;
    public static volatile ListAttribute<InfoEntity, Phone> phones;

}