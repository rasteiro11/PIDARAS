import controle.Sorteio;
import entidades.AlternativaI;
import entidades.Aprendiz;
import entidades.AprendizI;
import entidades.Grau;
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

        Turma BasedLads = new Turma("./arquivos/Turma.txt");
        BasedLads.novoAprendiz(A);
        BasedLads.novoAprendiz(B);
        BasedLads.novoAprendiz(C);
        BasedLads.novoAprendiz(D);
        BasedLads.novoAprendiz(E);

        Sorteio<AprendizI> S = new Sorteio<>();
        AprendizI F = S.sortearLista(BasedLads.getAprendizes());
        System.out.println("Got from Random class the following Name -> " + F.getNome());
        System.out.println("Got from Random class the following RA -> " + F.getRa());

        QuestionarioI q = new Questionario("./arquivos/Perguntas.txt");
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

        PerguntaI[] batch = q.sortear();
        for (var fodase : batch) {
            System.out.println(fodase.getEnunciado());
        }

        PerguntaI[] batch_2 = q.sortear();
        for (var fodase : batch_2) {
            System.out.println(fodase.getEnunciado());
        }

        System.out.println("does this piece of shit even work - > " + Grau.D.getGrau());
    }
}
