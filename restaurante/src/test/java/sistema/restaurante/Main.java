package sistema.restaurante;

import sistema.restaurante.domain.model.Funcionario;

public class Main {
    public static void main(String[] args) {
        Funcionario usuario1 = new Funcionario();
        usuario1.setNome("Mario");
        System.out.println(usuario1.getNome());
    }
}
