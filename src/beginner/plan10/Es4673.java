package beginner.plan10;

public class Es4673 {
    /**
     * [4673  셀프넘버]
     * <br>
     * 셀프넘버 =/= 소수
     * */
    public static void main(String[] args) {
        boolean [] numbers = new boolean[10001];

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i])
                result.append(i).append("\n");
            int sum = i;
            int num = i;
            while (num > 0){
                sum += num % 10;
                num /= 10;
            }
            if (sum < 10001)
                numbers[sum] = true;
        }

        System.out.println(result);
    }
}
