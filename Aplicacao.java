/*
 * Arquivo: Aplicacao.java
 * Data: 21/11/2022
 * Nomes: Jonas Edward Tashiro, Luan Lopes Barbosa de Almeida,
 *       Rafael Melloni Chacon Arnone
 * Versao: feat-fronteira
 * */


import java.util.Random;

import controle.Ajuda;
import controle.Parada;
import controle.Sorteio;
import entidades.AprendizI;
import entidades.Questionario;
import entidades.Rodada;
import entidades.Turma;
import fronteira.Cmd;

/**
 * Aplicacao (Controle)
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
        Sorteio<AprendizI> sorteio = new Sorteio<>();

        while(n_sorteados.getAprendizes().size() > 0)
        {
            Rodada rodada = new Rodada(questoes, n_sorteados, sorteados, sorteio.sortearLista(n_sorteados.getAprendizes()));
            tela.mostarAprendiz("\n\nO aprendiz sorteado foi: ",rodada.getAprendizAtual());

            if(rodada.getFim() == false)
                tela.mostarInformacao("\nEste aprendiz nao esta presente\n\n");

            while(rodada.getRespStatus() == true && rodada.getFim() == false)    // Rodada do Aprendiz
            {
                int [] perm = criarPermutacao();    //Criar Classe para Permutacao, por enquanto serve para teste

                char escolha = tela.opcoesUsuario(rodada.getPerguntaAtual(), perm);

                if(escolha == 'e')
                {
                    /*Ajuda*/
                    if(rodada.getAjuda() == false)
                    {
                        if(ajuda.pedirAjuda(n_sorteados, rodada,tela))  // se for possivel sortear indicar o sorteado
                            tela.mostarAprendiz("O colega sorteado para ajudar foi: ", rodada.getAjudante());
                    }
                    else
                        tela.mostarInformacao("\nAjudante ja foi escolido previamente\n");
                }
                else if (escolha == 'f')
                {
                    /*Parada*/
                    parada.parar(rodada); 
                    tela.mostarAprendiz("O aprendiz:", rodada.getAprendizAtual());
                    tela.mostarInformacao("Solicitou parada");
                }
                else  
                {
                    int i = escolha - 97;
                    if(perm[i] == 3)   //Aprendiz escolheu corretamente (Alternativa[3] sempre e a resposta correta)
                    {
                        tela.mostarInformacao("\nResposta Correta!\n\n\n\n");
                    }
                    else
                    {
                        tela.mostarInformacao("\nResposta Incorreta!");
                        tela.mostarInformacao("A resposta correta era:");
                        tela.mostarRespostaCorreta(rodada.getPerguntaAtual().getAlternativas()[i].getDescricao(),perm[i]);
                        rodada.setRespStatus(false);
                    }
                    rodada.setNextPergunta();
                }
            }
        }

        tela.apresentarResultados(sorteados); 
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
            int j = rnd.nextInt(i);
            aux = perm[i];
            perm[i] = perm[j];
            perm[j] = aux;
            i--;
        }

        return perm;
    }
}
