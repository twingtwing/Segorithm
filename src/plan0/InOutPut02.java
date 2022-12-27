package plan0;

import java.util.Scanner;

public class InOutPut02 {
    public static void main(String[] args) {
        // 11021 : 각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력
//        Scanner sc = new Scanner(System.in);
//
//        int one;
//        int two;
//        int t = sc.nextInt();
//
//        sc.nextLine();
//
//        for(int i = 0; i < t; i++){
//            one = sc.nextInt();
//            two = sc.nextInt();
//            System.out.printf("Case #%d: %d\n",(i+1), (one+two));
//        }
//
//        sc.close();

        // 11022 : 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력
//        Scanner sc = new Scanner(System.in);
//
//        int one;
//        int two;
//        int t = sc.nextInt();
//
//        sc.nextLine();
//
//        for(int i = 0; i < t; i++){
//            one = sc.nextInt();
//            two = sc.nextInt();
//            System.out.printf("Case #%d: %d + %d = %d\n",(i+1),one,two, (one+two));
//        }
//
//        sc.close();

        // 11718 : 입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다.
        // 각 줄은 100글자를 넘지 않으며, 빈 줄은 주어지지 않는다.
        // 또, 각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.
//        Scanner sc = new Scanner(System.in);
//
//        while(sc.hasNextLine()){
//            String str = sc.nextLine().trim();
//
//            System.out.println(str);
//        }

        // 11719 : 입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다.
        // 각 줄은 100글자를 넘지 않으며, 빈 줄이 주어질 수도 있고, 각 줄의 앞 뒤에 공백이 있을 수도 있다
//        Scanner sc = new Scanner(System.in);
//
//        while(sc.hasNextLine()){
//            String str = sc.nextLine();
//
//            System.out.println(str);
//        }

        // 11720 : 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
        // 입력으로 주어진 숫자 N개의 합을 출력한다.
        // key Point 숫자의 갯수가 100개 이기므로 다음 줄에는 숫자로 받을려면 길이가 100인 자료형으로 받아야한다.
        // 그러므로 문자형으로 받는 것이 좋다.

//        Scanner sc = new Scanner(System.in);
//
//        int sum = 0;
//        int len = sc.nextInt();
//        sc.nextLine();
//        String in = sc.nextLine();
//
//        for (int i = 0; i < len; i++) sum += Integer.parseInt(in.split("")[i]);
//
//        System.out.println(sum);

        // 11721 : 알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다. 한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성

        Scanner sc = new Scanner(System.in);

        String [] str = sc.nextLine().split("");

        sc.close();

        for (int i = 0; i < str.length; i++) {
            if (i != 0 && i%10 == 0) System.out.println();
            System.out.print(str[i]);
        }

    }
}
