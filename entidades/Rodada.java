package entidades;
import controle.Sorteio;

public class Rodada implements RodadaI
{
   private TurmaI<AprendizI> historicoAprendizes;
   private TurmaI<AprendizI> turma;
   private boolean ajuda;
   private boolean fim;
   private boolean resposta;
   private AprendizI aprendizAtual;
   private AprendizI ajudante;
   private PerguntaI perguntaAtual;
   private PerguntaI[] batchAtual;
   private int batchPtr;

   public Rodada(QuestionarioI questionario, TurmaI<AprendizI> turma, TurmaI<AprendizI> historicoAprendizes)
   {
      this.turma = turma;
      this.historicoAprendizes = historicoAprendizes;
      this.ajuda = false;
      this.fim = false;
      this.batchPtr = 0;
      this.ajudante = null;
      this.resposta = true;
      this.aprendizAtual = new Sorteio<AprendizI>().sortearLista(this.turma.getAprendizes());

      this.batchAtual = questionario.sortear();
      this.perguntaAtual = batchAtual[batchPtr];
   }

   @Override
   public AprendizI getAprendizAtual()
   {
      return this.aprendizAtual;
   }

   @Override
   public void setAjudante(AprendizI ajudante) {
      this.ajudante = ajudante;   
   }

   @Override
   public Grau getGrauPerguntaAtual()
   {
      return perguntaAtual.getNivel();
   }

   @Override
   public PerguntaI getPerguntaAtual()
   {
      return this.perguntaAtual;
   }

   /*Move to Parada*/
   @Override
   public void fim()
   {
      this.historicoAprendizes.novoAprendiz(aprendizAtual);
      this.turma.removerAprendiz(aprendizAtual);
      this.fim = true;
   }

   @Override
   public void setNextPergunta()
   {
      this.batchPtr++;
      if(this.resposta == false)
      {
         this.setPontuacao(4);
         this.fim();
      }
      else if (this.batchPtr < 3)
      {
         this.setPontuacao(this.perguntaAtual.getNivel().getGrau());
         this.perguntaAtual = this.batchAtual[batchPtr];
      }
      else
      {
         System.out.println("\nTHIS BATCH ENDED\n");
         this.setPontuacao(this.perguntaAtual.getNivel().getGrau());
         this.fim();
      }
   }

   @Override
   public void setRespStatus(boolean status)
   {
      this.resposta = status;
   }
   
   @Override
   public boolean getRespStatus()
   {
      return this.resposta;
   }
   @Override
   public boolean getFim() {
      return this.fim;
   }

   @Override
   public void setFim(boolean bool) {
      this.fim = bool;
   }

   @Override
   public boolean getAjuda(boolean bool) {
      return this.ajuda;
   }

   @Override
   public void setAjuda(boolean bool) {
      this.ajuda = bool;
   }


   private void setPontuacao(int pontuacao)
   {

      int aj_points = 0;
      int ap_points = this.aprendizAtual.getPontuacao();
      if(this.ajudante != null)
      {
         aj_points = this.ajudante.getPontuacao();
         this.ajudante.setPontuacao(aj_points + pontuacao);
         this.ajudante = null;
      }
      this.aprendizAtual.setPontuacao(ap_points + pontuacao);
   }
}
