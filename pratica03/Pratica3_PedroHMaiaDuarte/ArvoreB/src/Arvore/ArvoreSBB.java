/*
 Disponibilizado em Projeto de Algoritmos com implementações em Java e C++
 Autor: Nivio Ziviani
 */
package Arvore;

import File.CreateTextFile;
import Item.Item;

public class ArvoreSBB {
    public static class No {
        Item reg;
        No esq, dir;
        byte incE, incD;
    }
    
    private No noRaiz;
    private boolean propSBB;
    private static final byte Horizontal = 0;
    private static final byte Vertical = 1;
    private int ContadorDeComparacoes;
    
    //Inicializar arvore
    public ArvoreSBB() {
        this.noRaiz = null;
        this.propSBB = true;
        this.ContadorDeComparacoes = 0;
    }
    
    private No ee(No ap) 
    {
        No ap1 = ap.esq;
        ap.esq = ap1.dir;
        ap1.dir = ap;
        ap1.incE = Vertical;
        ap.incE = Vertical;
        ap = ap1;
        return ap;
    }
    
    private No ed(No ap) 
    {
        No ap1 = ap.esq;
        No ap2 = ap1.dir;
        ap1.incD = Vertical;
        ap.incE = Vertical;
        ap1.dir = ap2.esq;
        ap2.esq = ap1;
        ap.esq = ap2.dir;
        ap2.dir = ap;
        ap = ap2;
        return ap;
    }
    
    private No dd(No ap) 
    {
        No ap1 = ap.dir;
        ap.dir = ap1.esq;
        ap1.esq = ap;
        ap1.incD = Vertical;
        ap.incD = Vertical;
        ap = ap1;
        return ap;
    }
    
    private No de(No ap) 
    {
        No ap1 = ap.dir;
        No ap2 = ap1.esq;
        ap1.incE = Vertical;
        ap.incD = Vertical;
        ap1.esq = ap2.dir;
        ap2.dir = ap1;
        ap.dir = ap2.esq;
        ap2.esq = ap;
        ap = ap2;
        return ap;
    }
    
    private No insereItem(Item reg, No pai, No filho, boolean filhoEsq)
    {
        if(filho == null)
        {
            filho = new No();
            filho.reg = reg;
            filho.incE = Vertical;
            filho.incD = Vertical;
            filho.esq = null;
            filho.dir = null;
            
            if(pai != null)
                if(filhoEsq)
                    pai.incE = Horizontal;
                else
                    pai.incD = Horizontal;
            
            this.propSBB = false;
        }
        else if (reg.compara(filho.reg) < 0)
        {
            filho.esq = insereItem(reg, filho, filho.esq, true);
            if(!this.propSBB)
                if(filho.incE == Horizontal)
                {
                    if(filho.esq.incE == Horizontal)
                    {
                        filho = this.ee(filho);                        // transformacao esquerda-esquerda
                        if(pai != null)
                            if(filhoEsq)
                                pai.incE = Horizontal;
                            else
                                pai.incD = Horizontal;
                    }
                    else if(filho.esq.incD == Horizontal)
                    {
                        filho = this.ed(filho);                        // transformacao esquerda-direita
                        if(pai != null)
                            if(filhoEsq)
                                pai.incE = Horizontal;
                            else
                                pai.incD = Horizontal;
                    }
                }
                else 
                    this.propSBB = true;
        }
        else if (reg.compara(filho.reg) > 0)
        {
            filho.dir = insereItem(reg, filho, filho.dir, false);
            if(!this.propSBB)
                if(filho.incD == Horizontal)
                {
                    if(filho.dir.incD == Horizontal)
                    {
                        filho = this.dd(filho);                        // transformacao direita-direita
                        if(pai != null)
                            if(filhoEsq)
                                pai.incE = Horizontal;
                            else
                                pai.incD = Horizontal;
                    }
                }
            else
                this.propSBB = true;
        }
        else
        {
            System.out.println("Erro: Registro ja existente");
            this.propSBB = true;
        }
        return filho;
    }
    
    //inserir elemento 'reg'
    public void insere(Item reg)
    {
        this.noRaiz = this.insereItem(reg, null, this.noRaiz, true);
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
    
    public Item pesquisa(Item reg)
    {
        return this.PesquisaItem(reg, this.noRaiz);
    }
    
   public void gravaDados(int n, int contadorDeComparacoes, long tempoGasto, String nomeArquivo)
   {
       String string = "Arvore: "+n+" Tempo Gasto para fazer a procura: "+tempoGasto+"(nano segundos)"+" Numero de Comparacoes: "+contadorDeComparacoes+"\n";
       CreateTextFile.escrever(string, nomeArquivo);
   }

    public int getContadorDeComparacoes() {
        return ContadorDeComparacoes;
    }

}