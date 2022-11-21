package controle;

import entidades.RodadaI;
import entidades.TurmaI;
import fronteira.CmdI;

/**
 * AjudaI
 */
public abstract class AjudaI
{
    public abstract boolean pedirAjuda(TurmaI turma, RodadaI rodada, CmdI tela);
}
