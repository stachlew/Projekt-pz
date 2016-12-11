package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.pz.application.dao.domain.Role;


import pl.wat.pz.application.dao.repository.RegionRepository;
import pl.wat.pz.application.dao.repository.RoleRepository;
import pl.wat.pz.application.dao.repository.UserRepository;
import pl.wat.pz.application.logic.intermediateClass.User.UserRegistered;
import pl.wat.pz.application.logic.service.UserDetailsService;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Boolean.TRUE;

/**
 * Serwis umożliający komunikacje z bazą w celu pobrania lub dodania użytkownika
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Implementacja metody pochodzącej z interfejsu UserDetailsService
     * umożliwia zbudowanie obiektu UserDetails interpretowanego przez SpringSecurity
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {

        pl.wat.pz.application.dao.domain.User user = userRepository.findOne(username);
            List<GrantedAuthority> authorities =
                    buildUserAuthority(user.getRoles());

            return  buildUserForAuthentication(user, authorities);

        }

    /**
     * Metoda umożliwia zbudowanie obiektu klasy User z pakietu security
     * z obiektu podzącego z bazy danych klasy User z pakietu domain
     * @param user
     * @param authorities
     * @return
     */
    @Override
    public User buildUserForAuthentication(pl.wat.pz.application.dao.domain.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.isEnabled(),true,true,true, authorities);
    }

    /**
     * Metoda umożliwia zbudowanie obiektu klasy List<GrantedAuthority> interpetowanego przez Spring Security
     * z obiektów bazodanowych klasy Role
     * @param userRoles
     * @return List<GrantedAuthority>
     */
    @Override
    public List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

    @Override
    public pl.wat.pz.application.dao.domain.User registerNewUserAccount(UserRegistered userRegistered) {
        pl.wat.pz.application.dao.domain.UserDetails userDetails = new  pl.wat.pz.application.dao.domain.UserDetails();
        userDetails.setCity(userRegistered.getCity());
        userDetails.setMail(userRegistered.getMail());
        userDetails.setPhone(userRegistered.getPhone());
        userDetails.setIdRegion(regionRepository.findOneByName(userRegistered.getRegionName()));

        Role role = roleRepository.findOneByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        pl.wat.pz.application.dao.domain.User user = new pl.wat.pz.application.dao.domain.User(userRegistered.getUsername(),passwordEncoder.encode(userRegistered.getPassword()),TRUE,userDetails,roles);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserAccount(String username) {
        if (this.exist(username)) {
            userRepository.delete(username);
        }
    }

    @Override
    public pl.wat.pz.application.dao.domain.User getUserByUsername(String username){
        return userRepository.getOne(username);
    }

    @Override
    @javax.transaction.Transactional
    public pl.wat.pz.application.dao.domain.UserDetails getUserDetailsByUsername(String username){
        return userRepository.getOne(username).getDetails();
    }

    @Override
    public boolean exist(String username) {
        return userRepository.exists(username);
    }


}
