package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.model.House;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {
    List<House>getHousesByAgencyId(Long id);
    @Query("select a from House a order by a.houseType desc ")
    List<House>sortDesc();
    @Query("select a from House a order by a.houseType asc ")
    List<House>sortAsc();
}
