package entidades;

import java.util.List;

import controle.SorteavelI;

public abstract class QuestionarioI extends RepositoryI<PerguntaI> implements SorteavelI<PerguntaI> {
   public abstract List<PerguntaI> getPerguntas();
}
