package com.steppedua.sarafan.repository;

import com.steppedua.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, String> {
}