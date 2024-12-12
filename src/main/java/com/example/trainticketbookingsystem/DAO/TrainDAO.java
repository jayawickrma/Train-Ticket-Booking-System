package com.example.trainticketbookingsystem.DAO;

import com.example.trainticketbookingsystem.Entity.IMPL.TrainEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDAO extends JpaRepository<TrainEntity,String> {
    @Query(value = "SELECT * FROM train WHERE train_id = (SELECT train_id FROM user ORDER BY CAST(SUBSTRING(train_id, 7) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    UserEntity findLastRowNative();
}
