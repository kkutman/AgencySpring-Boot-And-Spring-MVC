package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.Agency;

import java.util.List;

@Repository
public interface AgencyRepository  extends JpaRepository<Agency,Long> {

    List<Agency>searchAgenciesByNameAndCountry(String name, String country);
}
