import java.util.List;

public interface TurmaI extends SorteavelI<AprendizI>, RepositoryI<AprendizI>
{
   List<AprendizI> getAprendizes();
}
