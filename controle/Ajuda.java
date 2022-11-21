package controle;
import entidades.AprendizI;
import entidades.RodadaI;
import entidades.TurmaI;

/**
 * Ajuda
 */
public class Ajuda extends AjudaI
{

    @Override
    public void pedirAjuda(TurmaI<AprendizI> turma, RodadaI rodada)
    {
        Sorteio<AprendizI> sorteio = new Sorteio<>();
        AprendizI ajudante = null;
        if(turma.getAprendizes().size() > 0)
        {
            ajudante = sorteio.sortearLista(turma.getAprendizes());
            rodada.setAjudante(ajudante);
            rodada.setAjuda(true);
        }
    }
}
