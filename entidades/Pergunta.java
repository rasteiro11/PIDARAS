package entidades;

public class Pergunta extends PerguntaI {

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
      // Auto-generated method stub
      return alternativas;
   }

   @Override
   public String getEnunciado() {
      // Auto-generated method stub
      return this.enunciado;
   }

   @Override
   public Grau getNivel() {
      // Auto-generated method stub
      return this.nivel;
   }

   @Override
   public AlternativaI getResponsta() {
      // Auto-generated method stub
      return alternativas[0];
   }

   @Override
   public String getTema() {
      // Auto-generated method stub
      return this.tema;
   }

   @Override
   public void setNivel(Grau g) {
      // Auto-generated method stub
      this.nivel = g;
   }

   @Override
   public void setEnunciado(String enunciado) {
      // Auto-generated method stub
      this.enunciado = enunciado;
   }

   @Override
   public void setResponsta(AlternativaI alternativa) {
      // Auto-generated method stub
      this.alternativas[3] = alternativa;
   }

   @Override
   public void setTema(String tema) {
      // Auto-generated method stub
      this.tema = tema;
   }

}
