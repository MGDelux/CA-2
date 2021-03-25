package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@NamedQuery(name = "PersonEntity.deleteAllRows", query = "DELETE from PersonEntity")
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
       @OneToMany(targetEntity = PhoneEntity.class,cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    private List<PhoneEntity> phoneInfomation;
    @OneToMany(targetEntity = HobbyEntity.class,cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
    private List<HobbyEntity> hobby;
     @ManyToOne(cascade = CascadeType.PERSIST)
    private AdressEntity address;

    public PersonEntity() {
    }  
    
    public PersonEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   
    public AdressEntity getAddress() {
        return address;
    }

    public List<PhoneEntity> getPhoneInfomation() {
        return phoneInfomation;
    }

    public void setPhoneInfomation(List<PhoneEntity> phoneInfomation) {
        this.phoneInfomation = phoneInfomation;
    }

   

    public void setAddress(AdressEntity address) {
        this.address = address;
        if(address != null){
            address.setPerson(this);
            
        }
    }

    public List<HobbyEntity> getHobby() {
        return hobby;
    }

    public void setHobby(List<HobbyEntity> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "PersonEntity{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneInfomation=" + phoneInfomation + ", hobby=" + hobby + ", address=" + address + '}';
    }





   
}
