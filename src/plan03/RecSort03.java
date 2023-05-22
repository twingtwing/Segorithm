package plan03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RecSort03 {
    /**
     * [10814 나이순 정렬]
     * <br>
     * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.<br>
     * 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.<br>
     *
     * 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
     * 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.<br>
     * 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고,
     * 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.<br>
     * 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순,
     * 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
     *
     * KeyPoint!!
     * 중복된 값의 정렬을 유지하고싶으면 병합 정렬을 사용해야한다.
     * */
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        boolean [] sort = new boolean[201];
        StringBuilder [] input = new StringBuilder[201];
        String str;

        while (num-- > 0) {
            str = reader.readLine();
            sort[Integer.parseInt(str.replaceAll("\\D",""))] = true;
            input[num] = input[num] == null? new StringBuilder(str) : input[num].append("\n").append(str);
        }

        for (int i = 1; i < sort.length; i++){
            if (!sort[i]) continue;
            result.append(input[i]).append("\n");
        }

        System.out.println(result);
        reader.close();
    }

}
