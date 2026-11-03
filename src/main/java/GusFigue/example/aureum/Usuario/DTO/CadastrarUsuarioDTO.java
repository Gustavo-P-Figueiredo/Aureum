package GusFigue.example.aureum.Usuario.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastrarUsuarioDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Informe um e-mail válido")
                String email,

        @NotBlank(message = "A senha é obrigatória")
        String senha
) {}
