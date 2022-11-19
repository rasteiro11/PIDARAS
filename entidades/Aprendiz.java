package entidades;

public class Aprendiz extends AprendizI {
   String nome;
   String ra;
   boolean presente;

   public Aprendiz(String nome, String ra) {
      this.nome = nome;
      this.ra = ra;
      presente = true;
   }

   public Aprendiz(String nome, String ra, boolean presente) {
      this.nome = nome;
      this.ra = ra;
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
}
