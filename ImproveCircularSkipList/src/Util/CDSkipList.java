/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.util.Random;

/**
 *
 * @author garci
 * @param <T>
 */
public class CDSkipList<T extends Comparable> {
    
    private NodoS<T> centinela;
    private int size = 0;
    private int altura = -1;
    private Random random = new Random();

    public CDSkipList() {
        this. centinela = new NodoS();
        this.centinela.setAnterior(centinela);
        this.centinela.setSiguiente(centinela);
        this.centinela.setSuperior(centinela);   
    }
    
    public NodoS<T> buscar(int key){
        this.validarKey(key);
        if(this.estaVacia()) return this.centinela;
        
        NodoS<T> aux = this.centinela;
        if(aux.getInferior().getSiguiente().getKey() <= key && aux.getInferior().getAnterior().getKey() < key){
            
            while(aux.getInferior() != null){
                aux = aux.getInferior();
                while( aux.getSiguiente().getKey()<= key && aux.getSiguiente().getKey()!= 0 ){
                    aux = aux.getSiguiente();
                }
            }
        }else{
            while(aux.getInferior() != null){
                aux = aux.getInferior();
                while(aux.getAnterior().getKey()>= key && aux.getAnterior()!= this.centinela){
                    aux = aux.getAnterior();
                }
            }
        }
        if(aux.getKey() > key) return aux.getAnterior();
        return aux;
    }
    
    public NodoS insertar(T info,int key){
        this.validarKey(key);
        NodoS<T> posicion = buscar(key);
        NodoS<T> aux = null;
        NodoS<T> ultimo;
        
        int nivel =-1;
        
        if(posicion.getKey() == key){
            return posicion;
        }
        do{
            nivel++;
            aumentarAltura(nivel);
            ultimo = aux;
            aux = insertarDelante(info,posicion,key);
           
            if(nivel > 0){
               aux.setInferior(ultimo);
            }
            while(posicion.getSuperior() == null){
                posicion = posicion.getAnterior(); 
            }
            posicion = posicion.getSuperior(); 
        }while(random.nextBoolean()== true);
       return aux;
    }
    private NodoS insertarDelante(T info,NodoS<T> posicion,int key){
        NodoS<T> nuevo = new NodoS(info,key);
        NodoS<T> nodoAnterior = posicion;
        
        nuevo.setAnterior(nodoAnterior);
        nuevo.setSiguiente(nodoAnterior.getSiguiente());
        nodoAnterior.setSiguiente(nuevo);
        nuevo.getSiguiente().setAnterior(nuevo);
        this.size++;
        return nuevo;
    }
    private void aumentarAltura(int nivel){
        if(nivel >= this.altura){
            this.altura++;
            aumentarNivel();
        }
    }
    
    private void aumentarNivel(){
        NodoS<T> nuevoCentinela = new NodoS<>();
        
        nuevoCentinela.setSiguiente(nuevoCentinela);
        nuevoCentinela.setAnterior(nuevoCentinela);
        nuevoCentinela.setInferior(this.centinela);
        
        this.centinela.setSuperior(nuevoCentinela);
        this.centinela = nuevoCentinela;
    }
    public boolean estaVacia(){
        return this.size == 0;
    }
    private void validarKey(int key){
        if(key <1 || key > Integer.MAX_VALUE) throw new RuntimeException("key no valida");
    }

    
    public String toString1() {
        StringBuilder string = new StringBuilder();
        NodoS<T> aux = this.centinela;
        int nivel = this.altura;
        while(aux.getInferior() != null){
            string.append("nivel: ").append(nivel--).append("\n");
                while(aux.getSiguiente().getInfo()!= null){
                    aux = aux.getSiguiente();
                    if(aux.getInfo() == null){
                        string.append("centinela").append("->");

                    }else{
                        string.append(aux.getInfo().toString()).append("->");

                    }
                    
                }
           
            aux = aux.getInferior();
        }    
        return string.toString();
    }

    
    public String toString() {
        NodoS<T> aux = this.centinela;
        int levels = altura;
        StringBuilder string = new StringBuilder();
        while(aux.getInferior() != null){
            aux = aux.getInferior();
            string.append("nivel: ").append(levels--).append("\n");
        }
        while(aux.getSiguiente().getInfo()!= null){
            aux = aux.getSiguiente();
            if(aux.getInfo() == null){
               string.append("null->");
            }else{
            string.append(aux.getInfo().toString()).append("->");
            }
        }
        return string.toString();
    }
    
    
}
