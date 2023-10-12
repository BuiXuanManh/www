package iuh.fit.week5.repositories;

import iuh.fit.week5.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query("select a.countryCode from Address a where a.id = :id")
    String getCountryCode(@Param("id") Long id);
}
