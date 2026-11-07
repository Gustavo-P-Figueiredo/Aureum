package GusFigue.example.aureum.Usuario.Jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {
    private final Algorithm algorithm;
    private final String issuer;
    private final long expirationSeconds;

    public JwtService(
            @Value("${aureum.jwt.secret}") String secret,
            @Value("${aureum.jwt.issuer}") String issuer,
            @Value("${aureum.jwt.expiration-seconds}") long expirationSeconds) {
     this.algorithm = Algorithm.HMAC256(secret);
     this.issuer = issuer;
     this.expirationSeconds = expirationSeconds;
    }

    public String gerarToken(String email) {
        Instant now = Instant.now();

        return JWT.create()
                .withIssuer(issuer)
                .withSubject(email)
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(now.plusSeconds(expirationSeconds)))
                .sign(algorithm);
    }

    public String validarToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);

            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception) {
            return "Erro ao recuperar Token";
        }
    }

    public boolean tokenValido(String token) {
        return validarToken(token) != null;
    }


}
