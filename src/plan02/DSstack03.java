package plan02;

import java.io.*;
import java.util.StringTokenizer;

class Stack03{
    Node top; // 오른쪽 끝
    Node cursor;

    static class Node{
        char data;
        Node right;
        Node left;
        Node(){this.data = '0';}
        Node(char data){this.data = data;}
    }

    Stack03() { this.cursor = new Node();}

    boolean isEmptyCur(){return this.cursor.data == '0';}

    boolean isEmtpyRight(){ return this.cursor.right == null;}

    boolean isEmpytLeft(){return this.cursor.left == null;}

    boolean isEmpty(){return this.top == null;}

    void moveLeft(){
        if (isEmpytLeft()) return;
        this.cursor = this.cursor.left;
    }

    void moveRight(){
        if (isEmtpyRight()) return;
        this.cursor = this.cursor.right;
    }

    void delete(){
        if (isEmpytLeft()) return;
        this.cursor.left = this.cursor.left.left;
        if (isEmpytLeft() && isEmptyCur()) this.top = null;
    }

    void insertLeft(char data) {
        if (isEmptyCur()) {
            insert(data);
            return;
        }

        Node node = new Node(data);

        if (isEmpytLeft()) this.cursor.left = node;
        else this.cursor.left.right = node;

        node.right = this.cursor;

    }

    void insert(char data){
        Node node = new Node(data);
        if (!isEmpty()) this.top.right = node;
        node.left = this.top;
        node.right = this.cursor;
        this.cursor.left = node;
        this.top = node;
    }
    
    String print(){
        StringBuilder result = new StringBuilder();
        Node next = this.top;
        while (next != null){
            result.insert(0,next.data);
            next = next.left;
        }
        
        return result.toString();
    }
    
}

public class DSstack03 {
    public static void main(String[] args) throws IOException {
        //1406 : 소문자만을 기록할 수 있는 편집기 + 커서 존재 => 후입선출 Stack을 이용한다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack03 stack = new Stack03();
        
        for (char c : reader.readLine().toCharArray()) stack.insert(c);

        int count = Integer.parseInt(reader.readLine());
        StringTokenizer str;
        while(count-- > 0){
            str = new StringTokenizer(reader.readLine());
            switch (str.nextToken()){
                case "L" : stack.moveLeft();
                    break;
                case "D" : stack.moveRight();
                    break;
                case "B" : stack.delete();
                    break;
                case "P":  stack.insertLeft(str.nextToken().charAt(0));
                    break;
                default:
                    break;
            }
        }

        writer.write(stack.print());

        writer.close();
        reader.close();

    }


}
