package GusFigue.example.aureum.Usuario;

import GusFigue.example.aureum.Usuario.DTO.CadastrarUsuarioDTO;
import GusFigue.example.aureum.Usuario.DTO.UsuarioRespostaDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioEntity cadatrarUsuario(CadastrarUsuarioDTO dto) {

        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException( //Criar tratamento personalizado depois
                    "E-mail já cadastrado"
            );
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setNome(dto.nome());
        usuarioEntity.setEmail(dto.email());
        usuarioEntity.setSenha(passwordEncoder.encode(dto.senha()));
        usuarioEntity.setAtivo(true);

        return usuarioRepository.save(usuarioEntity);
    }
}
