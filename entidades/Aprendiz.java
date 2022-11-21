package entidades;

public class Aprendiz extends AprendizI {
   String nome;
   String ra;
   int pontuacao;
   boolean presente;

   public Aprendiz(String nome, String ra) {
      this.nome = nome;
      this.ra = ra;
      this.pontuacao = 0;
      this.presente = true;
   }

   public Aprendiz(String nome, String ra, boolean presente) {
      this.nome = nome;
      this.ra = ra;
      this.pontuacao = 0;
   }

   public boolean estaPresente() {
      // Auto-generated method stub
      return presente;
   }

   public String getNome() {
      // Auto-generated method stub
      return nome;
   }

   public String getRa() {
      // Auto-generated method stub
      return ra;
   }

   @Override
   public int getPontuacao() {
      return pontuacao;
   }

   @Override
   public void setPontuacao(int pontuacao) {
      this.pontuacao = pontuacao;
   }

   @Override
   public AprendizI construirAluno(String nome, String ra, boolean presenca) {
      return new Aprendiz(nome, ra, presente);
   }

   //@Override
   //public boolean equals(AprendizI aprendiz) {
   //   System.out.println("\nINSIDE BOOLEAN");
   //   System.out.println(aprendiz.getNome());
   //   System.out.println(nome);
   //   System.out.println("nome bool -> " + (nome.equals(aprendiz.getNome())));
   //   System.out.println("ra bool -> " + (ra.equals(aprendiz.getRa())));
   //   System.out.println("pont bool -> " + (pontuacao == aprendiz.getPontuacao()));
   //   System.out.println();
   //   return nome.equals(aprendiz.getNome()) && ra.equals(aprendiz.getRa()) && pontuacao == aprendiz.getPontuacao();
   //}

}
