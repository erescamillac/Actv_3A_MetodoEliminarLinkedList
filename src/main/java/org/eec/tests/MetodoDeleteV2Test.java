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
public class MetodoDeleteV2Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedListEEC list = new LinkedListEEC();
        int[] values = {-95, 30, 23, 56, 154};
        int[] deleteValues = {23, -95, 154, 15645, 30, 20567, 56, 56789, 60745};
        int iteracion = -1;
        /*
        {23, -95, 154, 15645, 30, 20567, 56, 56789, 60745}
        */
        
        for(int val : values){
            list.add(val);
        }
        System.out.println("Estado INCIAL de la lista : " + list);
        
        System.out.println("##--Prueba de .deleteV2(int targetVal)");
        for(int deleteVal : deleteValues){
            ++iteracion;
            System.out.println("#############################################");
            System.out.println("Iteración : " + iteracion);
            System.out.println(String.format("Intentando eliminar el valor [%d]...", deleteVal));
            System.out.println(String.format("ANTES de eliminar el valor [%d], LISTA : [%s]", deleteVal, list));
            System.out.println(".lastNode : " + list.getLastNode());
            list.deleteV2(deleteVal);
            System.out.println(String.format("DESPUÉS de eliminar el valor [%d], LISTA : [%s]", deleteVal, list));
            System.out.println(".lastNode : " + list.getLastNode());
            System.out.println("#############################################");
        }
        /*
        System.out.println("ANTES DE ELIMINAR EL VALOR (23), lista : " + list);
        list.deleteV2(23);
        System.out.println("DESPUÉS DE ELIMINAR EL VALOR (23), lista : " + list);
        */
        
    } // fin de método main()
    
}
