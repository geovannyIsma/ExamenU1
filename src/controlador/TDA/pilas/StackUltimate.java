/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.pilas;

import controlador.TDA.listas.Exception.EmptyException;

/**
 *
 * @author romer
 */
public class StackUltimate<E> {
    private Stack<E> stack;

    public StackUltimate(Integer lenght) {
        this.stack = new Stack<>(lenght);
    }
    
    public void push(E info) throws EmptyException, FulStackException{
        stack.push(info);
    }
    public  E pop() throws EmptyException{
        return stack.pop();
    }
    
    public Integer lenght(){
        return stack.getLenght();
    }
    
    public Boolean isFull(){
        return stack.isFull();
    }
    
    public void print(){
        System.out.println("Stack");
        System.out.println(stack.toString());
        System.out.println("");
    }
    
}
