package entidades;
import java.util.ArrayList;
import java.util.List;

public class Turma <Aluno extends AprendizI>  extends TurmaI<Aluno>
{
   List<Aluno> aprendizes;

   public Turma()
   {
      aprendizes = new ArrayList<>();
   }

   @Override
   public Aluno acharAprendiz(String ra)
   {
      int i = 0, size = aprendizes.size();
      Aluno aluno = null;
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
   public List<Aluno> carregarArquivo(String fileName)
   {
      return aprendizes;
   }

   @Override
   public void novoAprendiz(Aluno aprendiz)
   {
      aprendizes.add(aprendiz);
   }
}
