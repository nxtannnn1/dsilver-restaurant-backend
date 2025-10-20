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
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarios);
    }

}
