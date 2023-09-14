package ibeginner.dataStructure.deque;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dq2346 {
    /**
     * [2346 풍선 터뜨리기]
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        StringBuilder result = new StringBuilder();
        StringTokenizer tokens = new StringTokenizer(sc.nextLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
            list.add(Integer.valueOf(tokens.nextToken()));

        int idx = list.remove(0);
        result.append(1).append(" ");
        while (!list.isEmpty()) {

        }

        sc.close();
    }
}

class Stroage{
    int data;
    int index;
    Stroage(int data, int index){
        this.data = data;
        this.index = index;
    }
}