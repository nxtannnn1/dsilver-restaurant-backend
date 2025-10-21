package sistema.restaurante.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sistema.restaurante.domain.enums.Cargo;
import sistema.restaurante.domain.model.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Page<Funcionario> findAllByCargo(Pageable pageable, Optional<Cargo> cargo);
}
