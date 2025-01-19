package com.exercise.crud.repository;

import com.exercise.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByAge(int age);

    Optional<User> findUserByName(String name);

    /*
       As we have extended JPARepository so save(), findOne(), findById(),
       findAll(), count(), delete(), deleteById()… without implementing these methods.
       List<User> getAllUser();
       The implementation is plugged in by Spring Data JPA automatically.
    */
}
