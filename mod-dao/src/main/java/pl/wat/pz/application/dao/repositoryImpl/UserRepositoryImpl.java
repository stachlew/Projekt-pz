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

/**
 * Created by DELL on 2016-11-13.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;


    @Override
    //Tymczasowe rozwiazenie, w przyszłości adnotacja transactional
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void downloadAllUsers() {
        Query query = entityManager.createQuery("FROM User");
        List<User> result =  query.getResultList();

        for (User user:result
             ) {
            System.out.println(user);
        }
    }
}
