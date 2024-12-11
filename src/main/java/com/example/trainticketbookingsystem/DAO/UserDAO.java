package com.example.trainticketbookingsystem.DAO;

import com.example.trainticketbookingsystem.Entity.IMPL.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {
}
