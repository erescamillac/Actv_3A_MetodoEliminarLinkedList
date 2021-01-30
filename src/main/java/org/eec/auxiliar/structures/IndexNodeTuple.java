/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.auxiliar.structures;

import org.eec.simplelinkedlisteec.Node;
/**
 *
 * @author erick
 */
public class IndexNodeTuple {
    private int index;
    private Node nodeRef;
    
    public IndexNodeTuple(){
        this.index = -1;
        this.nodeRef = null;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node getNodeRef() {
        return nodeRef;
    }

    public void setNodeRef(Node nodeRef) {
        this.nodeRef = nodeRef;
    }
    
} // fin de clase IndexNodeTuple
