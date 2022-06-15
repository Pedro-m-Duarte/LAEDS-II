/*
 Disponibilizado em Projeto de Algoritmos com implementa��es em Java e C++
 Autor: Nivio Ziviani
 */
package teste;

import arvore.ArvoreBinaria;
import arvore.ArvoreBinaria.No;
import item.Item;
import java.util.Random;

public class Teste {

    public static void main(String[] args) {
        
        int contadorDeComparacoes, elemento, n, numAleatorio;
        long tempoInicial, tempoFinal, tempoGasto;
        ArvoreBinaria arvoreOrdenada, arvoreAleatoria;
        Random gerador = new Random();
        
        //ORDEM ORDENADA
        //para cada arvore
        
        for(n = 1; n <= 9; n++)
        {
            arvoreOrdenada = new ArvoreBinaria();
            
            //insere os elementos ordenadamente
            for(elemento = 1; elemento <= n*1000; elemento++)
            {
                Item itemElemento = new Item(elemento);
                arvoreOrdenada.insere(itemElemento);
            }
            
            //pesquisar por um elemento n�o existente
            Item itemSearch = new Item(20000);
            
            tempoInicial = System.nanoTime();
            contadorDeComparacoes = arvoreOrdenada.pesquisa(itemSearch);           
            tempoFinal = System.nanoTime();
            tempoGasto = (tempoFinal-tempoInicial);
            
            //Dados obtidos
            System.out.println("Arvore: "+n+" Tempo Gasto para fazer a procura: "+tempoGasto+"(nano segundos)"+" Numero de Comparacoes: "+contadorDeComparacoes);
            arvoreOrdenada.gravaDados(n, contadorDeComparacoes, tempoGasto,"ordemOrdenada");
        }
        
        //ORDEM ALEAT�RIA
        //para cada arvore
        for(n = 1; n <= 9; n++)
        {
            arvoreAleatoria = new ArvoreBinaria();
            
            //insere os elementos aleatoriamente
            for(elemento = 1; elemento <= n*1000; elemento++)
            {
                numAleatorio = gerador.nextInt(n*1000)+1;
                //System.out.println("unm "+ numAleatorio);
                Item itemElemento = new Item(numAleatorio);
                arvoreAleatoria.insere(itemElemento);
            }
            
            //pesquisar por um elemento n�o existente
            Item itemSearch = new Item(20000);
            
            tempoInicial = System.nanoTime();
            contadorDeComparacoes = arvoreAleatoria.pesquisa(itemSearch);           
            tempoFinal = System.nanoTime();
            tempoGasto = (tempoFinal-tempoInicial);
            
            //Dados obtidos
            System.out.println("Arvore: "+n+" Tempo Gasto para fazer a procura: "+tempoGasto+"(nano segundos)"+" Numero de Comparacoes: "+contadorDeComparacoes);
            arvoreAleatoria.gravaDados(n, contadorDeComparacoes, tempoGasto, "ordemAleatoria");
        }
    }
}


