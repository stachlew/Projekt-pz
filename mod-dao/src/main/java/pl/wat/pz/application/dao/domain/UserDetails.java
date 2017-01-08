package pl.wat.pz.application.dao.domain;

import org.hibernate.annotations.ColumnDefault;
import pl.wat.pz.application.dao.intermediateClass.User.UserRegistered;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

/**
 * Szczegółowe informacje o kliencie
 */

@Embeddable
public class UserDetails {


    @Column(length = 50,nullable = true)
    private String mail;

    @Column(length = 15,nullable = true)
    private String phone;

    @Column(length = 30,nullable = true)
    private String city;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_region")
    private Region idRegion;

    @Column(name = "account_create_date")
    @ColumnDefault(value = "sysdate")
    private Date accountCreateDate;

    public UserDetails() {
    }

    public UserDetails(String mail, String phone, String city, Region idRegion, Date accountCreateDate) {
        this.mail = mail;
        this.phone = phone;
        this.city = city;
        this.idRegion = idRegion;
        this.accountCreateDate = accountCreateDate;
    }

    public UserDetails(UserRegistered userRegistered){
        this.mail = userRegistered.getMail();
        this.phone = userRegistered.getPhone();
        this.city = userRegistered.getCity();
        this.accountCreateDate=new Date(Calendar.getInstance().getTime().getTime());
    }


    public Date getAccountCreateDate() {
        return accountCreateDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Region getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Region idRegion) {
        this.idRegion = idRegion;
    }


}
