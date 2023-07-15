package beginner.plan04;

import java.util.Scanner;

public class Dy2133 {
    /**
     * [2133 타일 채우기]
     * <br>
     * 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수<br>
     * N(1 ≤ N ≤ 30)<br>
     * 규칙찾기가 중요
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] tiles = new int[num + 1];

        if (num % 2 == 0) {
            tiles[0] = 1;
            tiles[2] = 3;
            for (int i = 4; i <= num; i+=2){
                tiles[i] = tiles[i-2] * 3;
                for (int j = i - 4; j >= 0; j -= 2) {
                    tiles[i] += tiles[j] * 2;
                }
            }
        }

        System.out.println(tiles[num]);
        sc.close();
    }
}
