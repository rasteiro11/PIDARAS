package entidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Questionario extends QuestionarioI {

   private List<PerguntaI> perguntas;

   public Questionario() {
      this.perguntas = this.findAll();
   }

   @Override
   public List<PerguntaI> findAll() {
      // Auto-generated method stub
      List<PerguntaI> perguntasTemp = new ArrayList<>();
      try (BufferedReader br = Files.newBufferedReader(Paths.get("./controle/Perguntas.txt"))) {

         String enunciado = "";
         String tema = "";
         String line;
         Grau nivel = Grau.D;
         AlternativaI resposta;
         PerguntaI pergunta;
         int altPtr = 0;
         PerguntaI p = new Pergunta();
         // read line by line
         try {
            while ((line = br.readLine()) != null) {
               if (!(line.isBlank() || line.isEmpty())) {
                  switch (line.charAt(0)) {
                     case 't':
                        tema = line.split(":")[1].trim();
                        p.setTema(line.split(":")[1].trim());
                        break;
                     case 'p':
                        switch (line.split(":")[1].trim()) {
                           case "F":
                              nivel = Grau.F;
                              break;
                           case "M":
                              nivel = Grau.M;
                              break;
                           case "D":
                              nivel = Grau.D;
                              break;
                           default:
                              break;
                        }
                        p.setNivel(nivel);
                        p.setEnunciado(line.split(":")[2].trim());
                        break;
                     case 'r':
                        p.setResponsta(new Alternativa(line.split(":")[1].trim()));
                        break;
                     case 'a':
                        if (altPtr <= 2) {
                           p.setAlternativas(new Alternativa(line.split(":")[1].trim()), altPtr);
                           altPtr++;
                        } else {
                           altPtr = 0;
                           p.setAlternativas(new Alternativa(line.split(":")[1].trim()), altPtr);
                           altPtr++;
                        }
                        break;
                     default:
                        break;
                  }
               } else {
                  perguntasTemp.add(p);
                  p = new Pergunta();
                  p.setTema(tema);
               }
            }
         } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
         }

      } catch (Exception e) {
         System.err.format("SOMETHING WENT WRONG");
         System.exit(1);
      }

      return perguntasTemp;
   }

   @Override
   public List<PerguntaI> getPerguntas() {
      return this.perguntas;
   }

}