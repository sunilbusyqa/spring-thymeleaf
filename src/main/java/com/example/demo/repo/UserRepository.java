package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.User;

/**
 * Documentation
 *
 * @author Sunil Dabburi
 * @since 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
