package orb.com.backend.config.security.user.models;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LoginUser implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private final UUID id;

    private final String email;
    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    public LoginUser(UUID id, String email, String password) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;

        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");

        this.authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
