package plan04;

import java.util.Scanner;

public class Dy2011 {
    /**
     * [2011 암호코드]
     * <br>
     * 재귀 호출의 깊이가 길어질수록 많은 양의 메로리가 필요하다.<br>
     * 깊이가 길어지면 비재귀적 방법을 사용해야한다.<br>
     * 0의 위치가 중요하다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String [] num = in.split("");
        int [] cnt = new int[num.length];

        if(!in.replaceAll("\\D","").equals("")
            && !num[0].equals("0")){
            cnt[0] = 1;
            for (int i = 1; i < cnt.length; i++){
                if(num[i].equals("0") &&
                        ( num[i-1].equals("0") || Integer.parseInt(num[i-1]) > 2 ))
                    break;
                else if (Integer.parseInt(num[i-1] + num[i]) > 26)
                    cnt[i] = cnt[i-1];
                else
                    cnt[i] = ( (num[i].equals("0") ? 0 : cnt[i-1]) +
                            (num[i-1].equals("0") ? 0 : (i > 1 ? cnt[i-2] : 1)) ) % 1000000;
            }
        }

        System.out.println(cnt[cnt.length-1]);
        sc.close();
    }

}
