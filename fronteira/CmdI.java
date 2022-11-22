package fronteira;
import entidades.AprendizI;
import entidades.PerguntaI;
import entidades.TurmaI;

/**
 * CmdI
 */
public abstract class CmdI
{
    public abstract char opcoesUsuario(PerguntaI pergunta, int[] permutacao);
    public abstract void mostarPergunta(PerguntaI pergunta, int[] permutacao);
    public abstract void mostarAprendiz(String mensagem,AprendizI aprendizI);
    public abstract void mostarRespostaCorreta(String resposta, int alternativa);
    public abstract void mostarInformacao(String info);
    public abstract void apresentarResultados(TurmaI turma);
}
