import java.util.List;

public interface RodadaI
{
   List<PerguntaI> getPerguntas();
   List<PerguntaI> getHistoricoDePerguntas();
   List<AprendizI> getHistoricoDeAprendizes();
   AprendizI getAprendizAtual();
   void setAprendizAtual(AprendizI a);
   PerguntaI getPerguntaAtual();
   void setPerguntaAtual(PerguntaI p);
   Grau getGrauPerguntaAtual();
}
