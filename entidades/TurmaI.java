package entidades;

import java.util.List;

public abstract class TurmaI implements RepositoryI<AprendizI>
{
   public abstract AprendizI acharAprendiz(String ra);
   public abstract void novoAprendiz(AprendizI aprendiz);
   public abstract void removerAprendiz(AprendizI aprendiz);
   public abstract List<AprendizI> getAprendizes();
}
