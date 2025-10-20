package sistema.restaurante.domain.enums;

import lombok.Getter;

@Getter
public enum Cargo {
    GARCOM("Garçom"),
    CAIXA("Caixa");

    private final String descricao;

    Cargo(String descricao){
        this.descricao=descricao;
    }

}
