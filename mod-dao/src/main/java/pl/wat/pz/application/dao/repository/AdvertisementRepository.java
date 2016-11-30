package pl.wat.pz.application.dao.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.User;

import java.util.List;

/**
 * Created by DELL on 2016-11-23.
 */
public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
    @Query("select a from Advertisement a where a.idUser.username=?1")
    List<Advertisement> findByUsername(String username);
}
