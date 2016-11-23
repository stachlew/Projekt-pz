package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.pz.application.dao.domain.User;

/**
 * Interfejs opart na JpaRepository dzięki czemu Spring Data sam dostarcza implementacji interfejsu
 */
public interface UserRepository extends JpaRepository<User,String> {

}
