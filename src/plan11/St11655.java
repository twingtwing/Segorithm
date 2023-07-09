package plan11;

import java.util.Scanner;

public class St11655 {
    /**
     * [11655 ROT13]
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z'){
                chars[i] += 13;
                if (chars[i] > 'z')
                    chars[i] = (char) ('a' + chars[i] - 'z' - 1);
            }
            else if(chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] += 13;
                if (chars[i] > 'Z')
                    chars[i] = (char) ('A' + chars[i] - 'Z' - 1);
            }
        }

        System.out.println(chars);
        sc.close();
    }
}
