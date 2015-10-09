package entity.deploy;

import entity.InfoEntity;
import entity.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-09T22:03:56")
@StaticMetamodel(Phone.class)
public class Phone_ { 

    public static volatile SingularAttribute<Phone, Long> id;
    public static volatile SingularAttribute<Phone, String> description;
    public static volatile SingularAttribute<Phone, InfoEntity> infoEntity;
    public static volatile SingularAttribute<Phone, String> number;

}