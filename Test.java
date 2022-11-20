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
public class Test {
    public static void main(String[] args) {
        Aprendiz A = new Aprendiz("PEPEGA", "BASED");
        Aprendiz B = new Aprendiz("ALLAHU", "AKBAR");
        Aprendiz C = new Aprendiz("Pog", "LULE");
        Aprendiz D = new Aprendiz("PagMan", "PepeHands");
        Aprendiz E = new Aprendiz("PogChamp", "Sadegg");
        System.out.println("Name of Retard: " + A.getNome());
        System.out.println("RA: " + A.getRa());

        Turma BasedLads = new Turma("./controle/Turma.txt");
        BasedLads.novoAprendiz(A);
        BasedLads.novoAprendiz(B);
        BasedLads.novoAprendiz(C);
        BasedLads.novoAprendiz(D);
        BasedLads.novoAprendiz(E);

        Sorteio<AprendizI> S = new Sorteio<>();
        AprendizI F = S.sortear(BasedLads.carregarArquivo("./controle/Turma.txt"));
        System.out.println("Got from Random class the following Name -> " + F.getNome());
        System.out.println("Got from Random class the following RA -> " + F.getRa());

        QuestionarioI q = new Questionario("./controle/Perguntas.txt");
        // for (PerguntaI var : q.getPerguntas()) {
        // // System.out.println("ENUNCIADO: " + var.getEnunciado());
        // // System.out.println("RESPOSTA: " + var.getResponsta().getDescricao());
        // }
        for (PerguntaI p : q.getPerguntas()) {
            System.out.println("----------------------");
            System.out.println("NIVEL: " + p.getNivel());
            System.out.println("TEMA: " + p.getTema());
            System.out.println("ENUNCIADO: " + p.getEnunciado());
            System.out.println("RESPOSTA: " + p.getResponsta().getDescricao());
            for (AlternativaI var : p.getAlternativas()) {
                System.out.println(var.getDescricao());
            }
        }

        /* PEPEGA TEST */

        for (AprendizI aprendizI : BasedLads.getAprendizes()) {
            System.out.println(aprendizI.getNome());
            System.out.println(aprendizI.getRa());
        }

        List<PerguntaI> hist = new ArrayList<>();

        PerguntaI[] batch = q.sortear(hist);
        for (var fodase : batch) {
            System.out.println(fodase.getEnunciado());
        }

        PerguntaI[] batch_2 = q.sortear(hist);
        for (var fodase : batch_2) {
            System.out.println(fodase.getEnunciado());
        }

    }
}
