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
public class NodoS<T> {
    
    private T info;
    
    private int key;
    
    private NodoS anterior;
    private NodoS siguiente;
    private NodoS superior;
    private NodoS inferior;
    
    public NodoS(){
    
    }
    public NodoS(T info, int key) {
      this.validarKey(key);
      this.info = info;
      this.key = key;
      this.anterior = null;
      this.siguiente = null;
      this.superior = null;
      this.inferior = null;
    }
    
    private void validarKey(int key){
        if(key <0 || key > Integer.MAX_VALUE) throw new RuntimeException("key no valida");
    }
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    
    public NodoS getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoS anterior) {
        this.anterior = anterior;
    }

    public NodoS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoS siguiente) {
        this.siguiente = siguiente;
    }

    public NodoS getSuperior() {
        return superior;
    }

    public void setSuperior(NodoS superior) {
        this.superior = superior;
    }

    public NodoS getInferior() {
        return inferior;
    }

    public void setInferior(NodoS inferior) {
        this.inferior = inferior;
    }
}
