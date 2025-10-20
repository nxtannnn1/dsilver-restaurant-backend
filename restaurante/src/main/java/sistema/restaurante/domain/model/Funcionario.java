package sistema.restaurante.domain.model;

import lombok.Data;
import sistema.restaurante.domain.enums.Cargo;

@Data
public class Funcionario extends Usuario{
    private Double salario;
    private Cargo cargo;
}
