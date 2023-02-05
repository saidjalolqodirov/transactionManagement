package uz.qodirov.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.qodirov.transactionmanagement.dto.carrier.CarrierScoreSumDTO;
import uz.qodirov.transactionmanagement.dto.product.ProductStatisticsDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionStatisticsDTO;
import uz.qodirov.transactionmanagement.entity.Transaction;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/5/2023 8:18 PM
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long>, BaseRepository {
    boolean existsByOfferIdOrRequestId(Long offerId, Long requestId);

    @Query(nativeQuery = true, value = "select count(*) from carrier_regions cr where carrier_list_id = 1 and regions_id in :asList")
    int withinTheService(List<Long> asList);

    @Query(nativeQuery = true,value = "select t.carrier_id as carrierId, sum(t.score) as sumScore from transaction t group by t.carrier_id;")
    List<CarrierScoreSumDTO> getSumScore();

    @Query(nativeQuery = true,value = "select product_id as productId, count(o.product_id) as transactionCount  from transaction t inner join offer o on o.id = t.offer_id group by o.product_id")
    List<ProductStatisticsDTO> nTPerProduct();

    @Query(nativeQuery = true,value = "select p.region_id as regionId, count(p.region_id) as transactionCount  from transaction t inner join offer o on o.id = t.offer_id inner join place p on p.id = o.place_id group by p.region_id")
    List<RegionStatisticsDTO> deliveryRegionsPerNT();
}
