package uz.qodirov.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.qodirov.transactionmanagement.entity.Request;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:08 PM
 */
public interface RequestRepository extends JpaRepository<Request, Long>, BaseRepository {
}
