import controle.Sorteio;
import entidades.Aprendiz;
import entidades.Pergunta;
import entidades.Questionario;
import entidades.Turma;
import fronteira.Cmd;

/**
 * Aplicacao
 */
public class Aplicacao
{
    public static void main(String[] args)
    {
        Turma sorteados = new Turma();
        Turma n_sorteados = null;
        Questionario questoes = new Questionario();
        questoes.carregarArquivo("./arquivos/Perguntas.txt");
        sorteados.carregarArquivo("./arquivos/Turma.txt");
        Sorteio<Aprendiz> sorteio_a = new Sorteio<>();
        Sorteio<Pergunta> sorteio_p = new Sorteio<>();

        /*Mostar Tela com comandos*/
        Cmd tela = new Cmd();
    }
}
