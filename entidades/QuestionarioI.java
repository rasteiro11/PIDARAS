package entidades;
import java.util.List;

public interface QuestionarioI extends RepositoryI<PerguntaI>
{
   List<PerguntaI> getPerguntas();
}
