package beginner.plan04;

import java.util.Scanner;

public class Dy11053 {
    /**
     * [11053 가장 긴 증가하는 부분 수열]
     * <br>
     * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램<br>
     * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우,<br>
     * 가장 긴 증가하는 부분 수열은 A = {10, 20, 30, 50} 이고, 길이는 4이다.<br><br>
     * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
     * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)<br><br>
     * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.<br><br>
     * !!Key Point!!<br>
     *  1. 오름차순 수열이기때문에 이진검색트리 이므로 이분 탐색(Binary Search) 알고리즘이 가능하다. <br>
     *  2. else 여기서 작은값이 발견되는 경우 교체만 하고 len 바꾸지 않는 이유는<br>
     *      이미 오름차순이기 때문에 전혀 문제가 없기때문이다.
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());

        int len = 1;
        int [] sort = new int[1001];
        int [] sequence = new int[1001];
        sort[1] = scanner.nextInt();
        sequence[1] = sort[1];

        for (int i = 2; i <= cnt; i++) {
            sort[i] = scanner.nextInt();
            if (sort[i] > sequence[len])
                sequence[++len] = sort[i];
            // 작은 경우, sort[i]값보다 가장 근소한 차이로 큰 sequence 값와 교체한다.
            // len을 수정하지 않는 이유는
            // 1245 -> 1235 로 변경해도
            // 뒤에서 67이 발견되어서 124567이 가장 긴 길이여도 123567로 구현이 가능하기 때문이다.
            // 또한, 뒤에서 456을 발견해서 123456이 가장 긴 길이도 성립이 가능하기 때문이다.
            else if (sort[i] < sequence[1])
                sequence[1] = sort[i];
            else
                sequence[binarySearch(sequence,1, len, sort[i])] = sort[i];
        }

        System.out.println(len);
        scanner.close();
    }

    private static int binarySearch(int[] sequence, int start, int end, int target) {
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if(sequence[mid] == target)
                return mid;
            else if(sequence[mid] > target)
                end = mid;
            else
                start = mid + 1;

        }
        return start;
    }
}
