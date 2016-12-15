package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wat.pz.application.dao.domain.ItemCategory;

import java.util.List;

/**
 * Created by DELL on 2016-11-23.
 */
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {

   @Query("select ic from ItemCategory ic where namePL=?1 or nameENG=?1")
    ItemCategory findOneByName(String name);
}
