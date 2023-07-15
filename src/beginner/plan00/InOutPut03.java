package beginner.plan00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOutPut03 {
    public static void main(String[] args) throws IOException {
        // 2741 : 100,000보다 작거나 같은 자연수 N이 주어질 때, 1부터 N까지 한 줄에 하나씩 출력

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int num = 0;
//
//        try {
//            num = Integer.parseInt(reader.readLine());
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 1; i <= num; i++){
//            System.out.println(i);
//        }

        // 2742 : 100,000보다 작거나 같은 자연수 N이 주어질 때, N부터 1까지 한 줄에 하나씩 출력

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int inum = 0;
//        try {
//            inum = Integer.parseInt(reader.readLine());
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = inum; i > 0; i--) System.out.println(i);

        // 2739 : N을 입력받은 뒤, 구구단 N단을 출력

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int num = 0;
//
//        try {
//            num = Integer.parseInt(reader.readLine());
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 1; i < 10; i++) System.out.printf("%d * %d = %d\n",num,i,(num*i));

        // 1924 : 오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일

//        Scanner scanner = new Scanner(System.in);
//        Calendar cal = Calendar.getInstance();
//
//        int mon = scanner.nextInt() - 1; // 월 : 0 ~ 11 -> 월은 요일과 달리 -1을 해야한다.
//        int date = scanner.nextInt(); // 요일 : 1 ~ 7
//
//        scanner.close();
//
//        cal.set(2007,mon,date);
//
//        int day = cal.get(Calendar.DAY_OF_WEEK);
//        String str = "";
//
//        switch (day){
//            case 1 :
//                str = "SUN";
//                break;
//            case 2 :
//                str = "MON";
//                break;
//            case 3 :
//                str = "TUE";
//                break;
//            case 4 :
//                str = "WED";
//                break;
//            case 5 :
//                str = "THU";
//                break;
//            case 6 :
//                str = "FRI";
//                break;
//            case 7 :
//                str = "SAT";
//                break;
//        }
//
//        System.out.println(str);

        // 8393 : n이 주어졌을 때, 1부터 n까지 합 (1 ≤ n ≤ 10,000)
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = 0;
//        try {
//            n = Integer.parseInt(reader.readLine());
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (n%2 == 0) System.out.println((n+1)*(n/2));
//        else System.out.println((n)*((n-1)/2) + n);

        // 10818 : N개의 정수가 주어진다. 이때, 최솟값과 최댓값  N (1 ≤ N ≤ 1,000,000)
        // 입력하는 값이 많기 때문에 Scanner 대신 Buffer을 사용한다.

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int num = 0;
//        int now = 0;
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//
//        StringTokenizer st;
//
//        try {
//            num = Integer.parseInt(reader.readLine());
//            st = new StringTokenizer(reader.readLine());
//
//            while(num-- > 0){
//                now = Integer.parseInt(st.nextToken());
//                max = Math.max(max, now);
//                min = Math.min(min, now);
//            }
//
//            reader.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.printf("%d %d",min,max);

        // 10991 : 첫째 줄부터 N번째 줄까지 차례대로 별을 출력(1 ≤ N ≤ 100)

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int num = Integer.parseInt(br.readLine());
//        br.close();
//
//        StringBuilder str = new StringBuilder();
//
//        for (int i = 1, j = num - 1; i <= num; i++, j--){
//            for (int n = j; n > 0; n--) str.append(" ");
//            for (int n = i; n > 0; n--) str.append("* ");
//            str.append("\n");
//        }
//
//        System.out.print(str.toString());

        // 10992 : 첫째 줄부터 N번째 줄까지 차례대로 별을 출력(1 ≤ N ≤ 100)

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        reader.close();

        StringBuilder str = new StringBuilder();

        for (int i = num -1, j = -1; i >= 0; i--,j+=2) {
            for (int n = i; n > 0; n--) str.append(" ");
            str.append("*");
            for (int n = j; n > 0; n--) {
                if (i != 0) str.append(" ");
                else str.append("*");
            }
            if(i != num - 1)str.append("*");
            str.append("\n");
        }

        System.out.println(str.toString());

    }
}
