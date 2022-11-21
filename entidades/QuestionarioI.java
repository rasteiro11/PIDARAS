package entidades;
import java.util.List;

public abstract class QuestionarioI implements RepositoryI<PerguntaI>
{
   public abstract List<PerguntaI> getPerguntas();
   public abstract PerguntaI[] sortear();
}
