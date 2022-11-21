package entidades;

public class Pergunta extends PerguntaI
{
   private Grau nivel;
   private String enunciado;
   private AlternativaI[] alternativas;
   private String tema;

   public Pergunta() {
      this.alternativas = new Alternativa[4];
   }

   @Override
   public void setAlternativas(AlternativaI alternativa, int index) {
      if (index < 3) {
         this.alternativas[index] = alternativa;
      }
   }

   @Override
   public AlternativaI[] getAlternativas() {
      return alternativas;
   }

   @Override
   public String getEnunciado() {
      return this.enunciado;
   }

   @Override
   public Grau getNivel() {
      return this.nivel;
   }

   @Override
   public AlternativaI getResponsta() {
      return alternativas[0];
   }

   @Override
   public String getTema() {
      return this.tema;
   }

   @Override
   public void setNivel(Grau g) {
      this.nivel = g;
   }

   @Override
   public void setEnunciado(String enunciado) {
      this.enunciado = enunciado;
   }

   @Override
   public void setResposta(AlternativaI alternativa) {
      this.alternativas[3] = alternativa;
   }

   @Override
   public void setTema(String tema) {
      this.tema = tema;
   }

}
