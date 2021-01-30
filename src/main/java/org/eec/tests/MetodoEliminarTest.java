/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.tests;

import org.eec.simplelinkedlisteec.*;
/**
 *
 * @author erick
 */
public class MetodoEliminarTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedListEEC list;
        System.out.println("##--Prueba del método eliminar() <.delete(int val)>--##");
        int[] insertionV = {-5, 7, 15, 253, -12, 26, -35, 9, 101};
        // {26,253, -10550, 21254, -5, 9, -12, 7, -35, 101, 15, 78945, -89562}
        int[] deleteV = {26,253, -10550, 21254, -5, 9, -12, 7, -35, 101, 15, 78945, -89562};
        int iter = 0;
        
        list = new LinkedListEEC();
        System.out.println("Estado inicial de la lista: " + list);
        System.out.println("Agregando valores a la lista...");
        for(int val : insertionV){
            list.add(val);
        }
        System.out.println("DESPUÉS de haber agregado valores a la lista: " + list);
        
        System.out.println("Eliminando valores de la lista...");
        System.out.println("Estado INICIAL de la lista: " + list);
        
        for(int val : deleteV){
            ++iter;
            System.out.println("---------------------------------------------------------------");
            System.out.println("Iteración: " + iter);
            System.out.println(String.format("Eliminando el valor (%d) de la lista...", val));
            list.delete(val);
            System.out.println(String.format("DESPUÉS DE haber eliminado valor (%d), lista ACTUALIZADA: %s", val, list));
        }
    } // fin de método main()
    
}
