import controle.Sorteio;
import entidades.*;

/**
 * App
 */
public class Aplicacao
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

        Turma<Aprendiz> BasedLads = new Turma<Aprendiz>();
        BasedLads.novoAprendiz(A);
        BasedLads.novoAprendiz(B);
        BasedLads.novoAprendiz(C);
        BasedLads.novoAprendiz(D);
        BasedLads.novoAprendiz(E);

        Sorteio<Aprendiz> S = new Sorteio<Aprendiz>();
        Aprendiz F = S.sortear(BasedLads.findAll());
        System.out.println("Got from Random class the following Name -> " + F.getNome());
        System.out.println("Got from Random class the following RA -> " + F.getRa());
    }
}
