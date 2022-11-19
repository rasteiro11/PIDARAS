import java.util.List;

public interface QuestionarioI extends SorteavelI<PerguntaI>, RepositoryI<PerguntaI>
{
   List<PerguntaI> getPerguntas();
}
