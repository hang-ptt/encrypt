package com.example.encrypt.repository;

import com.example.encrypt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findByPhoneNumberAndAndRegion(String phoneNumber, String region);

    @Query(value = "select\n" +
            "\t*, pgp_sym_decrypt(ku.phone_number \\:\\: bytea,\n" +
            "\t'mySecretKey') as phoneNumber, pgp_sym_decrypt((ku.region \\:\\: bytea),\n" +
            "\t'mySecretKey') as region\n" +
            "from\n" +
            "\tkei_user ku\n" +
            "where\n" +
            "\tpgp_sym_decrypt(ku.phone_number \\:\\: bytea,\n" +
            "\t'mySecretKey')=:phoneNumber\n" +
            "\tand pgp_sym_decrypt(ku.region \\:\\: bytea,\n" +
            "\t'mySecretKey')=:region", nativeQuery = true)
    List<User> findByNative(@Param("phoneNumber") String phoneNumber, @Param("region") String region);
//    @Query(value = "")
//    List<User> getAll(String phoneNumber, String region);
}
