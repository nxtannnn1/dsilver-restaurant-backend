package sistema.restaurante.application.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sistema.restaurante.api.dto.FuncionarioDTORequest;
import sistema.restaurante.api.dto.FuncionarioDTOResponse;
import sistema.restaurante.api.mapper.FuncionarioMapper;
import sistema.restaurante.infrastructure.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioMapper funcionarioMapper;
    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;

    public FuncionarioService(FuncionarioMapper funcionarioMapper, FuncionarioRepository funcionarioRepository, PasswordEncoder passwordEncoder) {
        this.funcionarioMapper = funcionarioMapper;
        this.passwordEncoder = passwordEncoder;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public FuncionarioDTOResponse cadastrarFuncionario(FuncionarioDTORequest dto) {
        var achado = funcionarioMapper.toEntity(dto);
        var funcionario = funcionarioRepository.save(achado);
        return funcionarioMapper.toDTO(funcionario);
    }

    @Transactional
    public Page<FuncionarioDTOResponse> listarFuncionarios(Pageable pageable) {
        return funcionarioRepository.findAll(pageable).map(funcionarioMapper::toDTO);
    }

    public FuncionarioDTOResponse listarFuncionarioPorId(Long id) {
        if (id == null) throw new RuntimeException("ID não pode ser nulo");
        var funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi encontrado um funcionário de id " + id + "!"));
        return funcionarioMapper.toDTO(funcionario);
    }

    @Transactional
    public FuncionarioDTOResponse editarFuncionarioPorId(Long id, FuncionarioDTORequest dto) {
        if (id == null) throw new RuntimeException("ID não pode ser nulo");
        var achado = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi encontrado um funcionário de id " + id + "!"));
        String hash = passwordEncoder.encode(dto.getSenha());
        achado.setNome(dto.getNome());
        achado.setFuncao(dto.getFuncao());
        achado.setEmail(dto.getEmail());
        achado.setSenha(hash);
        achado.setSalario(dto.getSalario());
        achado.setCargo(dto.getCargo());

        return funcionarioMapper.toDTO(achado);
    }

    @Transactional
    public void excluirFuncionarioPorId(Long id) {
        if (id == null) throw new RuntimeException("ID não pode ser nulo");
        var funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi encontrado um funcionário de id " + id + "!"));
        funcionarioRepository.delete(funcionario);

    }

    @Transactional
    public void excluirTodosOsFuncionarios() {
        funcionarioRepository.deleteAll();
    }


}
