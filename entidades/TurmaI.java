package entidades;

public abstract class TurmaI<Aluno extends AprendizI> extends RepositoryI<Aluno>
{
   public abstract Aluno acharAprendiz(String ra);
   public abstract void novoAprendiz(Aluno aprendiz);
}
