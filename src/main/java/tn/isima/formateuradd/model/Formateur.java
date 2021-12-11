
package tn.isima.formateuradd.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Formateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    @Column(nullable = false, updatable = false)
    private String formateurCode;

    public Formateur(){}

    public Formateur(String name, String lastname,String email, String password, String phone,String formateurCode) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.formateurCode = formateurCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFormateurCode() {
        return formateurCode;
    }

    public void setFormateurCode(String formateurCode) {
        this.formateurCode = formateurCode;
    }


    @Override
    public String toString() {
        return "Formateur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\''+
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
