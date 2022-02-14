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
public class LinkedList {
    Node head, tail;

    public LinkedList() {
        head = null;
        tail = null;
    }
    
    void addLeft(Node newNode){
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    
    void deleteLeft(){
        if(head != null){
            head = head.next;
        }
        if(head == null){
            tail = null;
        }
    }
    
    Integer peekLeft(){
        if(head != null){
            return head.number;
        }
        return null;
    }
    
    void addRight(Node newNode){
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    void deleteRight(){
        Node fast = head;
        Node slow = null;
        if(fast != null){
            while(fast.next != null){
                slow = fast;
                fast = fast.next;
            }
            if (slow == null){
                head = null;
                tail = null;
            }else{
                slow.next = null;
            }
            tail = slow;
        }
    }
    Integer peekRight(){
        if(tail != null){
            return tail.number;
        }
        return null;
    }
    void prnt(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.number);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.addLeft(new Node(15));
        ls.addLeft(new Node(15));
        ls.addLeft(new Node(15));
        ls.addLeft(new Node(1));
        ls.addRight(new Node(202));
        ls.addRight(new Node(202));

        ls.deleteLeft();
        ls.deleteLeft();
        ls.deleteLeft();
        ls.deleteLeft();
        ls.deleteLeft();
        ls.deleteLeft();
        ls.deleteLeft();
        ls.deleteLeft();
        ls.deleteLeft();
        ls.addRight(new Node(202));
        ls.prnt();
        ls.deleteRight();
        ls.deleteRight();
        ls.deleteRight();
        ls.deleteRight();
        ls.deleteRight();
        System.out.println("===");
        ls.prnt();
        System.out.println(ls.head);
    }
}

class Node{
    int number;
    Node next;

    public Node(int number) {
        this.number = number;
        this.next = null;
    }
    
}
