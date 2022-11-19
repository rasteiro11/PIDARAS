package entidades;

public interface PerguntaI
{
   public Grau getNivel();
   public String getEnunciado();
   public AlternativaI getResponsta();
   public AlternativaI[] getAlternativas();
}
