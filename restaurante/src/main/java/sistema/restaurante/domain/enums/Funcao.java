package sistema.restaurante.domain.enums;

public enum Funcao {

    COMUM("Comum"),
    FUNCIONARIO("Funcionário");

    private final String descricao;

    Funcao (String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
