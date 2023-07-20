package ibeginner.dataStructure.queue;

import org.w3c.dom.Node;

import java.util.Scanner;

public class Qu1158 {
    /**
     * [1158 요세푸스 문제]
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();


        int idx = 0;
        int len = 0;
        int [] result = new int[N];


        StringBuffer r = new StringBuffer();
        r.append("<").append(result[0]);
        for (int i = 1; i < result.length; i++) {
            r.append(", ").append(result[i]);
        }
        r.append(">");

        System.out.println(r);
        sc.close();
    }
}

class CircleQueue{
    Node front;
    Node rear;
    //'구현

    
}
