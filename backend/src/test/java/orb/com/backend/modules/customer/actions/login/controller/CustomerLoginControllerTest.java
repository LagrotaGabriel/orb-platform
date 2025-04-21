package orb.com.backend.modules.customer.actions.login.controller;

import orb.com.backend.config.security.jwt.JwtService;
import orb.com.backend.modules.customer.actions.login.dto.request.CustomerLoginRequest;
import orb.com.backend.modules.customer.actions.login.dto.request.mock.CustomerLoginRequestMock;
import orb.com.backend.modules.customer.actions.login.dto.response.CustomerLoginResponse;
import orb.com.backend.modules.customer.actions.login.dto.response.mock.CustomerLoginResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Controller: CustomerLogin")
class CustomerLoginControllerTest {

    @InjectMocks
    CustomerLoginController customerLoginController;

    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    JwtService jwtService;

    @Test
    @DisplayName("Should test successful login")
    void shouldTestSuccessfulLogin() {

        CustomerLoginResponse expectedResponse = CustomerLoginResponseMock.builder().build();
        CustomerLoginRequest customerLoginRequest = CustomerLoginRequestMock.builder().build();

        when(authenticationManager.authenticate(any())).thenReturn(null);

        when(jwtService.generateJwtToken(customerLoginRequest)).thenReturn(expectedResponse);

        CustomerLoginResponse loginResponse = customerLoginController.login(customerLoginRequest);

        Assertions.assertEquals(
                expectedResponse,
                loginResponse
        );
    }
}
