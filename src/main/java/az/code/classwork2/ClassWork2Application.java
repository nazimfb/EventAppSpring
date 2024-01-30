package az.code.classwork2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassWork2Application {

    public static void main(String[] args) {
//        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("models")) {
//            EntityManager entityManager = entityManagerFactory.createEntityManager();
//            entityManager.close();
//        }
        SpringApplication.run(ClassWork2Application.class, args);
    }

}
