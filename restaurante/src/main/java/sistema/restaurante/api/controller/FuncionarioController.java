package sistema.restaurante.api.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.restaurante.api.dto.FuncionarioDTORequest;
import sistema.restaurante.api.dto.FuncionarioDTOResponse;
import sistema.restaurante.application.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTOResponse> cadastrarFuncionario(@Valid @RequestBody FuncionarioDTORequest dto) {
        var funcionario = funcionarioService.cadastrarFuncionario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTOResponse>> listarFuncionarios(Pageable pageable) {
        var funcionarios = funcionarioService.listarFuncionarios(pageable).getContent();
        return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTOResponse> listarFuncionarioPorId(@PathVariable Long id) {
        var funcionario = funcionarioService.listarFuncionarioPorId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable @Valid Long id) {
        funcionarioService.excluirFuncionarioPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void>excluirTodosOsFuncionarios(){
        funcionarioService.excluirTodosOsFuncionarios();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTOResponse> editarFuncionarioPorId(@PathVariable Long id, @RequestBody @Valid FuncionarioDTORequest dto){
        var funcionario = funcionarioService.editarFuncionarioPorId(id,dto);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

}
