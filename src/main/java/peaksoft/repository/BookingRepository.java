package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
