package pl.wat.pz.application.dao.intermediateClass.User;

/**
 * Created by Marian on 2017-01-07.
 */
public class UserForm {
    private String password;
    private String mail;
    private String phone;
    private String city;
    private String regionName;

    public UserForm() {
    }

    public UserForm(String password, String mail, String phone, String city, String regionName) {
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.city = city;
        this.regionName = regionName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
