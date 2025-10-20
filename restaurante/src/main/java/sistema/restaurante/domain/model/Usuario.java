package sistema.restaurante.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import sistema.restaurante.domain.enums.Funcao;

@Data
abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode estar vazio")
    @Size(min = 6, max = 20, message = "Nome deve possuir entre 6 e 20 caracteres!")
    private String nome;

    @NotNull(message = "Função não pode ser nula")
    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @NotBlank(message = "Email não pode estar vazio")
    @Email
    private String email;

    @NotBlank(message = "Senha não pode estar vazia")
    @Size(min = 6, max = 20, message = "Senha deve possuir entre 6 e 20 caracteres!")
    private String senha;
}
