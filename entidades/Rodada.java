package entidades;

import java.util.List;

public class Rodada implements RodadaI {

   private QuestionarioI questionario;
   private TurmaI<AprendizI> turma;
   private boolean ajuda;
   private boolean desistir;
   private List<PerguntaI> historicoPerguntas;
   private List<AprendizI> historicoAprendizes;
   private AprendizI aprendizAtual;
   private PerguntaI perguntaAtual;

   public Rodada(QuestionarioI questionario, TurmaI<AprendizI> turma) {
      this.questionario = questionario;
      this.turma = turma;
      this.ajuda = false;
      this.desistir = false;
   }

   @Override
   public AprendizI getAprendizAtual() {
      // Auto-generated method stub
      return this.aprendizAtual;
   }

   @Override
   public Grau getGrauPerguntaAtual() {
      // Auto-generated method stub
      return perguntaAtual.getNivel();
   }

   @Override
   public List<AprendizI> getHistoricoDeAprendizes() {
      // Auto-generated method stub
      return this.historicoAprendizes;
   }

   @Override
   public List<PerguntaI> getHistoricoDePerguntas() {
      // Auto-generated method stub
      return this.historicoPerguntas;
   }

   @Override
   public PerguntaI getPerguntaAtual() {
      // Auto-generated method stub
      return this.perguntaAtual;
   }

   @Override
   public List<PerguntaI> getPerguntas() {
      // Auto-generated method stub
      return this.questionario.getPerguntas();
   }

   @Override
   public void setAprendizAtual(AprendizI a) {
      // Auto-generated method stub
      this.aprendizAtual = a;
   }

   @Override
   public void setPerguntaAtual(PerguntaI p) {
      // Auto-generated method stub
      this.perguntaAtual = p;

   }

   @Override
   public void pedirAjuda() {
      // Auto-generated method stub
      this.ajuda = true;
   }

   @Override
   public void desistir() {
      // Auto-generated method stub
      this.desistir = true;
   }
}
