package fronteira;
import entidades.AprendizI;
import entidades.PerguntaI;
import java.util.Scanner;

/**
 * Cmd
 */
public class Cmd extends CmdI<PerguntaI>
{
    Scanner input;

    public Cmd()
    {
        input = new Scanner(System.in);
    }

    public char opcoesUsuario(PerguntaI pergunta, int[] permutacao)
    {
        char c;

        do
        {
            System.out.println(pergunta.getTema());   
            System.out.println(pergunta.getEnunciado());   
            System.out.println("a: " + pergunta.getAlternativas()[permutacao[0]].getDescricao());      
            System.out.println("b: " + pergunta.getAlternativas()[permutacao[1]].getDescricao());
            System.out.println("c: " + pergunta.getAlternativas()[permutacao[2]].getDescricao());
            System.out.println("d: " + pergunta.getAlternativas()[permutacao[3]].getDescricao());
            System.out.println("e: Ajuda");
            System.out.println("f: Parada");
            System.err.print("Escolha: ");
            c = input.next().toLowerCase().charAt(0);
            if(c < 'a' || c > 'f')
                System.out.println("Escolha incorreta! -> Sao permitidos somente as letras a,b,c,e,d,f\n");
        }
        while(c < 'a' || c > 'f');
        return c; 
    }

    @Override
    public void monstarAprendiz(AprendizI aprendizI)
    {
        System.out.println("O Aprendiz Sorteado foi: ");
        System.out.println(' ' + aprendizI.getNome()); 
        System.out.println(' ' + aprendizI.getRa()); 
    }

}
