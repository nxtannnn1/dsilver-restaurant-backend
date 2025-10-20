package sistema.restaurante.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.restaurante.domain.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
