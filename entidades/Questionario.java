package entidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import controle.SorteavelI;
import controle.Sorteio;

public class Questionario extends QuestionarioI {

   private List<PerguntaI> perguntas;

   public Questionario(String fileName) {
      this.carregarArquivo(fileName);
   }

   @Override
   public List<PerguntaI> carregarArquivo(String fileName) {
      List<PerguntaI> perguntasTemp = new ArrayList<>();
      try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
         String tema = "";
         String line;
         Grau nivel = Grau.D;
         int altPtr = 0;
         PerguntaI p = new Pergunta();
         try {
            while ((line = br.readLine()) != null) {
               if (!(line.isBlank() || line.isEmpty())) {
                  switch (line.charAt(0)) {
                     case 't':
                        tema = line.split(":")[1].trim();
                        p.setTema(tema);
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
                        if (altPtr <= 2)
                           p.setAlternativas(new Alternativa(line.split(":")[1].trim()), altPtr);
                        else {
                           altPtr = 0;
                           p.setAlternativas(new Alternativa(line.split(":")[1].trim()), altPtr);
                        }
                        altPtr++;
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

      this.perguntas = perguntasTemp;
      return perguntasTemp;
   }

   @Override
   public List<PerguntaI> getPerguntas() {
      return this.perguntas;
   }

   // WARNING GET BACK HERE
   @Override
   public PerguntaI[] sortear(List<PerguntaI> historico) {
      // Auto-generated method stub

      PerguntaI[] batch = new Pergunta[3];
      int numBatches = this.perguntas.size() / 3;
      Random r = new Random();
      int rand;
      PerguntaI perguntaTemp;

      do {
         rand = r.nextInt(numBatches);
         perguntaTemp = this.perguntas.get(rand * 3);
      } while (historico.contains(perguntaTemp));

      batch[0] = this.perguntas.get(rand * 3);
      batch[1] = this.perguntas.get(rand * 3 + 1);
      batch[2] = this.perguntas.get(rand * 3 + 2);

      historico.add(batch[0]);
      historico.add(batch[1]);
      historico.add(batch[2]);

      return batch;
   }

}
