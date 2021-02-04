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
public class ReverseListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--Test del método .reverse()");
        LinkedListEEC reversedList, list = new LinkedListEEC();
        int[] values = {502, -125, 364, 228};
        for(int val : values){
            list.add(val);
        }
        System.out.println("Original list : " + list);
        reversedList = list.reverse();
        System.out.println("REVERSED list : " + reversedList);
    } // fin del método main()
    
}
