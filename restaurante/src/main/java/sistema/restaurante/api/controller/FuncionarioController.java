package sistema.restaurante.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistema.restaurante.api.dto.FuncionarioDTORequest;
import sistema.restaurante.application.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping()
    public ResponseEntity cadastrarFuncionario(@Valid @RequestBody FuncionarioDTORequest dto) {
        var funcionario = funcionarioService.cadastrarFuncionario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

}
