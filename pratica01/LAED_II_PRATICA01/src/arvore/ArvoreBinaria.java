/*
 Disponibilizado em Projeto de Algoritmos com implementações em Java e C++
 Autor: Nivio Ziviani
 */
package arvore;

import file.CreateTextFile;
import item.Item;

public class ArvoreBinaria {
    public static class No {
        Item reg;
        No esq, dir;
    }
    
    private No noRaiz;
    private int ContadorDeComparacoes;
    
    //Inicializar arvore
    public ArvoreBinaria() {
        this.noRaiz = null;
        this.ContadorDeComparacoes = 0;
    }
    
    //inserir elemento 'reg'
    private No InsereItem(Item reg, No p)
    {
        //se o no é nulo
        if(p == null) {
            p = new No();
            p.reg = reg;
            p.esq = null;
            p.dir = null;
        }
        //elemento menor eh inserido a esquerda
        else if (reg.compara(p.reg) < 0)
            p.esq = InsereItem(reg, p.esq);
        //elemento maior eh inserido a direta
        else if (reg.compara(p.reg) > 0)
             p.dir = InsereItem(reg, p.dir);
        //elemento igual
        else 
            System.out.println("Erro: Registro ja existente");
        return p;
    }
    
    public void insere(Item reg)
    {
        this.noRaiz = this.InsereItem(reg, this.noRaiz);
    }
    
    //realizar a busca do elemento 'reg'
    private Item PesquisaItem(Item reg, No p)
    {
        //se o no é nulo
        if(p == null)
            return null;
        //elemento menor
        else if (reg.compara(p.reg) < 0)
        {
            ContadorDeComparacoes++;
            return PesquisaItem(reg, p.esq);
        }
        //elemento maior
        else if (reg.compara(p.reg) > 0)
        {
            ContadorDeComparacoes++;
            return PesquisaItem(reg, p.dir);
        }
            
        //elemento igual
        else 
            return p.reg;
    }
    
    public int pesquisa(Item reg)
    {
        this.PesquisaItem(reg, this.noRaiz);
        return this.ContadorDeComparacoes;
    }
    
    public No getNoRaiz() {
        return noRaiz;
    }

    public void setNoRaiz(No noRaiz) {
        this.noRaiz = noRaiz;
    }

   public void gravaDados(int n, int contadorDeComparacoes, long tempoGasto, String nomeArquivo)
   {
       String string = "Arvore: "+n+" Tempo Gasto para fazer a procura: "+tempoGasto+"(nano segundos)"+" Numero de Comparacoes: "+contadorDeComparacoes+"\n";
       CreateTextFile.escrever(string, nomeArquivo);
   }
}
