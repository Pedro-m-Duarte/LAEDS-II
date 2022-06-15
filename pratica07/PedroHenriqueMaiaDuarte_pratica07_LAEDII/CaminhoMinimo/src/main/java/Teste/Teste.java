package Teste;

import Arvore.XAEDsMaps;
import Arvore.XGrafo;

public class Teste {
    public static void main(String[] args) throws Exception {
        int peso;
        XGrafo grafo1 = new XGrafo(6); // Primeiro grafo
       
        // inserindo elementos grafo1:
        grafo1.insereAresta(0, 0, 0, 0);
        
        grafo1.insereAresta(1, 1, 0, 0);
        grafo1.insereAresta(1, 2, 8, 3);
        grafo1.insereAresta(1, 3, 4, 10);
        grafo1.insereAresta(1, 4, 5, 2);
                
        grafo1.insereAresta(2, 2, 0, 0);
        grafo1.insereAresta(2, 5, 9, 5);

        grafo1.insereAresta(3, 3, 0, 0);
        grafo1.insereAresta(3, 4, 1, 4);
        grafo1.insereAresta(3, 5, 5, 2);
        
        grafo1.insereAresta(4, 4, 0, 0);
        grafo1.insereAresta(4, 2, 3, 8);
        grafo1.insereAresta(4, 3, 5, 7);
        grafo1.insereAresta(4, 5, 2, 7);
        
        grafo1.insereAresta(5, 5, 0, 0);

        // inserindo elementos grafo2:        
        XGrafo grafo2 = new XGrafo(5); // Segundo grafo
        grafo2.insereAresta(0, 0, 0, 0);
        grafo2.insereAresta(0, 1, 3, 3);
        grafo2.insereAresta(0, 3, 5, 5);
        
        grafo2.insereAresta(1, 1, 0, 0);
        grafo2.insereAresta(1, 2, 2, 6);
        grafo2.insereAresta(1, 3, 2, 2);
        
        grafo2.insereAresta(2, 2, 0, 0);
        grafo2.insereAresta(2, 4, 2, 2);
        
        grafo2.insereAresta(3, 3, 0, 0);
        grafo2.insereAresta(3, 1, 3, 1);
        grafo2.insereAresta(3, 2, 5, 4);
        grafo2.insereAresta(3, 4, 9, 6);
        
        grafo2.insereAresta(4, 4, 0, 0);
        grafo2.insereAresta(4, 0, 6, 3);
        grafo2.insereAresta(4, 2, 4, 7);

        //RESULTADOS: 
        XAEDsMaps g1 = new XAEDsMaps(grafo1);
        XAEDsMaps g2 = new XAEDsMaps(grafo2);
        
        System.out.println("\nMELHOR DISTANCIA GRAFO 1: ");
        g1.obterArvoreCMC(1, 5, "Melhor Distancia");
        peso = g1.imprimeCaminho(1, 5, "Melhor Distancia");
        System.out.println("PESO: " + peso);
        
        System.out.println("\nMELHOR TEMPO GRAFO 1: ");
        g1.obterArvoreCMC(1, 5, "Melhor Tempo");
        peso = g1.imprimeCaminho(1, 5, "Melhor Tempo");
        System.out.println("PESO: " + peso);
        
        System.out.println("\nMELHOR DISTANCIA GRAFO 2: ");
        g2.obterArvoreCMC(3, 0, "Melhor Distancia");
        peso = g2.imprimeCaminho(3, 0, "Melhor Distancia");
        System.out.println("PESO: " + peso);
        
        System.out.println("\nMELHOR TEMPO GRAFO 2: ");
        g2.obterArvoreCMC(3, 0, "Melhor Tempo");
        peso = g2.imprimeCaminho(3, 0, "Melhor Tempo");
        System.out.println("PESO: " + peso);
    }
}
