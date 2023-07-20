package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class St2841 {
    /**
     * [2841 외계인의 기타 연주]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int P = Integer.parseInt(tokens.nextToken());

        Stack02 [] stacks = new Stack02[6];
        for (int i = 0; i < stacks.length; i++)
            stacks[i] = new Stack02();

        int count = 0;
        while (N--  > 0){
            tokens = new StringTokenizer(reader.readLine());
            int spot = Integer.parseInt(tokens.nextToken()) - 1;
            int data = Integer.parseInt(tokens.nextToken());
            if(stacks[spot].peek() > data){
                while (!stacks[spot].isEmpty()){
                    if (stacks[spot].peek() <= data)
                        break;
                    else
                        stacks[spot].pop();
                    count++;
                }
            }
            if (stacks[spot].isEmpty() || stacks[spot].peek() < data){
                stacks[spot].push(data);
                count++;
            }
        }

        System.out.println(count);
        reader.close();
    }
}

class Stack02 {
    Node top;
    class Node{
        int data;
        Node link;
        Node(){}
        Node(int data){this.data = data;}
    }

    Stack02(){
        this.top = new Node();
    }

    boolean isEmpty(){return this.top.link == null;}

    void push(int data){
        Node node = new Node(data);
        node.link = this.top.link;
        this.top.link= node;
    }

    int pop(){
        if (isEmpty()) return -1;
        int data = this.top.link.data;
        this.top.link= this.top.link.link;
        return data;
    }

    int peek(){
        if (isEmpty()) return -1;
        return this.top.link.data;
    }

}
