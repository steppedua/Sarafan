package com.steppedua.sarafan.repository;

import com.steppedua.sarafan.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, String> {
    @EntityGraph(attributePaths = {"subscriptions", "subscribers"})
    Optional<User> findById(String s);
}