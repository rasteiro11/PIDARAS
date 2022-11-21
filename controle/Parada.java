package controle;
import entidades.RodadaI;

/**
 * Parada
 */
public class Parada extends ParadaI
{
    @Override
    public void parar(RodadaI rodada)
    {
        rodada.fim();
    }
}
