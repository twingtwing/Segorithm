package ibeginner.dataStructure.deque;

import java.util.Scanner;
import java.util.StringJoiner;

public class Dq1158 {
    /**
     * [1158 요세푸스 문제]
     * 요세푸스 순열 - 일반 큐
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int gap = sc.nextInt();

        Queue queue = new Queue();
        for (int i = 1; i <= len; i++)
            queue.enQueue(i);

        StringJoiner result = new StringJoiner(", ","<",">");

        while (!queue.isEmpty()){
            for (int i = 1; i < gap; i++)
                queue.enQueue(queue.deQueue());
            result.add(Integer.toString(queue.deQueue()));
        }

        System.out.println(result);
        sc.close();
    }
}

class Queue{

    private Node front;
    private Node rear;

    class Node{
        int data;
        Node link;
        Node(int data){
            this.data = data;
        }
    }

    public Queue(){
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty(){
        return this.front == null;
    }

    public void enQueue(int data){
        Node node = new Node(data);
        if (isEmpty()) front = node;
        if (this.rear != null) rear.link = node;
        rear = node;
    }

    public int deQueue(){
        int data = front.data;
        front = front.link;
        if (isEmpty()) rear = null;
        return data;
    }

}
