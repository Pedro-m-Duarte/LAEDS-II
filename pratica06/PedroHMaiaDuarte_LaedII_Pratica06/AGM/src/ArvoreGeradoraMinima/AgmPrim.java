/*
 Disponibilizado em Projeto de Algoritmos com implementações em Java e C++
 Autor: Nivio Ziviani
 */
package ArvoreGeradoraMinima;

// implementar o algoritmo de Prim (FPHeapMinIndireto
public class AgmPrim {
    private double pesoTotal;
    private int antecessor[];
    private double p[];
    private XGrafo grafo;
    public AgmPrim (XGrafo grafo ) throws Exception { 
        this.grafo = grafo; 
        this.pesoTotal = 0;
    }
    
    // contrucao da AGM
    public void obterAgm (int raiz ) throws Exception {
        int n = this.grafo.numVertices();
        //System.out.println(n);
        this.p = new double[n] ; // peso dos vértices
        int vs[] = new int [n+1]; // vértices
        boolean itensHeap[] = new boolean[n]; 
        this.antecessor = new int [n];
        for (int u = 0; u < n; u ++) {
            this .antecessor [u] = -1;
            p[u] = Double.MAX_VALUE; // 1
            vs[u+1] = u; // Heap indireto a ser construído
            itensHeap[u] = true;
        }
        p[raiz] = 0;
        FPHeapMinIndireto heap = new FPHeapMinIndireto (p, vs); //cria o heap - algoritmo de Prim
        heap.constroi();    // constroi o heap
        while (!heap.vazio()) {
            int u = heap.retiraMin(); 
            itensHeap[u] = false;
            if(! this.grafo.listaAdjVazia(u)) {
                XGrafo.Aresta adj = grafo.primeiroListaAdj(u);      // cria um novo grafo (minimo)
                while (adj != null ) {
                    int v = adj.v2();
                    if(itensHeap[v] && (adj.peso() < this.peso(v))) {
                        antecessor [v] = u;                         // salva os vertices antecessores
                        heap.diminuiChave(v, adj.peso());           // diminui os pesos     
                    }
                    adj = grafo.proxAdj(u) ;
                }
            }
        }
    }
    public int antecessor (int u) { 
        return this.antecessor[u]; 
    }
    public double peso (int u) { 
        return this.p[u]; 
    }
    public void imprime () {
        for (int u = 0; u < this.p.length; u++)
            if(this.antecessor [u] != -1)
                    System.out.println(" ( " +antecessor [u]+ " , " +u+ ") −− p: " +  peso(u));
    }
    
    public double getPeso() {
        for (int u = 0; u < this.p.length; u++)
            if(this.antecessor [u] != -1)
                    this.pesoTotal += peso(u);
        
        return this.pesoTotal;
    }
}
