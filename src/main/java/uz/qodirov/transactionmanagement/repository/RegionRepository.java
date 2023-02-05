package uz.qodirov.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.qodirov.transactionmanagement.entity.Region;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:51 AM
 */
public interface RegionRepository extends JpaRepository<Region, Long>, BaseRepository {

    boolean existsByName(String name);

    @Query(nativeQuery = true, value = "select * from region order by name")
    List<Region> getAll();

    @Query(nativeQuery = true, value = "select * from region where not deleted and id in :regionIds")
    List<Region> findByIds(HashSet<Long> regionIds);

    Optional<Region> findByName(String name);
}
