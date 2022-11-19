package entidades;

import java.util.List;

public abstract class TurmaI extends RepositoryI<AprendizI> {
   public abstract List<AprendizI> getAprendizes();
}
