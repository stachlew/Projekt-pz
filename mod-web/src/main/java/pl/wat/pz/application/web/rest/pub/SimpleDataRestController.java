package pl.wat.pz.application.web.rest.pub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wat.pz.application.dao.domain.ItemCategory;
import pl.wat.pz.application.logic.service.ItemCategoryService;
import pl.wat.pz.application.logic.service.RegionService;
import pl.wat.pz.application.logic.service.UserDetailsService;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "rest/pub/simpleData")
public class SimpleDataRestController {

    @Autowired
    RegionService regionService;

    @Autowired
    ItemCategoryService itemCategoryService;

    @RequestMapping(value="/getRegions", method= RequestMethod.GET)
    public @ResponseBody List<String> getRegions() {
        return regionService.findAllRegionName();
    }


    @RequestMapping(value="/getCategories", method= RequestMethod.GET)
    public @ResponseBody List<String> getCategories() {
        Locale locale = LocaleContextHolder.getLocale();
        return itemCategoryService.findAllItemCategorName(locale.getLanguage());
    }
}
