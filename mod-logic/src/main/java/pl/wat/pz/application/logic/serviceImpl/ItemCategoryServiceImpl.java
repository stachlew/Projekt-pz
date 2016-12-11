package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.ItemCategory;
import pl.wat.pz.application.dao.repository.ItemCategoryRepository;
import pl.wat.pz.application.logic.service.ItemCategoryService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by DELL on 2016-12-10.
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    public List<String> findAllItemCategorName(String language){
        List<ItemCategory> itemCategories = itemCategoryRepository.findAll();
        List<String> nameCategories=new LinkedList<>();
        for (ItemCategory category:itemCategories) {
            switch (language){
                case "pl":{
                    nameCategories.add(category.getNamePL());
                    break;
                }
                case "en":{
                    nameCategories.add(category.getNameENG());
                    break;
                }
            }
        }
        return nameCategories;
    }

    @Override
    public ItemCategory findOneByCategoryName(String name, String lang) {
        if(lang.equals("pl")){
            return itemCategoryRepository.findOneByNamePL(name);
        }else{
            return itemCategoryRepository.findOneByNameENG(name);
        }
    }

}
