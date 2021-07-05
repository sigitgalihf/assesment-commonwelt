package com.testbankcommonwelt.assesment.repositories;

import com.testbankcommonwelt.assesment.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT NOW(3)", nativeQuery = true)
	Timestamp getSysDate();

    @Query(
            value = "SELECT * FROM users u WHERE (:name IS NULL OR u.name LIKE :name)",
            countQuery = "SELECT COUNT(*) " +
                    "FROM users WHERE (:name IS NULL OR u.name LIKE :name)",
            nativeQuery = true
    )
    Page<Users> findAllUsers(String name, Pageable pageable);

}
