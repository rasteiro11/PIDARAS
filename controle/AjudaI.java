package controle;

import entidades.AprendizI;
import entidades.RodadaI;
import entidades.TurmaI;

/**
 * AjudaI
 */
public abstract class AjudaI
{
    public abstract void pedirAjuda(TurmaI<AprendizI> turma, RodadaI rodada);
}
