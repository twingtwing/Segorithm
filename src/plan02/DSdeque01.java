package plan02;

import java.io.*;
import java.util.StringTokenizer;

class Deque01 {

    Node front;
    Node rear;
    int size = 0;

    static class Node{
        int data;
        Node rlink;
        Node llink;
        Node(int data){this.data = data;}
    }

    public boolean isEmtpy(){return size == 0;}

    public int getSize(){return this.size;}

    public int getFront() {return isEmtpy() ? -1 : this.front.data;}

    public int getRear() {return isEmtpy() ? -1 : this.rear.data;}

    public void addFront(int data){
        Node node = new Node(data);
        if (isEmtpy()) this.rear = node;
        else this.front.llink = node;
        node.rlink = this.front;
        this.front = node;
        this.size ++;
    }

    public void addRear(int data){
        Node node = new Node(data);
        if (isEmtpy()) this.front = node;
        else this.rear.rlink = node;
        node.llink = this.rear;
        this.rear = node;
        this.size ++;

    }

    public int removeFront(){
        if (isEmtpy()) return -1;
        int data = this.front.data;
        this.front = this.front.rlink;
        size--;
        if (!isEmtpy()) this.front.llink = null;
        setEmpty();
        return data;
    }

    public int removeRear(){
        if (isEmtpy()) return -1;
        int data = this.rear.data;
        this.rear = this.rear.llink;
        size--;
        if (!isEmtpy()) this.rear.rlink = null;
        setEmpty();
        return data;

    }

    public void setEmpty(){
        if (!isEmtpy()) return;
        this.front = null;
        this.rear = null;
    }

}

public class DSdeque01 {
    public static void main(String[] args) throws IOException {
        // 10866 : Deque => 연결 자료구조 버전
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int count = Integer.parseInt(reader.readLine());

        Deque01 deque = new Deque01();
        StringTokenizer str;
        int out;
        while (count-- > 0) {
            out = -2;
            str = new StringTokenizer(reader.readLine());
            switch (str.nextToken()) {
                case "push_front": deque.addFront(Integer.parseInt(str.nextToken()));
                    break;
                case "push_back": deque.addRear(Integer.parseInt(str.nextToken()));
                    break;
                case "pop_front": out = deque.removeFront();
                    break;
                case "pop_back": out = deque.removeRear();
                    break;
                case "size": out = deque.getSize();
                    break;
                case "empty": out = deque.isEmtpy() ? 1: 0;
                    break;
                case "front": out = deque.getFront();
                    break;
                case "back": out = deque.getRear();
                    break;
            }
            if (out > -2) result.append(String.valueOf(out)).append("\n");
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }
}
