/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Util;

/**
 *
 * @author garci
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CDSkipList<Integer> lista = new CDSkipList<>();
       
        
        //System.out.println(lista.buscar(3).toString());
       for(int i = 1; i< 8;i++){
           lista.insertar(i, i);
       }
       lista.insertar(9, 9);
       lista.insertar(10, 10);
       lista.insertar(8,8);
      System.out.println(lista.buscar(8));
      System.out.println(lista.toString());
      
    }
    
}
