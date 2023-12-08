/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.colas;


import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import controlador.TDA.pilas.FulStackException;

/**
 *
 * @author romer
 */
class Queue<E> extends DynamicList<E> {
    private Integer cima;

    public Queue(Integer tope) {
        this.cima = tope;
    }
    
    
    
    public Boolean isFull(){
        return getLenght().intValue()>= cima.intValue();
    }
    
    public void queue (E info) throws EmptyException, FulStackException {
        if (isFull()) {
            throw new FulStackException("Error. Queue vacia");
        } else {
            add(info);
        }
    }
    
    public E dequeue() throws EmptyException{
        E info = extractFirst();
        return info;
    }
}
