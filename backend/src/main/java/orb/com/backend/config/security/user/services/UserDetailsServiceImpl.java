package orb.com.backend.config.security.user.services;

import lombok.RequiredArgsConstructor;
import orb.com.backend.config.security.user.models.LoginUser;
import orb.com.backend.modules.customer.models.entity.CustomerEntity;
import orb.com.backend.modules.customer.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<CustomerEntity> customer = customerRepository.findByEmail(email);

        if (customer.isPresent()) {
            return new LoginUser(
                    customer.get().getId(),
                    customer.get().getEmail(),
                    customer.get().getPassword()
            );
        }
        throw new UsernameNotFoundException("User not found");
    }
}