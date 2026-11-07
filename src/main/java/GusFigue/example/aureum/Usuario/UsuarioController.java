package GusFigue.example.aureum.Usuario;

import GusFigue.example.aureum.Usuario.DTO.CadastrarUsuarioDTO;
import GusFigue.example.aureum.Usuario.DTO.LoginDTO;
import GusFigue.example.aureum.Usuario.DTO.TokenResponseDTO;
import GusFigue.example.aureum.Usuario.DTO.UsuarioRespostaDTO;
import GusFigue.example.aureum.Usuario.Jwt.AutenticacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioRespostaDTO> cadastrarUsuario(@Valid @RequestBody CadastrarUsuarioDTO dto) {

        UsuarioEntity usuario = usuarioService.cadatrarUsuario(dto);

        UsuarioRespostaDTO usuarioRespostaDTO = new UsuarioRespostaDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAtivo()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRespostaDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> loginUsuario(@Valid @RequestBody LoginDTO dto) {
        TokenResponseDTO responseDTO = autenticacaoService.autenticar(dto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDTO);
    }
}
