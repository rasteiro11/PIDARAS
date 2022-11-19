package entidades;

public abstract class PerguntaI
{
   public abstract Grau getNivel();
   public abstract String getEnunciado();
   public abstract AlternativaI getResponsta();
   public abstract AlternativaI[] getAlternativas();
}
