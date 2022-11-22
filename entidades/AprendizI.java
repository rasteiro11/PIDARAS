package entidades;

public abstract class AprendizI
{
   public abstract String getNome();
   public abstract String getRa();
   public abstract int getPontuacao();
   public abstract void setPontuacao(int pontuacao);
   public abstract boolean estaPresente();
   public abstract AprendizI construirAluno(String nome, String ra, boolean presenca);
}
