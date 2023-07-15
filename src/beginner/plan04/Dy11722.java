package beginner.plan04;

import java.util.Scanner;

public class Dy11722 {
    /**
     * [11722 가장 긴 감소하는 부분 수열]
     * <br>
     * 이진 검색트리로 풀이 가능하다
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());

        int len = 1;
        int [] sort = new int[1001];
        int [] sequece = new int[1001];
        sort[len] = scanner.nextInt();
        sequece[len] = sort[1];

        for (int i = 2; i <= cnt; i++) {
            sort[i] = scanner.nextInt();
            if (sequece[len] > sort[i])
                sequece[++len] = sort[i];
            else
                sequece[binarySearch(sequece, 1, len, sort[i])] = sort[i];
        }

        System.out.println(len);
        scanner.close();
    }

    private static int binarySearch(int[] sequece, int start, int end, int target) {
        int mid;
        while (start < end){
            mid = (start + end) /2;
            if (sequece[mid] == target)
                return mid;
            else if(sequece[mid] > target)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
