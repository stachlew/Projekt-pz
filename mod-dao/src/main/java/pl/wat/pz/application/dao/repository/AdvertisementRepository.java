package pl.wat.pz.application.dao.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    @Query("select a from Advertisement a where a.idUser.username=?1")
    List<Advertisement> findByUsername(String username);


    @Query("select a from Advertisement a where ROWNUM <=8 order by a.dateAdded desc")
    List<Advertisement> findTopEightOfLatest();


    //---------------------Updates============//

}
