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

        List<Storage> list = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            list.add(new Storage(i, Integer.parseInt(tokens.nextToken())));

        int gap;
        int index = 0;
        while (true) {
            gap = list.get(index).gap;
            result.append(list.remove(index).index).append(" ");
            if (list.isEmpty())
                break;
            if (gap > 0) // 요소 1개 삭제 했기 때문에 - 1
                index = (index + gap - 1) % list.size();
            else // 뒤에 index는 삭제된 영향이 없기 때문에 처리 하지 않음 대신 - 인 경우 고려
                index = ((index + gap) % list.size() + list.size()) % list.size();
        }

        System.out.println(result);
        sc.close();
    }
}

class Storage{
    int gap;
    int index;
    Storage(int index, int gap){
        this.gap = gap;
        this.index = index;
    }
}