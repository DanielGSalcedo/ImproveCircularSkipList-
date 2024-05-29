/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author garci
 * @param <T>
 */
public class CDSkipList<T extends Comparable> {
    
    private NodoS<T> centinela;
    private int size = 0;
    private int altura = -1;

    public CDSkipList() {
        this. centinela = new NodoS();
        this.centinela.setAnterior(centinela);
        this.centinela.setSiguiente(centinela);
        this.centinela.setSuperior(centinela);
        this.centinela.setInferior(centinela);
        
    }
    
    public NodoS<T> buscar(int key){
        this.validarKey(key);
        if(this.estaVacia()) throw new RuntimeException("la lista esta vacia");
        
        NodoS<T> aux = this.centinela;
        if(aux.getInferior().getSiguiente().getKey() < key && aux.getInferior().getAnterior().getKey() < key){
            
            while(aux.getInferior() != null){
                aux = aux.getInferior();
                while(aux == this.centinela |( aux.getKey()< key && aux.getSiguiente() != this.centinela)){
                    aux = aux.getSiguiente();
                    if(aux.getKey() == key ) return aux;
                }
            }
        }else{
            while(aux.getInferior() != null){
                aux = aux.getInferior();
                while(aux == this.centinela | (aux.getKey()> key && aux.getAnterior().getKey()> key && aux.getAnterior()!= this.centinela) ){
                    aux = aux.getAnterior();
                    if(aux.getKey() == key ) return aux;
                    while(aux.getAnterior().getKey() < key && aux.getInferior() != null ){
                        aux = aux.getInferior();
                    }
                }
            }
        }
        if(aux.getKey() > key) return aux.getAnterior();
        return aux;
    }
    
    public T insertar(T info,int key){
        
       return null;
    }
    
    public boolean estaVacia(){
        return this.size == 0;
    }
    private void validarKey(int key){
        if(key <0 || key > Integer.MAX_VALUE) throw new RuntimeException("key no valida");
    }
}
