package com.devmarquinhos.octo.services;

import com.devmarquinhos.octo.dto.LoginRequest;
import com.devmarquinhos.octo.dto.LoginResponse;
import com.devmarquinhos.octo.repository.UserRepository;
import com.devmarquinhos.octo.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse auth(LoginRequest request) {
        var user = userRepository.findByNome(request.getNome())
                .orElseThrow(() -> new RuntimeException("This user doesn't exists."));

        if (!passwordEncoder.matches(request.getSenha(), user.getSenha())) {
            throw new RuntimeException("Wrong password");
        }

        String token = jwtUtil.generateToken(user.getNome());
        return new LoginResponse(token);
    }
}
