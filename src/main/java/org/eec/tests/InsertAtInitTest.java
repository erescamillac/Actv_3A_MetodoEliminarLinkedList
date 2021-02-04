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
public class InsertAtInitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedListEEC list = new LinkedListEEC();
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("Lista recién CREADA : " + list);
        for(int val : values){
            System.out.println("Insertando el valor : " + val + "...");
            list.insertAtInit(val);
            System.out.println(String.format("DESPUÉS de haber insertado el valor (%d) AL INICIO de la lista : [%s]", val, list));
        }
    } // fin de método main()
    
}
