package controle;
import java.util.List;

public abstract class SorteioI<Tipo>
{
   public abstract Tipo sortear(List<Tipo> lista);
}
