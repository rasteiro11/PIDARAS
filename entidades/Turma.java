package entidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Turma extends TurmaI<AprendizI> {
   private List<AprendizI> aprendizes;

   public Turma()
   {
      aprendizes = new ArrayList<>();
   }

   public Turma(String fileName) {
      aprendizes = this.carregarArquivo(fileName);
   }

   public AprendizI acharAprendiz(String ra)
   {
      int i = 0, size = aprendizes.size();
      AprendizI aluno = null;
      if (i < size)
      {
         do
         {
            aluno = aprendizes.get(i);
            i++;
         } while (aluno.getRa().equals(ra) && i < size);

         if (!aluno.getRa().equals(ra))
            aluno = null;
      }

      return aluno;
   }

   @Override
   public List<AprendizI> carregarArquivo(String fileName) {
      List<AprendizI> aprendizTemp = new ArrayList<>();
      try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
         String line;
         try {
            while ((line = br.readLine()) != null) {
               String[] props = new String[3];
               if (!(line.isBlank() || line.isEmpty())) {
                  props = line.split(",");
                  for (var s : props)
                     s = s.trim();
                  aprendizTemp.add(new Aprendiz(props[0], props[1],
                        Boolean.parseBoolean(props[2])));
               }
            }
         } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
         }
      } catch (Exception e) {
         System.err.format("SOMETHING WENT WRONG");
         System.exit(1);
      }

      this.aprendizes = aprendizTemp;

      return aprendizTemp;
   }

   @Override
   public void novoAprendiz(AprendizI aprendiz) {
      aprendizes.add(aprendiz);
   }

   @Override
   public void removerAprendiz(AprendizI aprendizI)
   {
      int i = 0, size = aprendizes.size();
      AprendizI aprendizTemp = null;
      if(size > 0)
      {
         do
         {
            aprendizTemp = aprendizes.get(i);
            i++;
         }while(!aprendizTemp.equals(aprendizI) && i < size);

         if(aprendizTemp.equals(aprendizI))
            aprendizes.remove(i - 1);
      }
   }

   @Override
   public List<AprendizI> getAprendizes() {
      return this.aprendizes;
   }
}
