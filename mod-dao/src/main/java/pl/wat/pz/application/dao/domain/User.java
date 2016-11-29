package pl.wat.pz.application.dao.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(length = 50)
    private String username;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(nullable = false)
    @ColumnDefault(value = "1")
    private boolean enabled;

    @Embedded
    private UserDetails details;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>(0);

    public User() {
    }

    public User(String username, String password, boolean enabled, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public User(String username, String password, boolean enabled, UserDetails details, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.details = details;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}