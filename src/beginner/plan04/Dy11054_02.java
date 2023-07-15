package beginner.plan04;

import java.util.Scanner;

public class Dy11054_02 {
    /**
     * [11054 가장 긴 바이토닉 부분 수열]
     * <br>
     * 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면,<br>
     * 그 수열을 바이토닉 수열<br>
     * 수열 A가 주어졌을 때,<br>
     * 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성<br>
     * 첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다.<br>
     * (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)<br><br>
     * 이분 탐색(Binary Search) 알고리즘 풀이<br>
     * - 증가 길이와 감소 길이를 따로 따로 구한다.
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());

        int [] sort = new int[1001];
        int [] sequence = new int[1001];
        int [] len = new int[1001];
        int [] lenR = new int[1001];

        len[1] = 1;
        sort[len[1]] = scanner.nextInt();
        sequence[len[1]] = sort[1];
        for (int i = 2; i <= cnt; i++) {
            sort[i] = scanner.nextInt();
            len[i] = len[i - 1];
            if (sort[i] > sequence[len[i]])
                sequence[++len[i]] = sort[i];
            else
                sequence[binarySearch(sequence, 1, len[i], sort[i])] = sort[i];
        }

        lenR[cnt] = 1;
        sequence[1] = sort[cnt];
        for (int i = cnt - 1; i > 0; i--) {
            lenR[i] = lenR[i + 1];
            if (sort[i] > sequence[lenR[i]])
                sequence[++lenR[i]] = sort[i];
            else
                sequence[binarySearch(sequence, 1, lenR[i], sort[i])] = sort[i];
        }

        int max = 0;
        for (int i = 1; i <= cnt; i++)
            max = Math.max(max,len[i] + lenR[i] - 1);

        System.out.println(max);
        scanner.close();
    }

    private static int binarySearch(int[] increa, int start, int end, int target) {
        int mid;
        while (start < end){
            mid = (start+end)/2;
            if (increa[mid] == target)
                return mid;
            else if(increa[mid] < target)
                start = mid + 1;
            else
                end = mid;

        }
        return start;
    }

}
