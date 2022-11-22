package controle;
import java.util.List;
import java.util.Random;

/**
 * Sorteio
 */
public class Sorteio<Tipo> extends SorteioI<Tipo>
{
   Random rnd;
   public Sorteio()
   {
      rnd = new Random();
   }

   @Override
   public Tipo sortearLista(List<Tipo> lista)
   {
      return lista.get(rnd.nextInt(lista.size()));
   }
}
