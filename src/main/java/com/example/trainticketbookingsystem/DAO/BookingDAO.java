package com.example.trainticketbookingsystem.DAO;

import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingDAO extends JpaRepository<BookingEntity,String> {
    @Query(value = "SELECT * FROM booking WHERE booking_id = (SELECT booking_id FROM booking ORDER BY CAST(SUBSTRING(booking_id, 12) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    BookingEntity findLastRowNative();
    List<BookingEntity> findByUser(UserEntity user);

    // You might also want these additional helpful methods:

    // Find bookings by user and status (e.g., PENDING, CONFIRMED, CANCELLED)
}
