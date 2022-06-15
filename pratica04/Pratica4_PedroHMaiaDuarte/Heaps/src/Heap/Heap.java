/*
 Disponibilizado em Projeto de Algoritmos com implementações em Java e C++
 Autor: Nivio Ziviani
 */
package Heap;

import File.CreateTextFile;
import Item.Item;

    public class Heap {
       
        private Item v [] ;
        private int n;
        private int comparacoes;
        
        public Heap (Item v []) {
            this.v = v; 
            this.n = this.v.length - 1;
            this.comparacoes = 0;
        }
        
//        public  void refaz (int esq, int dir);
//        public  void constroi ();
//        public  Item max ();
        
        public Item max() {
            return this.v[1];
        }
        
        public void refaz(int esq, int dir) {
            int j = esq * 2; 
            Item x = this.v[esq];
            
            while (j <= dir) {
                if((j < dir) && (this.v[j].compara(this.v[j+1]) < 0)){
                    j++;
                }
                this.comparacoes++; //log(n) no pior caso
                if(x.compara(this.v[j]) >= 0) {
                    break;
                }
                this.v[esq] = this.v[j] ;
                esq = j ; 
                j = esq * 2;
            }
            this.v[esq] = x;
        }
        
        public void constroi() {
            int esq = n/2 + 1;
            while (esq > 1) {
                esq--;
                this.refaz(esq, this.n);
            }
        }
        
        public void gravaDados(int n, int contadorDeComparacoes, String nomeArquivo)
        {
            String string = "Heap: "+n+" Numero de Comparacoes: "+contadorDeComparacoes+"\n";
            CreateTextFile.escrever(string, nomeArquivo);
        }

        public int getComparacoes() {
            return comparacoes;
        }

        public void setComparacoes(int comparacoes) {
            this.comparacoes = comparacoes;
        }
}