package entidades;
import java.util.List;

public abstract class QuestionarioI extends RepositoryI<PerguntaI>
{
   public abstract List<PerguntaI> getPerguntas();
   public abstract PerguntaI[] sortear();
}
