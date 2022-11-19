package entidades;

public class Alternativa implements AlternativaI {

   public String descricao;

   public Alternativa(String descricao) {
      this.descricao = descricao;
   }

   @Override
   public String getDescricao() {
      // Auto-generated method stub
      return this.descricao;
   }

}
