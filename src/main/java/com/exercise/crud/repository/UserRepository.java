package com.exercise.crud.repository;

import com.exercise.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByAge(int age);

    List<User> isAdmin(boolean isAdmin);

    /*
       As we have extended JPARepository so save(), findOne(), findById(),
       findAll(), count(), delete(), deleteById()… without implementing these methods.
       List<User> getAllUser();
       The implementation is plugged in by Spring Data JPA automatically.
    */
}
