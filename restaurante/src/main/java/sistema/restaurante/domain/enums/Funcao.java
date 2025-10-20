package sistema.restaurante.domain.enums;

import lombok.Getter;

@Getter
public enum Funcao {

    COMUM("Comum"),
    FUNCIONARIO("Funcionário");

    private final String descricao;

    Funcao (String descricao) {
        this.descricao = descricao;
    }

}
