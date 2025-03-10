package com.example.homestayplatform.repository;

import com.example.homestayplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by their username
    Optional<User> findByUsername(String username);

    // Check if a user exists by username (for registration or validation)
    @Query("select count(u) > 0 from User u where u.username=:username")
    boolean existsByUsername(@Param("username") String username);
    
    @Query("select count(u) from User u where u.username=:uname and u.password=:pwd")
	public User validate(@Param("uname") String uname, @Param("pwd") String pwd);
}
