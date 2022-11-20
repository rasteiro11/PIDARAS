import controle.Sorteio;
import entidades.Aprendiz;
import entidades.Pergunta;
import entidades.Questionario;
import entidades.Turma;
import fronteira.Cmd;

/**
 * Aplicacao
 */
public class Aplicacao {
    public static void main(String[] args) {
        Turma sorteados;
        Turma n_sorteados;
        Questionario questoes = new Questionario("./arquivos/Perguntas.txt");
        questoes.carregarArquivo("./arquivos/Perguntas.txt");
        /* Load from file for Turma and Questionario (should be in controle package) */

    }
}
