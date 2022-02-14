package datastructurewithapplet;

/**
 *
 * @author Umut
 */
public class ArrayQueue {
    int[] queue;
    int head;
    int tail;
    int count;
    public ArrayQueue(int i) {
        queue = new int[i];
        head = 0;
        tail = -1;
        count = 0;
    }
    
    void add(int i){
        if(count == 0){
            tail = 0;
            queue[tail] = i;
            count++;
        }else if (tail != queue.length-1){
            tail++;
            queue[tail] = i;
            count++;
        }
    }
    
    Integer remove(){
        Integer temp = null;
        if(count != 0){
            temp = queue[head];
            for(int i = 0; i < tail; i++){
                queue[i] = queue[i+1];
            }
            tail--;
            count--;
        }
        return temp;
    }
    
    Integer peek(){
        if(count == 0){
            return null;
        }
        return queue[head];
    }
    
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(10);
        aq.add(5);
        aq.add(1);
        aq.add(1);
        aq.add(1);
        aq.add(1);
        aq.add(1);
        aq.add(1);
        aq.add(1);
        aq.add(1);
        aq.add(1);
        aq.add(1);
        System.out.println(aq.peek());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
        System.out.println(aq.remove());
    }
}
