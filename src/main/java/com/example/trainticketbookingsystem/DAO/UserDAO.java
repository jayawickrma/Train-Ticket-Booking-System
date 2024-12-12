package com.example.trainticketbookingsystem.DAO;

import com.example.trainticketbookingsystem.Entity.IMPL.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {
    @Query(value = "SELECT * FROM user WHERE userId = (SELECT userId FROM crop ORDER BY CAST(SUBSTRING(userId, 6) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    UserEntity findLastRowNative();
}
