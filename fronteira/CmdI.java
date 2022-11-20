package fronteira;
import entidades.PerguntaI;

/**
 * CmdI
 */
public abstract class CmdI<P extends PerguntaI>
{
    /*
     * respostaUsuario: 
     * Pre:
     * Post:
     * */
    protected abstract char respostaUsuario();
    public abstract char mostrarOpcoes(P pergunta, int[] permutacao);
}
