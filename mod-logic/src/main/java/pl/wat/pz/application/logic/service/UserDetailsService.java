package pl.wat.pz.application.logic.service;

import org.springframework.security.core.GrantedAuthority;

import pl.wat.pz.application.dao.domain.Role;

import pl.wat.pz.application.logic.intermediateClass.User.UserRegistered;



import java.util.List;
import java.util.Set;

/**
 * Created by DELL on 2016-11-19.
 */
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {

    org.springframework.security.core.userdetails.User buildUserForAuthentication(pl.wat.pz.application.dao.domain.User user, List<GrantedAuthority> authorities);
    List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles);
    pl.wat.pz.application.dao.domain.User registerNewUserAccount(UserRegistered userRegistered);
}
