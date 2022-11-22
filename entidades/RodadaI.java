package entidades;

public abstract class RodadaI
{
   public abstract AprendizI getAprendizAtual();
   public abstract PerguntaI getPerguntaAtual();
   public abstract Grau getGrauPerguntaAtual();
   public abstract void setNextPergunta();
   public abstract void setRespStatus(boolean status);
   public abstract boolean getRespStatus();
   public abstract void setFim(boolean bool);
   public abstract boolean getFim();
   public abstract void setAjuda(boolean bool);
   public abstract boolean getAjuda();
   public abstract void setAjudante(AprendizI ajudante);
   public abstract AprendizI getAjudante();
}
