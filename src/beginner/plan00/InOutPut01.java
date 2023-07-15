package beginner.plan00;

import java.util.Scanner;

public class InOutPut01 {
    public static void main(String[] args) {
        // 1000 : 숫자를 입력 받아서 계산 결과를 출력한다.
//        Scanner sc = new Scanner(System.in);
//        int one = sc.nextInt();
//        int two = sc.nextInt();
//
//        sc.close();
//
//        System.out.print(one + two);

        // 2558 : 숫자를 입력받아서 계산결과를 출력한다.(구분자 enter)
//        Scanner sc2 = new Scanner(System.in);
//
//        int num1 = sc2.nextInt();
//        sc2.nextLine();
//        int num2 = sc2.nextInt();
//
//        sc2.close();
//
//        System.out.print(num1 + num2);

        // 10950 : 숫자를 입력하는 횟수가 정해져있다.
//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//        sc.nextLine();
//
//        int [] ary = new int[t];
//
//        int one;
//        int two;
//
//        for (int i = 0; i < ary.length; i++){
//            one = sc.nextInt();
//            two = sc.nextInt();
//
//            ary[i] = one + two;
//
//            sc.nextLine();
//        }
//
//        for (int i : ary){
//            System.out.println(i);
//        }

        // 10951 : 테스트 케이스의 갯수를 입력하지 않고, 여러개의 테스트 케이스를 입력한다.
//        Scanner sc = new Scanner(System.in);
//
//        int one;
//        int two;
//
//        while(sc.hasNextLine()){
//            one = sc.nextInt();
//            two = sc.nextInt();
//            sc.nextLine();
//            System.out.println(one + two);
//        }
//
//        sc.close();

        // 10952 : 다수의 테스트 케이스 마지막에 0이 2개가 들어간다.
//        Scanner sc = new Scanner(System.in);
//
//        int one = Integer.MAX_VALUE;
//        int two = Integer.MAX_VALUE;
//
//        while(sc.hasNextLine()) {
//            one = sc.nextInt();
//            two = sc.nextInt();
//
//            sc.nextLine();
//
//            if (one == 0 && two == 0) break;
//            System.out.println(one + two);
//        }
//
//        sc.close();

        // 10953 : 구분자가 ,로 되어있다.

        Scanner sc = new Scanner(System.in);

        int one;
        int two;
        int [] ary = new int[sc.nextInt()];

        sc.nextLine();

        for(int i = 0 ; i < ary.length; i++) {
            sc.useDelimiter("[,\r\n]");
            one = sc.nextInt();
            two = sc.nextInt();

            System.out.println(one + two);
        }

        sc.close();

    }
}
