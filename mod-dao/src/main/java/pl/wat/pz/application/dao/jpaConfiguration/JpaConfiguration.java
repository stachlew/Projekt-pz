package pl.wat.pz.application.dao.jpaConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import java.util.Map;

/**
 * Created by DELL on 2016-11-13.
 */
@Configuration
public class JpaConfiguration {

    @Bean
    public EntityManagerFactory entityManagerFactory (){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("jpaHibernate");
        return entityManagerFactory;
    }

    @Bean
    public EntityManager entityManager (){
        EntityManager entityManager = entityManagerFactory().createEntityManager();
        return entityManager;
    }
}
