package uz.qodirov.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.qodirov.transactionmanagement.entity.Offer;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:42 PM
 */
public interface OfferRepository extends JpaRepository<Offer, Long>, BaseRepository {
}
