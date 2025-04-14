package orb.com.backend.config.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import orb.com.backend.modules.customer.actions.login.dto.request.CustomerLoginRequest;
import orb.com.backend.modules.customer.actions.login.dto.response.CustomerLoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public CustomerLoginResponse generateJwtToken(CustomerLoginRequest customerLoginRequest) {

        Date jwtCreationDate = new Date();
        Date jwtExpirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);

        String tokenJwt =
                Jwts.builder()
                        .subject(customerLoginRequest.email())
                        .issuedAt(jwtCreationDate)
                        .expiration(jwtExpirationDate)
                        .signWith(getSigningKey())
                        .compact();

        return new CustomerLoginResponse(
                jwtCreationDate,
                jwtExpirationDate,
                "Bearer " + tokenJwt
        );
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }
}
