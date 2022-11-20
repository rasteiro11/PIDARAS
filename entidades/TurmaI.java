package entidades;

import java.util.List;

public abstract class TurmaI<Aluno extends AprendizI> extends RepositoryI<Aluno> {
   public abstract Aluno acharAprendiz(String ra);

   public abstract void novoAprendiz(Aluno aprendiz);

   public abstract List<Aluno> getAprendizes();
}
