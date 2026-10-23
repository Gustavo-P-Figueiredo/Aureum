package GusFigue.example.aureum.Usuario;

import GusFigue.example.aureum.Usuario.DTO.CadastrarUsuarioDTO;
import GusFigue.example.aureum.Usuario.DTO.UsuarioRespostaDTO;
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

}
