package entidades;
import java.util.ArrayList;
import java.util.List;

public class Turma extends TurmaI<AprendizI>
{
   List<AprendizI> aprendizes;

   public Turma()
   {
      aprendizes = new ArrayList<>();
   }

   @Override
   public AprendizI acharAprendiz(String ra)
   {
      int i = 0, size = aprendizes.size();
      AprendizI aluno = null;
      if(i < size)
      {
         do
         {
            aluno = aprendizes.get(i);
            i++;
         }
         while(aluno.getRa().equals(ra) && i < size);

         if(!aluno.getRa().equals(ra))
            aluno = null;
      }

      return aluno;
   }

   @Override
   public List<AprendizI> carregarArquivo(String fileName)
   {
      return aprendizes;
   }

   @Override
   public void novoAprendiz(AprendizI aprendiz)
   {
      aprendizes.add(aprendiz);
   }
}
