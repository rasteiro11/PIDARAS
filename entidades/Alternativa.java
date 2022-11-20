package entidades;

public class Alternativa extends AlternativaI {

   public String descricao;

   public Alternativa(String descricao) {
      this.descricao = descricao;
   }

   @Override
   public String getDescricao() {
      return this.descricao;
   }

}
