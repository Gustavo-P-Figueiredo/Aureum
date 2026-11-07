package GusFigue.example.aureum.Usuario.Jwt;

import GusFigue.example.aureum.Usuario.DTO.LoginDTO;
import GusFigue.example.aureum.Usuario.DTO.TokenResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public TokenResponseDTO autenticar(LoginDTO dto) {

        Authentication autenticacao = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.email(),
                        dto.senha()
                )
        );

        String token = jwtService.gerarToken(autenticacao.getName());

        return new TokenResponseDTO(token, "Bearer");
    }
}
