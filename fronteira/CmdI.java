package fronteira;
import entidades.AprendizI;
import entidades.PerguntaI;

/**
 * CmdI
 */
public abstract class CmdI<P extends PerguntaI>
{
    public abstract char opcoesUsuario(P pergunta, int[] permutacao);
    public abstract void monstarAprendiz(AprendizI aprendizI);
}
