package uz.qodirov.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.qodirov.transactionmanagement.entity.Product;

/**
 * @author: Saidjalol Qodirov 2/5/2023 6:58 PM
 */
public interface ProductRepository extends JpaRepository<Product, Long>, BaseRepository {
    boolean existsByName(String name);
}
