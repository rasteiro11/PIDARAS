import java.util.List;

public interface Rodada {
   List<Pergunta> getPerguntas();

   List<Pergunta> getHistoricoDePerguntas();

   List<Aprendiz> getHistoricoDeAprendizes();

   Aprendiz getAprendizAtual();

   void setAprendizAtual(Aprendiz a);

   Pergunta getPerguntaAtual();

   void setPerguntaAtual(Pergunta p);

   Grau getGrauPerguntaAtual();

}
