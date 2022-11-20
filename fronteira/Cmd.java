package fronteira;
import entidades.Pergunta;
import java.util.Scanner;

/**
 * Cmd
 */
public class Cmd extends CmdI<Pergunta>
{
    public char mostrarOpcoes(Pergunta pergunta, int[] permutacao)
    {
        System.out.println(pergunta.getTema());   
        System.out.println(pergunta.getEnunciado());   
        System.out.println(pergunta.getAlternativas()[permutacao[0]]);      
        System.out.println(pergunta.getAlternativas()[permutacao[1]]);
        System.out.println(pergunta.getAlternativas()[permutacao[2]]);
        System.out.println(pergunta.getAlternativas()[permutacao[3]]);
        return respostaUsuario();
    }

    protected char respostaUsuario()
    {
        Scanner input;
        char c;
        do
        {
            input = new Scanner(System.in);
            c = input.next().toLowerCase().charAt(0);
            if(c >= 'a' && c <= 'f')
                System.out.println("Escolha incorreta! -> Sao permitidos somente as letras a,b,c,e,d,f\n");
        }
        while(c >= 'a' && c <= 'f');
        input.close();
        return c;
    }
}
