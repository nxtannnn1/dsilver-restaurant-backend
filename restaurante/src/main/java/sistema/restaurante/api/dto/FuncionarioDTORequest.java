package sistema.restaurante.api.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import sistema.restaurante.domain.enums.Cargo;
import sistema.restaurante.domain.enums.Funcao;

@Data
public class FuncionarioDTORequest {

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

    @NotNull(message = "Salário não pode ser nulo!")
    @Min(value = 1200)
    private Double salario;

    @NotNull(message = "Cargo não pode ser nulo!")
    private Cargo cargo;
}
