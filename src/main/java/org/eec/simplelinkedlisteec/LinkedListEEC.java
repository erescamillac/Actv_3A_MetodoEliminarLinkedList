/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eec.simplelinkedlisteec;

import org.eec.auxiliar.structures.IndexNodeTuple;
/**
 *
 * @author erick
 */
public class LinkedListEEC {
    private Node startNode;
    private Node lastNode;
    private int length;
    
    public LinkedListEEC(){
        this.startNode = null;
        this.lastNode = null;
        this.length = 0;
    }
    
    // implementar método add();
    
    public int getLength(){
        return length;
    }
    
    public boolean isEmpty(){
        return startNode == null;
    }
    
    public boolean add(int value){
        //System.out.println("...Intentando agregar del valor: " + value);
        Node nodeTmp;
        boolean success;
        nodeTmp = new Node(value);
        
        //System.out.println("...nodeTmp RECIÉN CREADO: " + nodeTmp);
        
        if(isEmpty()){
            //System.out.println("...la lista está vacía se INICIALIZA this.startNode");
            /*SÓLO cuando la lista está VACÍA: 
            * se INICIALIZA .startNode y .lastNode para 'apuntar' al
            * 1er Nodo (ever en la vida)
            */
            this.startNode = nodeTmp; 
            this.lastNode = nodeTmp;
        }else{
            // si la lista NO está vacía
            // 1. ENLAZAR el último nodo con el nodo recién creado (nodeTmp)
            this.lastNode.setNextNode(nodeTmp);
            // 2. DESPUÉS DEL ENLACE, actualizar REF. de .lastNode para que 
            // 'apunte' al Último nodo agregado (nodeTmp)
            this.lastNode = nodeTmp;
        }
       
        success = true;
        ++this.length;
        
        return success;
    }
    
    private boolean isValidIndex(int idx){
        boolean isValid = false;
        if(!isEmpty()){
            isValid = idx >= 0 && idx < this.length;
        }
        return isValid;
    } // fin del método isValidIndex(int )
    
    
    // nodeAt: trabajando correctamente
    private Node nodeAt(int idx){
        Node result = null;
        int idxTmp = -1;
        boolean found = false;
        
        if(isValidIndex(idx)){
            if(!isEmpty()){
                // por lo menos 1 elemento
                result = this.startNode;
                do{
                    ++idxTmp;
                    if(idxTmp == idx){
                        found = true;
                        break;
                    }
                    result = result.getNextNode();
                }while(result != null);
            } // fin if lista NO Vacía
        }
                
        result = !found ? null : result;
        
        return result;
    } // fin nodeAt
    
    // public delete(int targetVal)
    public void delete(int targetVal){
        IndexNodeTuple tuple;
        Node targetNode, previousNode;
        // 1. Primero buscar el targetVal
        tuple = linearSearch(targetVal);
        if(tuple.getIndex() != -1){
            // targetVal FUE ENCONTRADO dentro de la lista
            targetNode = tuple.getNodeRef();
            // Distinguir Caso A: targetNode está al INICIO de la lista
            // Caso B: cualquier posición distinta del INICIO de la lista
            if(tuple.getIndex() == 0){
                // Caso A: targetNode está al INICIO de la lista
                this.startNode = targetNode.getNextNode();
            }else{
                // Caso B: targetNode está en otra Posición distinta del Inicio de la lista
                // ** Primero: Determinar el previousNode
                previousNode = nodeAt(tuple.getIndex() - 1);
                if(previousNode != null){
                    previousNode.setNextNode(targetNode.getNextNode());
                }
            }
            --this.length;
        } // if .getIndex() != -1
    } // fin del método delete()
    
    // comenzar con linearSearch()
    // linearSearc(int) : LISTO para su uso
    public IndexNodeTuple linearSearch(int targetVal){
        //System.out.println("...linearSearch()" + targetVal);
        IndexNodeTuple tuple = new IndexNodeTuple();
        Node currentNode;
        int idxTmp = -1;
        
        if(!isEmpty()){
            // si la lista NO está vacía... continuar con la búsqueda lineal
            // por lo menos 1 elemento en la lista
            currentNode = this.startNode;
            do{
                ++idxTmp;
                //System.out.print(currentNode);
                if(currentNode.getData() == targetVal){
                    // elemento ENCONTRADO
                    tuple.setIndex(idxTmp);
                    tuple.setNodeRef(currentNode);
                    break;
                }
                
                currentNode = currentNode.getNextNode();
            }while(currentNode != null);
        }
        return tuple;
    } // fin del método linearSearch()
    
    // countNodes : devuelve el número de nodos contenidos en la lista
    // countNode : LISTO para usarse
    public int countNodes(){
        Node currentNode;
        int nodesNum = 0;
        if(isEmpty()){
            return 0;
        }else{
            // recorrido lineal y conteo
            // por lo menos 1 elemento (1 nodo)
            currentNode = this.startNode;
            do{
                nodesNum++;
                currentNode = currentNode.getNextNode();
            }while(currentNode != null);
            return nodesNum;
        }
    } // fin de countNodes()
    
    public void showContent(){
        Node currentNode;
        if(isEmpty()){
            System.out.println("{lista VACÍA}");
        }else{
            // implementar recorrido de inicio a fin:
            // hay por lo menos 1 elemento en la lista
            currentNode = this.startNode;
            System.out.print("{");
            do{
                System.out.print(currentNode);
                if(currentNode.getNextNode() != null){
                    System.out.print(", ");
                }
                currentNode = currentNode.getNextNode();
            }while(currentNode != null);
            System.out.print("}\n");
        }
    } // fin del método showContent
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node currentNode;
        if(isEmpty()){
            sb.append("{lista VACÍA}");
        }else{
            // tiene por lo menos 1 elemento:
            currentNode = this.startNode;
            sb.append("{");
            do{
                sb.append(currentNode);
                if(currentNode.getNextNode() != null){
                    sb.append(", ");
                }
                currentNode = currentNode.getNextNode();
            }while(currentNode != null);
            sb.append("}");
        }
        return sb.toString();
    }
} //-- fin de lista LinkedListEEC
