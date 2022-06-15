/*
 Disponibilizado em Projeto de Algoritmos com implementações em Java e C++
 Autor: Nivio Ziviani
 */
package Teste;

import Arvore.ArvoreB;
import Arvore.ArvoreSBB;
import Item.Item;
import java.util.Scanner;


public class Teste {

    public static void main(String[] args) {
        
        int contadorDeComparacoes, elemento, n;
        long tempoInicial, tempoFinal, tempoGasto;
        
        ArvoreB arvoreB = null;
        ArvoreSBB arvoreSBB = new ArvoreSBB();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Defina a ordem da Árvore B (2,4 ou 6): ");
        int ordem = scan.nextInt();
        
        switch(ordem){
            case 2: 
                    break;
            case 4: 
                    break;
            case 6:
                    break;
            default:System.out.println("Ordem não identificada");
                    System.exit(1);
        }   
        //  item que será pesquisado e nunca será encontrado
            Item itemSearch = new Item(200000);
            
            //inserindo elementos em cada arvore
            for(n = 1; n <= 10; n++)
            {
                arvoreB = new ArvoreB(ordem);
                //insere os elementos ordenadamente
                for(elemento = 1; elemento <= n*10000; elemento++)
                {
                    Item itemElemento = new Item(elemento);
                    arvoreSBB.insere(itemElemento);
                    arvoreB.insere(itemElemento);
                }           

                //pesquisar por um elemento não existente em cada árvore
                // Arvore SBB
                
                tempoInicial = System.nanoTime();
                //contadorDeComparacoes = arvoreSBB.pesquisa(itemSearch);
                arvoreSBB.pesquisa(itemSearch);
                contadorDeComparacoes = arvoreSBB.getContadorDeComparacoes();
                tempoFinal = System.nanoTime();
                tempoGasto = (tempoFinal-tempoInicial);
                //Dados obtidos
                //System.out.println("Arvore SBB: "+n+" Tempo Gasto para fazer a procura: "+tempoGasto+"(nano segundos)"+" Numero de Comparacoes: "+contadorDeComparacoes);
                arvoreSBB.gravaDados(n, contadorDeComparacoes, tempoGasto,"ordemOrdenadaArvoreSBB");
                
                // Arvore B - ordem x
                tempoInicial = System.nanoTime();
                //contadorDeComparacoes = arvoreB.pesquisa(itemSearch);
                arvoreB.pesquisa(itemSearch);
                contadorDeComparacoes = arvoreB.getComparacoesRealizadas();
                tempoFinal = System.nanoTime();
                tempoGasto = (tempoFinal-tempoInicial);
                //Dados obtidos
                //System.out.println("Arvore B: "+n+" Ordem: "+ordem+" Tempo Gasto para fazer a procura: "+tempoGasto+"(nano segundos)"+" Paginas visitadas: "+paginasVisitadas);
                String nameFile = "ordemOrdenadaArvoreB - Ordem "+ordem;
                arvoreSBB.gravaDados(n, contadorDeComparacoes, tempoGasto,nameFile);
                arvoreB.setComparacoesRealizadas(0);
            }
           
        }
}