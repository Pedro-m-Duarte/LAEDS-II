/*
 Disponibilizado em Projeto de Algoritmos com implementações em Java e C++
 Autor: Nivio Ziviani
 */
package Arvore;

public class XGrafo {
    public static class Aresta {
        private int v1, v2, pesoDistancia, pesoTempo;
        
        public Aresta(int v1, int v2, int pesoDistancia, int pesoTempo) {
            this.v1 = v1; 
            this.v2 = v2; 
            this.pesoDistancia = pesoDistancia; 
            this.pesoTempo = pesoTempo;
        }
        
        public int pesoDistancia() { 
            return this.pesoDistancia; 
        }
        
        public int pesoTempo() { 
            return this.pesoTempo; 
        }
        
        public int v1() { 
            return this.v1; 
        }
        
        public int v2() { 
            return this.v2; 
        }
    }
    
    private int matD[][]; // pesos da distancia do tipo inteiro
    private int matT[][]; // pesos do tempo do tipo inteiro
    private int numVertices; // numero de vertices
    private int pos[]; // posição atual ao se percorrer os adjs de um vértice v
    
    // inicializar o grafo
    public XGrafo (int numVertices) {
        this.matD = new int[numVertices][numVertices];
        this.matT = new int[numVertices][numVertices];
        this.pos = new int[numVertices]; 
        this.numVertices = numVertices;
        for(int i = 0; i < this.numVertices; i++) {
            for(int j = 0; j < this .numVertices; j++) {
                this.matD[i][j] = 0;
                this.matT[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }
    
    public void insereAresta (int v1, int v2, int pesoD, int pesoT) {
        this.matD[v1][v2] = pesoD; 
        this.matT[v1][v2] = pesoT; 
    }
    
    public boolean existeAresta(int v1, int v2) {
        return (this.matD[v1][v2] > 0 && this.matT[v1][v2] > 0);
    }
    
    public boolean listaAdjVazia (int v) {
        for(int i =0; i < this.numVertices; i++)
            if(this.matD[v][i] > 0 && this.matT[v][i] > 0) 
                return false;
        return true;
    }
    
    public Aresta primeiroListaAdj(int v) {
        // Retorna a primeira aresta que o vértice v participa ou
        // null se a lista de adjacência de v for vazia
        this.pos[v] = -1; 
        return this.proxAdj(v);
    }
    
    public Aresta proxAdj(int v) {
        // Retorna a próxima aresta que o vértice v participa ou
        // null se a lista de adjacência de v estiver no fim
        this.pos[v]++;
        while((this.pos[v] < this.numVertices) && (this.matD[v][this.pos[v]] == 0) && (this.matT[v][this.pos[v]] == 0))
            this.pos[v]++;
        if(this.pos[v] == this.numVertices) 
            return null;
        else 
            return new Aresta(v, this.pos[v], this.matD[v][this.pos[v]], this.matT[v][this.pos[v]]); // Aresta que está sendo procurada
    }
    
    public Aresta retiraAresta(int v1, int v2) {
        if(this.matD[v1][v2] == 0 && this.matT[v1][v2] == 0) 
            return null ; // Aresta não existe
        else {
            Aresta aresta = new Aresta(v1, v2, this.matD[v1][v2], this.matT[v1][v2]);   
            this.matD[v1][v2] = 0; 
            this.matT[v1][v2] = 0;
            return aresta;
        }   
    }
    
    public void imprime() {
        System.out.print("    ");
        for(int i = 0; i < this.numVertices; i++)
            System.out.print (i + "   ");
        System.out. println();
        for(int i = 0; i < this .numVertices; i++) {
            System.out.print(i + "  ");
            for(int j = 0; j < this .numVertices; j++) {
                System.out.print(this.matD[i][j] + " " + this.matT[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int numVertices() {
        return this.numVertices;
    }
}