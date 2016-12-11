package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.pz.application.dao.domain.ItemCategory;

import java.util.List;

/**
 * Created by DELL on 2016-11-23.
 */
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
    ItemCategory findOneByNamePL(String namePL);
    ItemCategory findOneByNameENG(String nameENG);
}
