package Teste;

import Heap.Heap;
import Heap.HeapSort;
import Item.Item;
import java.util.Random;

public class Teste {
        public static void main(String[] args) {
        
        int contadorDeComparacoes, elementoCrescente, elementoDecrescente, elementoAleatorio, n, posicao;
        String nameFile;
        Random gerador = new Random();
                   
            //n variando de 10.000 até 100.000, com intervalo de 10.000;
            for (n = 1; n <= 10; n++) 
            {
                Item itensOrdenadosCrescente[] = new Item[n * 10000];
                Item itensOrdenadosDecrescente[] = new Item[n * 10000];
                Item itensAleatorios[] = new Item[n * 10000];
                
                for (elementoCrescente = 1, posicao = 0, elementoDecrescente = n*10000; elementoCrescente <= n * 10000; elementoCrescente++, posicao++, elementoDecrescente--) {
                    Item itemCrescente = new Item(elementoCrescente); //cria um novo item com o elemento crescente
                    Item itemDecrescente = new Item(elementoDecrescente); //cria um novo item com o elemento decrescente
                    
                    itensOrdenadosCrescente[posicao] = itemCrescente; //insere os elementos crescentes ordenadamente
                    itensOrdenadosDecrescente[posicao] = itemDecrescente; //insere os elementos decrescentes ordenadamente
                    
                    int rand = gerador.nextInt(n*9999 +1);
                    Item itemAleatorio = new Item(rand);
                    itensAleatorios[posicao] = itemAleatorio; //insere os elementos aleatorios
                }
               
               //elementos crescentes ordenadamente
               Heap heapOrdenadoCrescente = new Heap(itensOrdenadosCrescente);
               HeapSort.HeapSort(itensOrdenadosCrescente, itensOrdenadosCrescente.length, heapOrdenadoCrescente);
               nameFile = "ordemOrdenadaCrescente Heap";
               contadorDeComparacoes = heapOrdenadoCrescente.getComparacoes();
               //heapOrdenadoCrescente.gravaDados(n, contadorDeComparacoes,nameFile);
               
               //elementos decrescentes ordenadamente
               Heap heapOrdenadoDecrescente = new Heap(itensOrdenadosDecrescente);
               HeapSort.HeapSort(itensOrdenadosDecrescente, itensOrdenadosDecrescente.length, heapOrdenadoDecrescente);
               nameFile = "ordemOrdenadaDecrescente Heap";
               contadorDeComparacoes = heapOrdenadoDecrescente.getComparacoes();
               //heapOrdenadoDecrescente.gravaDados(n, contadorDeComparacoes,nameFile);
               
               //elementos aleatorios
               Heap heapAleatorio = new Heap(itensAleatorios);
               HeapSort.HeapSort(itensAleatorios, itensAleatorios.length, heapAleatorio);
               nameFile = "ordemAleatoria Heap";
               contadorDeComparacoes = heapAleatorio.getComparacoes();
               //heapAleatorio.gravaDados(n, contadorDeComparacoes,nameFile);
            }
        }
}
