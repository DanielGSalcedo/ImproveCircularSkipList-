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
@SuppressWarnings("rawtypes")
public class CDSkipList<T extends Comparable> {
    
    private NodoS<T> centinelaV;
    private int size = 0;
    private int altura = -1;
    private Random random = new Random(); 

    public CDSkipList() {
        this. centinelaV = new NodoS<>();
        this.centinelaV.setAnterior(centinelaV);
        this.centinelaV.setSiguiente(centinelaV);
        this.centinelaV.setSuperior(centinelaV);   
    }
    
    @SuppressWarnings("unchecked")
    public NodoS<T> buscar( T info){
        if(this.estaVacia()) return this.centinelaV;
        
        NodoS<T> aux = this.centinelaV;
        
        if(aux.getInferior().getSiguiente().getInfo().compareTo(info)>= 0){
            
            while(aux.getInferior() != null){
                aux = aux.getInferior();
                while(aux.getSiguiente().getInfo()!= null && aux.getSiguiente().getInfo().compareTo(info) <= 0 ){
                    aux = aux.getSiguiente();
                    if(aux.getInfo().compareTo(info)== 0){
                        return aux.getOriginal();
                    }
                }
            }
        }else{
            while(aux.getInferior() != null){
                aux = aux.getInferior();
                while(aux.getAnterior().getInfo().compareTo(info) >= 0&& aux.getAnterior()!= this.centinelaV){
                    aux = aux.getAnterior();
                    if(aux.getInfo().compareTo(info)== 0){
                        return aux.getOriginal();
                    }
                }
            }
        }
        if(aux.getInfo()== null || aux.getInfo().compareTo(info) > 0) return aux.getAnterior();
        return aux;
    }
    
    @SuppressWarnings("unchecked")
    public NodoS insertar(T info){
        
        NodoS<T> posicion = buscar(info);
        NodoS<T> aux = null;
        NodoS<T> ultimo;
        
        int nivel =-1;
        
        if(posicion.getInfo() != null && posicion.getInfo().compareTo(info) == 0){
            return posicion;
        }
        do{
            nivel++;
            aumentarAltura(nivel);
            ultimo = aux;
            aux = insertarDelante(info,posicion);
            if(nivel == 0){
                aux.setOriginal(aux);
            }
            if(nivel > 0){
               aux.setInferior(ultimo);
               aux.setOriginal(ultimo.getOriginal());
               ultimo.setSuperior(aux);
            }
            while(posicion.getSuperior() == null){
                posicion = posicion.getAnterior(); 
            }
            posicion = posicion.getSuperior(); 
        }while(random.nextBoolean()== true);
       return aux;
    }
    @SuppressWarnings("unchecked")
    private NodoS insertarDelante(T info,NodoS<T> posicion){
        NodoS<T> nuevo = new NodoS(info);
        NodoS<T> nodoAnterior = posicion;
        
        nuevo.setAnterior(nodoAnterior);
        nuevo.setSiguiente(nodoAnterior.getSiguiente());
        nodoAnterior.setSiguiente(nuevo);
        nuevo.getSiguiente().setAnterior(nuevo);
        this.size++;
        return nuevo;
    }
    private void aumentarAltura(int nivel){
        if(nivel > this.altura){
            this.altura++;
            aumentarNivel();
        }
    }
    
    private void aumentarNivel(){
        NodoS<T> nuevoCentinela = new NodoS<>();
        
        nuevoCentinela.setSiguiente(nuevoCentinela);
        nuevoCentinela.setAnterior(nuevoCentinela);
        nuevoCentinela.setInferior(this.centinelaV);
        
        this.centinelaV.setSuperior(nuevoCentinela);
        this.centinelaV = nuevoCentinela;
    }
    public boolean estaVacia(){
        return this.size == 0;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public String toString() {
        StringBuilder string = new StringBuilder();
        NodoS<T> aux = this.centinelaV;
        int nivel = (1+this.altura);
        string.append("nivel: ").append(nivel--).append("\n").append("empty level");
        while(aux.getInferior() != null){
            aux = aux.getInferior();
            string.append("\nnivel: ").append(nivel--).append("\n");
                while(aux.getSiguiente().getInfo()!= null){
                    aux = aux.getSiguiente();
                    string.append(aux.getInfo().toString()).append("->");
                }
            if(aux.getSiguiente().getInfo()== null)aux = aux.getSiguiente();
            
        }
        return string.toString();
    }
    
}
