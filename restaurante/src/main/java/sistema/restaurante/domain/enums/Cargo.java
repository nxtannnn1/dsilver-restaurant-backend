package sistema.restaurante.domain.enums;

public enum Cargo {
    GARCOM("Garçom"),
    CAIXA("Caixa");

    private final String descricao;

    Cargo(String descricao){
        this.descricao=descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
