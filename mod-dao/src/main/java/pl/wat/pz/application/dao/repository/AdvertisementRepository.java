package pl.wat.pz.application.dao.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.User;

import java.util.List;

/**
 * Created by DELL on 2016-11-23.
 */


@Transactional(readOnly = true)
public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {

    //---------------------Selects--------------//
    @Transactional
    @Query("select a from Advertisement a where a.idUser.username=?1 and a.advertisementDeleted=0")
    List<Advertisement> findByUsername(String username);

    @Transactional
    @Procedure(name = "proc_search")
    void findAdvertisementWithParam(@Param("v_title") String title, @Param("v_id_item_category") String idItemCategory, @Param("v_id_region") String idRegion,
                                    @Param("v_city") String city, @Param("v_bail_value_for") String bailValueFor, @Param("v_bail_value_to") String bailValueTo,
                                    @Param("v_charger_per_day_for") String chargerPerDayFor, @Param("v_charger_per_day_to") String chargerPerDayTo);
    @Transactional
    @Query(value = "select * from adv_tmp",nativeQuery = true)
    List<Advertisement> findByParameters();

    @Transactional
    Advertisement findByIdAdvertisementAndAdvertisementDeletedFalse(long idAdvertisment);

    @Transactional
    Page<Advertisement> findByAdvertisementDeletedFalse(Pageable pageable);

    @Transactional
    @Query("select max(a.idAdvertisement) from Advertisement a where  a.idUser.username=?1 and a.advertisementDeleted=0")
    long findMaxIdAdvertisementByUsername(String username);
    //---------------------Updates============//

}
