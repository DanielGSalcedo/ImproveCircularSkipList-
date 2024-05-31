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
public class NodoS<T extends Comparable> {
    
    private T info;
    private NodoS anterior;
    private NodoS siguiente;
    private NodoS superior;
    private NodoS inferior;
    
    public NodoS(){
    
    }
    public NodoS(T info) {
      this.info = info;
      this.anterior = null;
      this.siguiente = null;
      this.superior = null;
      this.inferior = null;
    }
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
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

    @Override
    public String toString() {
        return "NodoS{" + "info=" + info + '}';
    }
    
}
