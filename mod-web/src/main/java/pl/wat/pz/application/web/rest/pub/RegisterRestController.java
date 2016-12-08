package pl.wat.pz.application.web.rest.pub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wat.pz.application.logic.service.RegionService;
import pl.wat.pz.application.logic.service.UserDetailsService;

import java.util.List;

@Controller
@RequestMapping(value = "rest/pub/register")
public class RegisterRestController {

    @Autowired
    RegionService regionService;

    @RequestMapping(value="/getRegions", method= RequestMethod.GET)
    public @ResponseBody List<String> getRegions() {
        return regionService.findAllRegionName();
    }
}
