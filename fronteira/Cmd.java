package fronteira;
import entidades.AprendizI;
import entidades.PerguntaI;
import entidades.TurmaI;

import java.util.Scanner;

/**
 * Cmd
 */
public class Cmd extends CmdI
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
            mostarPergunta(pergunta, permutacao);
            System.err.print("Escolha: ");
            c = input.next().toLowerCase().charAt(0);
            if(c < 'a' || c > 'f')
                System.out.println("Escolha incorreta! -> Sao permitidos somente as letras a,b,c,e,d,f\n");
        }while(c < 'a' || c > 'f');
        return c; 
    }

    @Override
    public void mostarAprendiz(String mensagem, AprendizI aprendizI)
    {
        System.out.println(mensagem);
        System.out.println('\t' + aprendizI.getNome()); 
        System.out.println('\t' + aprendizI.getRa()); 
    }

    public void mostarPergunta(PerguntaI pergunta, int[] permutacao)
    {
        System.out.println(pergunta.getTema());   
        System.out.println(pergunta.getEnunciado());   
        System.out.println("a.) " + pergunta.getAlternativas()[permutacao[0]].getDescricao());      
        System.out.println("b.) " + pergunta.getAlternativas()[permutacao[1]].getDescricao());
        System.out.println("c.) " + pergunta.getAlternativas()[permutacao[2]].getDescricao());
        System.out.println("d.) " + pergunta.getAlternativas()[permutacao[3]].getDescricao());
        System.out.println("e.) Ajuda");
        System.out.println("f.) Parada");
    }

    public void mostarRespostaCorreta(String resposta, int alternativa)
    {
        char[] alternativas = {'a','b','c','d'};
        System.out.println(alternativas[alternativa] + resposta);
    }

    public void mostarInformacao(String info)
    {
        System.out.println(info);
    }

    public void apresentarResultados(TurmaI turma)
    {
        for (AprendizI t: turma.getAprendizes())
        {
            System.out.println(t.getNome()); 
            System.out.println(t.getRa()); 
            System.out.println(t.getPontuacao()); 
        }
    }
}
