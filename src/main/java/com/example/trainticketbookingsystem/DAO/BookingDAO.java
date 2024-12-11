package com.example.trainticketbookingsystem.DAO;

import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDAO extends JpaRepository<BookingEntity,String> {
}
