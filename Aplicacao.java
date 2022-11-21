import java.util.Random;

import controle.Ajuda;
import controle.Parada;
import entidades.AprendizI;
import entidades.Questionario;
import entidades.Rodada;
import entidades.Turma;
import fronteira.Cmd;

/**
 * Aplicacao
 */
public class Aplicacao
{
    public static void main(String[] args)
    {
        Turma sorteados = new Turma();
        Turma n_sorteados = new Turma("./arquivos/Turma.txt");
        Questionario questoes = new Questionario("./arquivos/Perguntas.txt");
        Ajuda ajuda = new Ajuda();
        Parada parada = new Parada();
        Cmd tela = new Cmd();

        /*Pre n_sorteados*/
        //System.out.println("n_sorteados Antes: ");
        //for (AprendizI t: n_sorteados.getAprendizes())
        //{
        //    System.out.println(t.getNome()); 
        //    System.out.println(t.getRa()); 
        //    System.out.println(t.getPontuacao()); 
        //}
        //System.out.println();

        while(n_sorteados.getAprendizes().size() > 0)
        {
            Rodada rodada = new Rodada(questoes, n_sorteados, sorteados);
            while(rodada.getRespStatus() == true && rodada.getFim() == false)    // Rodada do Aprendiz
            {
                int [] perm = criarPermutacao();    //Criar Classe para Permutacao, por enquanto serve para teste

                /*Debug Permutation*/
                //System.out.println("Permutation:");
                //int j = 0;
                //for (int i : perm)
                //{
                //    System.out.print(j);
                //    System.out.print(" -> ");
                //    System.out.println(i); 
                //    j++;
                //}

                tela.monstarAprendiz(rodada.getAprendizAtual());
                char escolha = tela.opcoesUsuario(rodada.getPerguntaAtual(), perm);

                if(escolha == 'e')
                {
                    /*Ajuda*/
                    //System.out.println("Ajuda");
                    //
                    //indicar na fronteira quem foi o aluno sorteado para ajudar
                    ajuda.pedirAjuda(n_sorteados, rodada);
                }
                else if (escolha == 'f')
                {
                    /*Parada*/
                    //System.out.println("Parada");
                    parada.parar(rodada); 
                }
                else  
                {
                    //System.out.println("\nescolha - > " + (escolha - 97));
                    //System.out.println("\nperm[escolha - 97] - > " + perm[escolha - 97]);
                    if(perm[escolha - 97] == 3)   //Aprendiz escolheu corretamente
                    {
                        /*funcao na fronteira para indicar resposta correta*/
                        System.out.println("\nCORRECT ANSWER\n");
                    }
                    else
                    {
                        /*funcao na fronteira para indicar resposta incorreta*/
                        System.out.println("\nINCORRECT ANSWER\n");
                        rodada.setRespStatus(false);
                    }
                    rodada.setNextPergunta();
                }
            }
        }

        /*Post n_sorteados*/
        //colocar na fronteira
        System.out.println("sorteados Antes: ");
        for (AprendizI t: sorteados.getAprendizes())
        {
            System.out.println(t.getNome()); 
            System.out.println(t.getRa()); 
            System.out.println(t.getPontuacao()); 
        }
    }

    public static int[] criarPermutacao()
    {
        Random rnd = new Random();
        int[] perm = new int[4];
        perm[0] = 0;
        perm[1] = 1;
        perm[2] = 2;
        perm[3] = 3;
        int aux;
        int i = 3;
        while(i > 0)
        {
            int j = rnd.nextInt(0, i);
            aux = perm[i];
            perm[i] = perm[j];
            perm[j] = aux;
            i--;
        }

        return perm;
    }
}
