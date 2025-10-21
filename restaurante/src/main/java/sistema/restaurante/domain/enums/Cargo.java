package sistema.restaurante.domain.enums;

import lombok.Getter;

@Getter
public enum Cargo {
    GARCOM("Garçom"),
    COZINHEIRO("Cozinheiro"),
    ENTREGADOR("Entregador"),
    GERENTE("Gerente"),
    CAIXA("Caixa");

    private final String descricao;

    Cargo(String descricao){
        this.descricao=descricao;
    }

}
