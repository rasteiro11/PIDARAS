package entidades;

public class Aprendiz extends AprendizI
{
   String nome;
   String ra;
   int pontuacao;
   boolean presente;

   public Aprendiz(String nome, String ra)
   {
      this.nome = nome;
      this.ra = ra;
      this.pontuacao = 0;
      this.presente = true;
   }

   public Aprendiz(String nome, String ra, boolean presente)
   {
      this.nome = nome; 
      this.ra = ra;
      this.pontuacao = 0;
   }

   @Override
   public boolean estaPresente()
   {
      return presente;
   }

   @Override
   public String getNome()
   {
      return nome;
   }

   @Override
   public String getRa()
   {
      return ra;
   }

   @Override
   public int getPontuacao()
   {
      return pontuacao;
   }
   
   @Override
   public void setPontuacao(int pontuacao)
   {
      this.pontuacao = pontuacao;
   }
}
