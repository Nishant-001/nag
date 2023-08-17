package com.ecommerce.repo;

import com.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

    User findByRole(String role);

    List<User> findAllByRole(int i);

    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);

}
