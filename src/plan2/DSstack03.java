package plan2;

import java.io.*;
import java.util.StringTokenizer;

class Stack03{
    Node top;
    Node cursor;

    // 왼쪽이 top인지 오른쪽이 top인지 계싼해서 다시 하기
    class Node{
        char data;
        Node right;
        Node left;
        Node(){}
        Node(char data){this.data = data;}
    }

    Stack03() { this.cursor = new Node();}

    boolean isEmtpy(char c){
        if (c == 'L') return this.cursor.left == null;
        else if (c == 'R')return this.cursor.right == null;
        else if(c=='C') return this.cursor == null;
        return this.top == null;
    }

    void moveLeft(){
        if (isEmtpy('L')) return;
        this.cursor = this.cursor.left;
    }

    void moveRight(){
        if (isEmtpy('R')) return;
        this.cursor = this.cursor.right;
    }

    void delete(){
        if (isEmtpy('L')) return;
        this.cursor.left = this.cursor.left.left;
    }

    void insertLeft(char data) {
        Node node = new Node(data);
        if (isEmtpy('L')) this.cursor.left = node;
        else{
            this.cursor.left.right = node;
            node.right = this.cursor;
        }
        if (isEmtpy('C')) top = node; 
    }

    void insert(char data){
        Node node = new Node(data);
        if (!isEmtpy('T')) this.top.right = node;
        node.right = this.top;
        this.cursor.left = node;
        this.top = node;
    }
    
    String print(){
        StringBuilder result = new StringBuilder();
        Node next = this.top;
        while (next == null){
            next = next.right;
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
            }
        }

        writer.close();
        reader.close();

    }


}
