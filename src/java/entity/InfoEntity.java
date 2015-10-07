
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//single table strategy
@DiscriminatorColumn(name="Entity_Type")//A discriminator column is used to determine which class the particular row belongs to
@Table(name="InfoEntity")//the name of the table
public abstract class InfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name="ADDRESS_ID" )
    private Address address;
    
    @OneToMany(mappedBy = "infoEntity", cascade={CascadeType.PERSIST})
    private List<Phone> phones = new ArrayList();

    public InfoEntity() {
    }
    public InfoEntity(String email) {
        this.email = email;
    }
    public Phone addPhone(Phone p){
        p.setInfoEntity(this);
        phones.add(p);
        return p;
    }

    public List<Phone> getPhones() {
        return phones;
    }
    
    public Address addAddress(Address a){
        address = a;
        return address;
    }

    public Address getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
