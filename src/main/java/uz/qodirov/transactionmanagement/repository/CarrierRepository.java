package uz.qodirov.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.qodirov.transactionmanagement.entity.Carrier;

import java.util.List;
import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 5:02 PM
 */
public interface CarrierRepository extends JpaRepository<Carrier, Long>, BaseRepository {

    @Query(nativeQuery = true, value = "select * from carrier c inner join carrier_regions cr on c.id = cr.carrier_list_id and cr.regions_id = 1 order by c.first_name")
    List<Carrier> findCarriersByRegionId(Long id);

    Optional<Carrier> findByCarrierName(String carrierName);
}
