package uz.qodirov.transactionmanagement.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import uz.qodirov.transactionmanagement.repository.UserRepository;

/**
 * @author: Saidjalol Qodirov 2/4/2023 8:31 PM
 */
//@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
