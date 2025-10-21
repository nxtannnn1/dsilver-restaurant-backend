package sistema.restaurante.domain.model;

import jakarta.persistence.Entity;
import lombok.Data;
import sistema.restaurante.domain.enums.Categoria;
import sistema.restaurante.domain.enums.Disponibilidade;

@Entity
@Data
public class Prato {
    private Long id;
    private String nome;
    private Double preco;
    private Categoria categoria;
    private String urlImagem;
    private String descricao;
    private Ingredientes ingredientes;
    private Disponibilidade disponibilidade;

}
