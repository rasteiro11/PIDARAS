package entidades;

import java.util.List;

public interface RepositoryI<Tipo>
{
   public abstract List<Tipo> carregarArquivo(String fileName);
}
