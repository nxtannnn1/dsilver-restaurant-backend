package sistema.restaurante.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import sistema.restaurante.domain.enums.Cargo;

@Data
public class Funcionario extends Usuario {
    @NotNull(message = "Salário não pode ser nulo!")
    @Min(value = 1200)
    private Double salario;
    @NotNull(message = "Cargo não pode ser nulo!")
    private Cargo cargo;
}
