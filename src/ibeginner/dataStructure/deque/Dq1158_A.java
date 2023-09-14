package ibeginner.dataStructure.deque;

import java.util.*;

public class Dq1158_A {
    /**
     * [1158 요세푸스 문제]
     * 요세푸스 순열 - list + 다음 위치 계산
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int gap = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= len; i++)
            list.add(i);

        StringJoiner result = new StringJoiner(", ","<",">");
        int index = 0;
        while (!list.isEmpty()){
            index = (index + gap - 1) % list.size(); // 다음 위치 계산
            result.add(Integer.toString(list.remove(index)));
        }

        System.out.println(result);
        sc.close();

    }
}
