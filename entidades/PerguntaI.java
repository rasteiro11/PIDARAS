package entidades;

public abstract class PerguntaI
{
   public abstract Grau getNivel();
   public abstract String getEnunciado();
   public abstract AlternativaI getResponsta();
   public abstract AlternativaI[] getAlternativas();
   public abstract String getTema();
   public abstract void setNivel(Grau g);
   public abstract void setEnunciado(String enunciado);
   public abstract void setResponsta(AlternativaI alternativa);
   public abstract void setAlternativas(AlternativaI alternativa, int index);
   public abstract void setTema(String tema);
}
