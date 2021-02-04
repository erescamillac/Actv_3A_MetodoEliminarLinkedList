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
    // guardar PreviousNode!!!
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
    
    
    // con propositos de Test ÚNICAMENTE, después eliminar este método.
    public Node getLastNode(){
        return this.lastNode;
    }
    
    // método insertAtInit(int value) : inserta el valor indicado AL INICIO de la lista
    // Cada vez que un valor es insertado al INICIO de la lista
    // el resto de los nodos SON "RECORRIDOS" hacia la DERECHA.
    public void insertAtInit(int val){
        Node formerStartNode, nodeTmp = new Node(val);
        if(isEmpty()){
            this.startNode = nodeTmp;
            this.lastNode = nodeTmp;
        }else{
            formerStartNode = this.startNode;
            // UPDATE this.startnode to point to the "new Node" (nodeTmp)
            this.startNode = nodeTmp;
            nodeTmp.setNextNode(formerStartNode);
            /*
            No es necesario actualizar this.lastNode ya que la inserción
            del nuevo nodo se hace AL INICIO de la lista.
            (Y no al final como sucede con el método .add(int val))
            */
        }
    } // fin del método insertAtInit()
    
    // TODO: actualizar this.lastNode
    // .deleteV2(int targetVal) : status : OK - Production READY!!
    // metódo .deleteV2(int targetVal) : LISTO para USO en PRODUCCIÓN
    // TODO : deprecate .delete(int targetVal) method (corregir lógica interna del método para ACTUALIZACIÓN de this.lastNode)
    public void deleteV2(int targetVal){
        Node currentNode, previousNode, matchedNode;
        // Pruba de concepto de conservación del nodo Previo y el nodo 'actual'
        // System.out.println("....dentro de .deleteV2(int targetVal)");
        boolean found = false;
        int idxTmp;
        
        if(!isEmpty()){
            // la lista actual tiene por lo menos 1 nodo
            currentNode = this.startNode;
            // previousNode = null;
            matchedNode = null;
            idxTmp = -1;
            
            do{
                ++idxTmp;
                if(idxTmp == 0){
                    // SI es la "primera" Iteración
                    previousNode = null;
                    currentNode = this.startNode;
                }else{
                    previousNode = currentNode;
                    currentNode = currentNode.getNextNode();
                }
                
                if(currentNode != null){
                    //--INI: Búsqueda normal:
                    /*
                    System.out.println("Idx : " + idxTmp);
                    System.out.println("previousNode : " + previousNode);
                    System.out.println("currentNode : " + currentNode);
                    System.out.println("-------------------------------------------------");
                    System.out.println(String.format("currentNode.data[%d] VS targetValue[%d]...", currentNode.getData(), targetVal));
                    */
                    
                    if(currentNode.getData() == targetVal){
                        // System.out.println(String.format("MATCH!!! entre [%d] y [%d]", currentNode.getData(), targetVal));
                        found = true;
                        matchedNode = currentNode;
                        // System.out.println("Matched Node : " + matchedNode);
                        break;
                    }
                    
                    /*
                    System.out.println("IDX : " + idxTmp);
                    System.out.println("previousNode: " + previousNode);
                    System.out.println("currentNode: " + currentNode);
                    System.out.println("-------------------------------------------------");
                    */
                    
                    //++FIN : Bpusqueda normal
                }
                /*
                else{
                    System.out.println("previous (Node) : " + previousNode);
                    System.out.println("currentNode is NULL!");
                }  
                */
                
                /*
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
                */
                
            }while(currentNode != null);
            
            if(found){
                /*
                System.out.println(String.format("El valor [%d] fue encontrado.", targetVal));
                System.out.println("previousNode : " + previousNode);
                System.out.println("matchedNode : " + matchedNode);
                */
                
                // SI previousNode == null : SIGNIFICA QUE el matchedNode debe SER EL PRIMER NODO
                // (nodo en el "index" : '0' -Zero-)
                if(matchedNode != null){
                    // -- not null
                    if(previousNode == null){
                        // matchedNode es el PRIMERO de la lista
                        // CASO A: matchedNode se en encuentra AL INICIO DE LA LISTA
                        // BASTA CON ACTUALIZAR .startNode
                        this.startNode = matchedNode.getNextNode();
                    }else{
                        // si previousNode != null : SIGNIFICA que el matchedNode NO es el primero de la lista
                        // CASO B: matchedNode se encuentra en cualquier OTRA POSICIÓN DISTINTA del INICIO de la LISTA
                        previousNode.setNextNode(matchedNode.getNextNode());
                    }
                    // ++ not null
                    // VALIDAR SI matchedNode es el ÚLTIMO NODO DE LA LISTA:
                    if(matchedNode.getNextNode() == null){
                        // matchedNode ES el ÚLTIMO NODO de la LISTA
                        // SE REQUIERE ACTUALIZAR .lastNode
                        this.lastNode = previousNode;
                    }
                    this.length--;
                } // fin not null
                
            }else{
                System.out.println(String.format("El valor [%d] NO fue ENCONTRADO en la lista.", targetVal));
                // si el valor targetVal NO es ENCONTRADO en la lista: simplemente hacer NADA.
            }
        }else{
            System.out.println("La lista está VACÍA!");
        }
    } // fin del método 
    
    public LinkedListEEC reverse(){
        // System.out.println("Dentro del método .reverse()...");
        LinkedListEEC reversedList = new LinkedListEEC();
        Node currentNode;
        int currentVal;
        if(!isEmpty()){
            // se garantiza que la lista "original" tiene POR LO MENOS 1 Nodo.
            currentNode = this.startNode;
            do{
                // System.out.println("currentNode: " + currentNode);
                currentVal = currentNode.getData();
                // funcionalidad real en .insertAtInit(int val)
                reversedList.insertAtInit(currentVal);
                currentNode = currentNode.getNextNode();
            }while(currentNode != null);
        }
        return reversedList;
    } // fin del método reverse
    
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
