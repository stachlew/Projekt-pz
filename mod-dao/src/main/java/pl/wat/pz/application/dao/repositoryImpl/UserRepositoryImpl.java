package pl.wat.pz.application.dao.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.wat.pz.application.dao.domain.User;
import pl.wat.pz.application.dao.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("Select u FROM User u where u.username= :username");
        query.setParameter("username",username);
        List<User> users = query.getResultList();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }
}
