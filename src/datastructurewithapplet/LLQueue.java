/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurewithapplet;

/**
 *
 * @author Umut
 */
public class LLQueue {
    LinkedList ls;

    public LLQueue() {
        ls = new LinkedList();
    }
    
    void push(int i){
        ls.addRight(new Node(i));
    }
    
    Integer dequeue(){
        Integer temp = null;
        if(ls.head != null){
            temp = ls.head.number;
            ls.deleteLeft();
        }
        return temp;
    }
    
    Integer peek(){
        if(ls.head != null){
            return ls.head.number;
        }
        return null;
    }
    public static void main(String[] args) {
        LLQueue llq = new LLQueue();
        llq.push(2);
        llq.push(2);
        llq.push(5);
        llq.push(6);
        llq.push(3);
        System.out.println(llq.dequeue());
        System.out.println(llq.dequeue());
        System.out.println(llq.dequeue());
        System.out.println(llq.dequeue());
    }
}
