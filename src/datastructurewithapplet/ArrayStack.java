package datastructurewithapplet;

/**
 *
 * @author Umut
 */
public class ArrayStack {
    int index;
    Integer[] stack;
    ArrayStack(int i){
        index = -1;
        stack = new Integer[i];
    }
    void push(int i){
        if(index != 9){
            index++;
            stack[index] = i;
        }else{
            System.out.println("Stack is full");
        }
    }
    Integer pop(){
        Integer temp = null;
        if(index != -1){
            temp = stack[index];
            index--;
        }
        return temp;
    }
    Integer peek(){
        if(index != -1){
            return stack[index];
        }
        return null;
    }
    public static void main(String[] args) {
        ArrayStack a = new ArrayStack(10);
        for(Integer i: a.stack){
            System.out.println(i);
        }
    }
}
