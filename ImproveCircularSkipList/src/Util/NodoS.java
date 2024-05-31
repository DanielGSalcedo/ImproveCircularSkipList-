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
@SuppressWarnings("rawtypes")
public class NodoS<T extends Comparable> {
    
    private T info;
    private NodoS<T> anterior;
    private NodoS<T> siguiente;
    private NodoS<T> superior;
    private NodoS<T> inferior;
    private NodoS<T> original;
    
    public NodoS(){
    
    }
    public NodoS(T info) {
      this.info = info;
      this.anterior = null;
      this.siguiente = null;
      this.superior = null;
      this.inferior = null;
      this.original = null;
    }
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    
    public NodoS<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoS<T> anterior) {
        this.anterior = anterior;
    }

    public NodoS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoS<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoS getSuperior() {
        return superior;
    }

    public void setSuperior(NodoS<T> superior) {
        this.superior = superior;
    }

    public NodoS getInferior() {
        return inferior;
    }

    public void setInferior(NodoS<T> inferior) {
        this.inferior = inferior;
    }

    public NodoS getOriginal() {
        return this.original;
    }

    public void setOriginal(NodoS<T> original) {
        this.original = original ;
    }

    @Override
    public String toString() {
        return "NodoS{" + "info=" + info + '}';
    }
    
}
