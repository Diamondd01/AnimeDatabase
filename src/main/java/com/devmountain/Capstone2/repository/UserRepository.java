package com.devmountain.Capstone2.repository;

import com.devmountain.Capstone2.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);

}
