package beginner.plan13;

import java.util.Scanner;

public class Bt15651 {
    /**
     * [15651 N과 M (3)]
     * */
    private static StringBuilder result;
    private static int [] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        nums = new int[M];
        result = new StringBuilder();

        backTraccking(nums, 0, N);

        System.out.println(result);
        sc.close();
    }

    private static void backTraccking(int[] nums, int idx, int m) {
        if (idx == nums.length){
            for (int i = 0; i < idx; i++)
                result.append(nums[i]).append(" ");
            result.append("\n");
            return;
        }
        for (int i = 1; i <= m; i++) {
            nums[idx] = i;
            backTraccking(nums, idx+1, m);
        }
    }

}
