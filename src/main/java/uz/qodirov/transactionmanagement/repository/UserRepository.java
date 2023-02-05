package uz.qodirov.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.qodirov.transactionmanagement.entity.Users;

import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:35 AM
 */
public interface UserRepository extends JpaRepository<Users, Long>, BaseRepository {

    boolean existsByUsernameOrPhoneNumber(String username, String phoneNumber);

    Optional<Users> findByUsername(String username);
}
