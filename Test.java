import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import controle.Sorteio;
import entidades.AlternativaI;
import entidades.Aprendiz;
import entidades.AprendizI;
import entidades.PerguntaI;
import entidades.Questionario;
import entidades.QuestionarioI;
import entidades.Turma;

/**
 * Test
 */
public class Test 
{
    public static void main(String[] args)
    {
        Aprendiz A = new Aprendiz("PEPEGA","BASED"); 
        Aprendiz B = new Aprendiz("ALLAHU","AKBAR");
        Aprendiz C = new Aprendiz("Pog","LULE");
        Aprendiz D = new Aprendiz("PagMan","PepeHands");
        Aprendiz E = new Aprendiz("PogChamp","Sadegg");
        System.out.println("Name of Retard: " + A.getNome()); 
        System.out.println("RA: " + A.getRa()); 

        Turma BasedLads = new Turma();
        BasedLads.novoAprendiz(A);
        BasedLads.novoAprendiz(B);
        BasedLads.novoAprendiz(C);
        BasedLads.novoAprendiz(D);
        BasedLads.novoAprendiz(E);

        Sorteio<Aprendiz> S = new Sorteio<Aprendiz>();
        Aprendiz F = S.sortear(BasedLads.findAll());
        System.out.println("Got from Random class the following Name -> " + F.getNome());
        System.out.println("Got from Random class the following RA -> " + F.getRa());

        QuestionarioI q = new Questionario();
        // for (PerguntaI var : q.getPerguntas()) {
        // // System.out.println("ENUNCIADO: " + var.getEnunciado());
        // // System.out.println("RESPOSTA: " + var.getResponsta().getDescricao());
        // }
        for (PerguntaI p : q.getPerguntas())
        {
            System.out.println("----------------------");
            System.out.println("NIVEL: " + p.getNivel());
            System.out.println("TEMA: " + p.getTema());
            System.out.println("ENUNCIADO: " + p.getEnunciado());
            System.out.println("RESPOSTA: " + p.getResponsta().getDescricao());
            for (AlternativaI var : p.getAlternativas())
            {
                System.out.println(var.getDescricao());
            }
        }

        /*PEPEGA TEST*/
        List<AprendizI> aprendiztemp = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("./controle/Turma.txt")))
        {
            String line;
            try
            {
               while ((line = br.readLine()) != null)
               {
                  String[] props = new String[3];
                  if (!(line.isBlank() || line.isEmpty()))
                  {
                     props = line.split(",");   
                     for (var s : props)
                        s = s.trim();          
                     aprendiztemp.add(new Aprendiz(props[0],props[1],Boolean.parseBoolean(props[2])));
                  }
               }
            }
            catch (IOException e)
            {
               System.err.format("IOException: %s%n", e);
            }
        } 
        catch (Exception e)
        {
           System.err.format("SOMETHING WENT WRONG");
           System.exit(1);
        }

        for (AprendizI aprendizI : aprendiztemp)
        {
            System.out.println(aprendizI.getNome()); 
            System.out.println(aprendizI.getRa()); 
        }
    }
}
