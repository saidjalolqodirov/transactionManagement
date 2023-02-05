package uz.qodirov.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.qodirov.transactionmanagement.entity.Place;

import java.util.List;
import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:40 AM
 */
public interface PlaceRepository extends JpaRepository<Place, Long>, BaseRepository {
    boolean existsByName(String name);

    List<Place> findAllByRegionIdAndDeletedFalseOrderByNameAsc(Long regionId);

    List<Place> findAllByDeletedFalseOrderByName();

    Optional<Place> findByName(String placeName);
}
