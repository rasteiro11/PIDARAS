package controle;
import entidades.AprendizI;
import entidades.RodadaI;
import entidades.TurmaI;
import fronteira.CmdI;

/**
 * Ajuda
 */
public class Ajuda extends AjudaI
{

    @Override
    public boolean pedirAjuda(TurmaI turma, RodadaI rodada, CmdI tela)
    {
        Sorteio<AprendizI> sorteio = new Sorteio<>();
        AprendizI ajudante = null;
        if(turma.getAprendizes().size() > 0)
        {
            ajudante = sorteio.sortearLista(turma.getAprendizes());
            rodada.setAjudante(ajudante);
            rodada.setAjuda(true);
            return true;
        }
        else
            tela.mostarInformacao("Nao ha mais alunos para ajudar");
        return false;
    }
}
