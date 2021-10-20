package com.example.encrypt.repository;

import com.example.encrypt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findByPhoneNumberAndAndRegion(String phoneNumber, String region);

//    @Query(value = "")
//    List<User> getAll(String phoneNumber, String region);
}
