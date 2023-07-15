package beginner.plan11;

import java.util.Scanner;

public class St17413 {
    /**
     * [17413 단어 뒤집기 2]
     * <br>
     * 뒤집기 ==> Stack 이용
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();

        int i = 0;
        while (i < chars.length){
            if (chars[i] == '<')
                while (chars[i++] != '>');
            else if (chars[i] == ' ')
                i++;
            else{
                int j = i;
                while (j < chars.length && chars[j] != ' ' && chars[j] != '<') j++;
                int s = i;
                int e = j - 1;
                while (s < e) {
                    char tmp = chars[s];
                    chars[s++] = chars[e];
                    chars[e--] = tmp;
                }
                i = j;
            }
        }

        System.out.println(chars);
        sc.close();
    }
}
