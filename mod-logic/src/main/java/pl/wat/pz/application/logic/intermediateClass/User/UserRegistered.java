package pl.wat.pz.application.logic.intermediateClass.User;

/**
 * Created by DELL on 2016-12-06.
 */
public class UserRegistered {
    String username;
    String password;
    String roleName;
    String mail;
    String phone;
    String city;
    String regionName;

    public UserRegistered() {
    }

    public UserRegistered(String username, String password, String roleName, String mail, String phone, String city, String regionName) {
        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.mail = mail;
        this.phone = phone;
        this.city = city;
        this.regionName = regionName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
