package entidades;

import java.util.List;

public abstract class RepositoryI<Tipo> {
   public abstract List<Tipo> findAll();
}
