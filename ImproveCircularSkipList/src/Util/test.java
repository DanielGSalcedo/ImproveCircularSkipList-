/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Util;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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
       for(Integer i = 1; i< 6000000;i++){
           lista.insertar(i);
       }
       lista.insertar(9);
       lista.insertar(10);
       lista.insertar(8);
       
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        pw.println(lista.toString());
        
        pw.flush(); 
        pw.close();
      //System.out.println(lista.buscar(8));
      //System.out.println(lista.toString());
      
    }
    
}
