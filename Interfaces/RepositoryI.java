import java.util.List;

interface RepositoryI<Tipo>
{
   List<Tipo> findAll();
}
