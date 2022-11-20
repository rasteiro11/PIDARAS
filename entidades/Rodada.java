package entidades;

import java.util.List;
import java.util.Random;

import controle.Sorteio;

public class Rodada implements RodadaI {

   private QuestionarioI questionario;
   private TurmaI<AprendizI> turma;
   private boolean ajuda;
   private boolean desistir;
   private boolean parar;
   private List<PerguntaI> historicoPerguntas;
   private List<AprendizI> historicoAprendizes;
   private AprendizI aprendizAtual;
   private AprendizI ajudante;
   private PerguntaI perguntaAtual;
   private PerguntaI[] batchAtual;
   private int batchPtr;

   public Rodada(QuestionarioI questionario, TurmaI<AprendizI> turma, List<PerguntaI> historicoPerguntas,
         List<AprendizI> historicoAprendizes) {
      this.questionario = questionario;
      this.turma = turma;
      this.historicoPerguntas = historicoPerguntas;
      this.historicoAprendizes = historicoAprendizes;
      this.ajuda = false;
      this.desistir = false;
      this.parar = false;
      this.batchPtr = 0;

      this.aprendizAtual = new Sorteio<AprendizI>().sortear(this.turma.getAprendizes());
      this.historicoAprendizes.add(this.aprendizAtual);

      // WARNINIG: DIVIDE INTO TWO LISTS(ALREADY SORTED AND NOT SORTED) IN APPLICATION
      this.batchAtual = questionario.sortear(this.historicoPerguntas);
      this.perguntaAtual = batchAtual[batchPtr];
      batchPtr++;
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
      Random r = new Random();
      int rand;
      AprendizI aprendizTemp;

      if (this.ajuda == false) {
         do {
            rand = r.nextInt(this.turma.getAprendizes().size());
            aprendizTemp = this.turma.getAprendizes().get(rand);
         } while (this.historicoAprendizes.contains(aprendizTemp));
         this.ajudante = aprendizTemp;
         this.aprendizAtual = this.ajudante;
      }
      this.ajuda = true;
   }

   @Override
   public void desistir() {
      // Auto-generated method stub
      this.desistir = true;
      this.parar = true;
   }

   @Override
   public void getNextPergunta() {
      // Auto-generated method stub
      if (this.batchPtr < 3) {
         this.batchPtr++;
         this.perguntaAtual = this.batchAtual[batchPtr];
      } else {
         this.parar();
      }
   }

   @Override
   public void parar() {
      this.parar = true;
   }

   @Override
   public boolean getParar() {
      return this.parar;
   }
}
