package uz.qodirov.transactionmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.qodirov.transactionmanagement.dto.auth.LoginDTO;
import uz.qodirov.transactionmanagement.dto.auth.RegisterDTO;
import uz.qodirov.transactionmanagement.services.AuthService;
import uz.qodirov.transactionmanagement.utils.JWTUtils;

import javax.validation.Valid;

/**
 * @author: Saidjalol Qodirov 2/4/2023 11:36 PM
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final AuthenticationManager authenticationManager;

    private final JWTUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials", e);
        }

        final UserDetails userDetails = authService.loadUserByUsername(dto.getUsername());

        final String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO dto) {
        return authService.register(dto);
    }
}
