package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class St5397 {
    /**
     * [5397 키로거]
     * 자기 자신과 값 비교
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        while (cnt-- > 0){
            char [] input = reader.readLine().toCharArray();
            Stack stack = new Stack(input.length);
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '<' && !stack.isUpperEmpty())
                    stack.downPushUpper();
                else if (input[i] == '>' && !stack.isDownEmpty())
                    stack.upperPushDown();
                else if (input[i] == '-' && !stack.isUpperEmpty())
                    stack.pop();
                else if ( input[i] != '>' && input[i] != '<' && input[i] != '-')
                    stack.push(input[i]);
            }
            result.append(stack.print()).append("\n");
        }

        System.out.print(result.toString());
        reader.close();
    }
}

class Stack{
    private int u;
    private int d;
    private char [] upper;
    private char [] down;

    Stack(int len){
        this.u = -1;
        this.d = -1;
        this.upper = new char[len];
        this.down = new char[len];
    }

    boolean isUpperEmpty(){return this.u == -1;}
    boolean isDownEmpty(){return this.d == -1;}

    void downPushUpper(){
        down[++d] = upper[u--];
    }
    void upperPushDown(){
        upper[++u] = down[d--];
    }
    void pop(){
        u--;
    }
    void push(char c){
        upper[++u] = c;
    }

    StringBuilder print(){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= u; i++)
            result.append(upper[i]);
        for (int i = d; i >= 0; i--)
            result.append(down[i]);

        return result;
    }

}
