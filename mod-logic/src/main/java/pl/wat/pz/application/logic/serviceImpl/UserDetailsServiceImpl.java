package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.pz.application.dao.domain.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import pl.wat.pz.application.dao.repository.UserRepository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DELL on 2016-11-19.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService,pl.wat.pz.application.logic.service.UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {

        pl.wat.pz.application.dao.domain.User user = userRepository.findByUsername(username);
            List<GrantedAuthority> authorities =
                    buildUserAuthority(user.getRoles());

            return  buildUserForAuthentication(user, authorities);

        }


    // Converts pl.wat.pz.application.dao.domain.User user to
    // org.springframework.security.core.userdetails.User
    @Override
    public User buildUserForAuthentication(pl.wat.pz.application.dao.domain.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.isEnabled(),true,true,true, authorities);
    }

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

}
