package entidades;
import java.util.List;

public interface TurmaI extends RepositoryI<AprendizI>
{
   List<AprendizI> getAprendizes();
}
