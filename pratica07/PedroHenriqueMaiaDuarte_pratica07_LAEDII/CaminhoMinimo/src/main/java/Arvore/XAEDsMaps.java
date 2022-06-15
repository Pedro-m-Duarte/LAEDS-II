/*
 Disponibilizado em Projeto de Algoritmos com implementações em Java e C++
 Autor: Nivio Ziviani
 */
package Arvore;

public class XAEDsMaps {
    private int peso;
    private int antecessor[];
    private double pDistancia[];
    private double pTempo[];
    private XGrafo grafo;
    public XAEDsMaps (XGrafo grafo) { 
        this.grafo = grafo; 
    }
    public void obterArvoreCMC(int raiz, int destino, String mode) throws Exception {
        XGrafo.Aresta adj = null;
        int n = this.grafo.numVertices();
        this.pDistancia = new double[n]; // peso dos vértices
        this.pTempo = new double[n]; // peso dos vértices
        int vs[] = new int[n+1]; // vértices
        this.antecessor = new int[n];
        for (int u = 0; u < n; u ++) {
            this.antecessor[u] = -1;
            pDistancia[u] = Double.MAX_VALUE; // 1
            pTempo[u] = Double.MAX_VALUE; // 1
            vs[u+1] = u; // Heap indireto a ser construído
        }
        pDistancia[raiz] = 0;
        pTempo[raiz] = 0;
        
        // aplicando o metodo de melhor distancia
        if(mode == "Melhor Distancia") {
            FPHeapMinIndireto heap = new FPHeapMinIndireto (pDistancia, vs);
            heap.constroi();
            while (!heap.vazio()) {
                int u = heap.retiraMin();
                if(!this.grafo.listaAdjVazia(u)) {
                    adj = grafo.primeiroListaAdj(u);
                    while(adj != null) {
                        int v = adj.v2();
                        if((this.pDistancia[v] > (this.pDistancia[u] + adj.pesoDistancia()))) {
                            antecessor[v] = u;
                            heap.diminuiChave(v, this.pDistancia[u] + adj.pesoDistancia());
                        }
                        adj = grafo.proxAdj(u);
                    }
                }
            }
        }
        
        // aplicando o metodo de melhor tempo
        else {
            FPHeapMinIndireto heap = new FPHeapMinIndireto (pTempo, vs);
            heap.constroi();
            while (!heap.vazio()) {
                int u = heap.retiraMin();
                if(!this.grafo.listaAdjVazia(u)) {
                    adj = grafo.primeiroListaAdj(u);
                    while(adj != null) {
                        int v = adj.v2();
                        if((this.pTempo[v] > (this.pTempo[u] + adj.pesoTempo()))) {
                            antecessor[v] = u;
                            heap.diminuiChave(v, this.pTempo[u] + adj.pesoTempo());
                        }
                        adj = grafo.proxAdj(u);
                    }
                }
            }
        }    
    }
    public int antecessor(int u) { 
        return this.antecessor [u]; 
    }
    public double pesoDistancia(int u) { //retorna o peso da melhor distancia
        return this.pDistancia[u];
    }
    public double pesoTempo(int u) { //retorna o peso do melhor tempo
        return this.pTempo[u];
    }
    public int imprimeCaminho(int origem, int v, String mode) {
        if(origem == v) 
            System.out.println(origem);
        else if(this.antecessor[v] == -1)
            System.out.println("Nao existe caminho de " +origem+ " ate " +v);
        else {
            imprimeCaminho(origem, this.antecessor[v], mode);
            System.out.println(v);
        }
       
        if(mode == "Melhor Distancia") 
            return (int) this.pesoDistancia(v);
        else
            return (int) this.pesoTempo(v);
    }
}
