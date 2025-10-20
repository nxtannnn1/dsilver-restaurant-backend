package sistema.restaurante.api.mapper;

import org.mapstruct.Mapper;
import sistema.restaurante.api.dto.FuncionarioDTORequest;
import sistema.restaurante.api.dto.FuncionarioDTOResponse;
import sistema.restaurante.domain.model.Funcionario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {
    FuncionarioDTOResponse toDTO(Funcionario funcionario);
    Funcionario toEntity(FuncionarioDTORequest funcionarioDTO);
    List<FuncionarioDTOResponse> toDTO(List<Funcionario> funcionarios);
}
