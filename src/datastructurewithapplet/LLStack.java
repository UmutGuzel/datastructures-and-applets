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
public class LLStack {
    LinkedList ls;

    public LLStack() {
        ls = new LinkedList();
    }
    
    void push(int i){
        ls.addLeft(new Node(i));
    }
    
    Integer pop(){
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
        LLStack lss = new LLStack();
        lss.push(0);
        lss.push(1);
        lss.push(2);
        lss.push(3);
        for (int i = 0; i < 10; i++) {
            System.out.println(lss.pop());
        }
    }
}
