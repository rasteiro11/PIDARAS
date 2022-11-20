import java.util.List;

import entidades.Aprendiz;
import entidades.Questionario;
import entidades.Turma;

/**
 * Aplicacao
 */
public class Aplicacao
{
    public static void main(String[] args)
    {
        Turma<Aprendiz> sorteados;
        Turma<Aprendiz> n_sorteados;
        Questionario questoes = new Questionario();
        questoes.carregarArquivo("./controle/Perguntas.txt");
        /*Load from file for Turma and Questionario (should be in controle package)*/
        
    }
}
