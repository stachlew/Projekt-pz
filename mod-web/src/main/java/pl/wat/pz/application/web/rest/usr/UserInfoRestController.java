package pl.wat.pz.application.web.rest.usr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wat.pz.application.dao.domain.UserDetails;
import pl.wat.pz.application.logic.service.RegionService;
import pl.wat.pz.application.logic.service.UserDetailsService;
import pl.wat.pz.application.web.wrapper.StringResponse;

@Controller
@RequestMapping(value = "rest/usr/userInfo")
public class UserInfoRestController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    RegionService regionService;

    @RequestMapping(value="/getRegionName", method= RequestMethod.GET, produces = "application/json")
    public @ResponseBody StringResponse getRegionName(Authentication auth) {
        if(auth!=null) {
            pl.wat.pz.application.dao.domain.UserDetails userDet = userDetailsService.getUserDetailsByUsername(auth.getName());
            return new StringResponse(regionService.loadRegionNameById(userDet.getIdRegion().getIdRegion()));
        }
        return null;
    }

    @RequestMapping(value="/getUserDetails", method= RequestMethod.GET)
    public @ResponseBody
    UserDetails getUserDetails(Authentication auth) {
        if(auth!=null) {
            return userDetailsService.getUserDetailsByUsername(auth.getName());
        }
        return null;
    }

}
