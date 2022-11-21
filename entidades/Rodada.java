package entidades;

public class Rodada extends RodadaI
{
   private boolean ajuda;
   private boolean fim;
   private boolean resposta;
   private AprendizI aprendizAtual;
   private AprendizI ajudante;
   private PerguntaI perguntaAtual;
   private PerguntaI[] batchAtual;
   private int batchPtr;

   public Rodada(QuestionarioI questionario, TurmaI turma, TurmaI historicoSorteados, AprendizI sorteado)
   {
      this.ajuda = false;
      this.fim = sorteado.estaPresente();
      this.batchPtr = 0;
      this.ajudante = null;
      this.resposta = true;

      this.aprendizAtual = sorteado;
      historicoSorteados.novoAprendiz(aprendizAtual);
      turma.removerAprendiz(aprendizAtual);

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
   public AprendizI getAjudante()
   {
      return this.ajudante;
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
   public boolean getAjuda() {
      return this.ajuda;
   }

   @Override
   public void setAjuda(boolean bool) {
      this.ajuda = bool;
   }

   @Override
   public void setNextPergunta()
   {
      this.batchPtr++;
      if(this.resposta == false)
      {
         this.setPontuacao(4);
         this.setFim(true);
      }
      else if (this.batchPtr < 3)
      {
         this.setPontuacao(this.perguntaAtual.getNivel().getGrau());
         this.perguntaAtual = this.batchAtual[batchPtr];
      }
      else
      {
         this.setPontuacao(this.perguntaAtual.getNivel().getGrau());
         this.setFim(true);
      }
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
         this.ajuda = false;
      }
      this.aprendizAtual.setPontuacao(ap_points + pontuacao);
   }
}
