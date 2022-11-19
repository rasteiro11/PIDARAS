import java.util.List;

import entidades.*;

/**
 * App
 */
public class Aplicacao {
    public static void main(String[] args) {
        // Grau g = Grau.D;
        // Aprendiz A = new Aprendiz("PEPEGA", "BASED");

        // System.out.println("Name of Retard:" + A.getNome());
        // System.out.println("RA :" + A.getRa());
        // System.out.println(g);
        // System.out.println(g.getGrau());

        QuestionarioI q = new Questionario();
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
    }
}
