package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.ItemCategory;

import java.util.List;

/**
 * Created by DELL on 2016-12-10.
 */
public interface ItemCategoryService {
    List<String> findAllItemCategorName(String language);
    ItemCategory findOneByCategoryName(String name);
}
