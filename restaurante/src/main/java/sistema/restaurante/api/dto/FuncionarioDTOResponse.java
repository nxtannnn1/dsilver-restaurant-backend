package sistema.restaurante.api.dto;

import sistema.restaurante.domain.enums.Cargo;
import sistema.restaurante.domain.enums.Funcao;

public class FuncionarioDTOResponse {

    private Long id;

    private String nome;

    private Funcao funcao;

    private String email;

    private Double salario;

    private Cargo cargo;
}
