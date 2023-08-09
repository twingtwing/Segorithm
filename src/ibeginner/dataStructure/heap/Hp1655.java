package ibeginner.dataStructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Hp1655 {
    /**
     * [1655 가운데를 말해요]
     * 중간값
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        asc.offer(Integer.parseInt(reader.readLine()));

        StringBuilder result = new StringBuilder();
        result.append(asc.peek()).append("\n");
        for (int i = 1; i < N; i++){
            int n = Integer.parseInt(reader.readLine());
            if (i % 2 == 0){

            }else{
                if (asc.peek() > n){

                }
            }
        }

        System.out.println(result);
        reader.close();
    }
}

