package plan2;

import java.io.*;
import java.util.StringTokenizer;

class Stack01{
    Node top;
    int size;

    static class Node{
        int data;
        Node link;
        Node(){}
        Node(int data){this.data = data;}
    }

    Stack01(){this.size = 0;}

    int getSize(){return this.size;}

    int getTop(){ return isEmpty() == 1 ? -1 : this.top.data;}

    int isEmpty(){return this.top == null ? 1 : 0;}

    void push(int data){
        Node node = new Node(data);
        if (isEmpty() == 0) node.link = this.top;
        this.size++;
        this.top = node;
    }

    int pop(){
        if (isEmpty() == 1) return -1;
        int result = this.top.data;
        this.top = this.top.link;
        this.size--;
        return result;
    }

}

public class DSstack01 {
    public static void main(String[] args) throws IOException {
        // 10828 Stack 구현
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer str;

        Stack01 stack = new Stack01();

        while (count-- > 0) {
            str = new StringTokenizer(reader.readLine());
            switch (str.nextToken()){
                case "push" : stack.push(Integer.parseInt(str.nextToken()));
                    break;
                case "pop" : result.append(String.valueOf(stack.pop())).append("\n");
                    break;
                case "size" :  result.append(String.valueOf(stack.getSize())).append("\n");
                    break;
                case "empty" :  result.append(String.valueOf(stack.isEmpty())).append("\n");
                    break;
                case "top" :  result.append(String.valueOf(stack.getTop())).append("\n");
                    break;
                default: System.out.println("잘못된 입력문입니다.");
                    return;
            }
        }

        writer.write(result.toString());

        writer.close();
        reader.close();
    }
}
