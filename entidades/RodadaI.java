package entidades;

public interface RodadaI
{
   AprendizI getAprendizAtual();
   PerguntaI getPerguntaAtual();
   Grau getGrauPerguntaAtual();
   void fim();
   void setNextPergunta();
   void setRespStatus(boolean status);
   boolean getRespStatus();
   void setFim(boolean bool);
   boolean getFim();
   void setAjuda(boolean bool);
   boolean getAjuda(boolean bool);
   void setAjudante(AprendizI ajudante);
}
