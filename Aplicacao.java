import java.util.List;

import entidades.Aprendiz;
import entidades.Questionario;
import entidades.Turma;

/**
 * Aplicacao
 */
public class Aplicacao {
    public static void main(String[] args) {
        Turma sorteados;
        Turma n_sorteados;
        Questionario questoes = new Questionario("./controle/Perguntas.txt");
        questoes.carregarArquivo("./controle/Perguntas.txt");
        /* Load from file for Turma and Questionario (should be in controle package) */

    }
}
