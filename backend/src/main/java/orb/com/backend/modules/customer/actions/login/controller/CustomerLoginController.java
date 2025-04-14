package orb.com.backend.modules.customer.actions.login.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import orb.com.backend.config.security.jwt.JwtService;
import orb.com.backend.modules.customer.actions.login.dto.request.CustomerLoginRequest;
import orb.com.backend.modules.customer.actions.login.dto.response.CustomerLoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orb/auth")
@RequiredArgsConstructor
public class CustomerLoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public CustomerLoginResponse login(@Valid @RequestBody CustomerLoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        return jwtService.generateJwtToken(loginRequest);
    }
}