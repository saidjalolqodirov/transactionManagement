package uz.qodirov.transactionmanagement.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.auth.RegisterDTO;
import uz.qodirov.transactionmanagement.entity.Users;
import uz.qodirov.transactionmanagement.mapper.UserMapper;
import uz.qodirov.transactionmanagement.repository.RegionRepository;
import uz.qodirov.transactionmanagement.repository.UserRepository;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:24 AM
 */
@Service
public class AuthService extends AbstractService<UserRepository, UserMapper> implements UserDetailsService {

    private final RegionRepository regionRepository;

    private final UserRepository userRepository;

    protected AuthService(UserRepository repository, UserMapper mapper, RegionRepository regionRepository, UserRepository userRepository) {
        super(repository, mapper);
        this.regionRepository = regionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username).orElseGet(Users::new);
    }

    public ResponseEntity<?> register(RegisterDTO dto) {
        if (repository.existsByUsernameOrPhoneNumber(dto.getUsername(), dto.getPhoneNumber()))
            return new ResponseEntity<>("this username or this phone already exist", HttpStatus.BAD_REQUEST);
        if (!regionRepository.existsById(dto.getRegionId())) {
            return new ResponseEntity<>("region not found", HttpStatus.BAD_REQUEST);
        }
        Users users = mapper.fromRegisterDTO(dto);
        Users save = repository.save(users);
        return ResponseEntity.ok(mapper.toDto(save));
    }
}
