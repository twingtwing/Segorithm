package plan03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class RecSort06 {
    /**
     * [1431 시리얼 번호]
     * <br>
     * 다솜이는 기타를 많이 가지고 있다. 그리고 각각의 기타는 모두 다른 시리얼 번호를 가지고 있다.<br>
     * 다솜이는 기타를 빨리 찾아서 빨리 사람들에게 연주해주기 위해서 기타를 시리얼 번호 순서대로 정렬하고자 한다.<br>
     * 모든 시리얼 번호는 알파벳 대문자 (A-Z)와 숫자 (0-9)로 이루어져 있다.<br>
     * 시리얼번호 A가 시리얼번호 B의 앞에 오는 경우는 다음과 같다.<br>
     * 1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.<br>
     * 2. 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)<br>
     * 3. 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.<br>
     * 시리얼이 주어졌을 때, 정렬해서 출력하는 프로그램을 작성하시오.<br><br>
     * 첫째 줄에 기타의 개수 N이 주어진다. N은 50보다 작거나 같다. 둘째 줄부터 N개의 줄에 시리얼 번호가 하나씩 주어진다.<br>
     * 시리얼 번호의 길이는 최대 50이고, 알파벳 대문자 또는 숫자로만 이루어져 있다. 시리얼 번호는 중복되지 않는다.<br>
     * 첫째 줄부터 차례대로 N개의 줄에 한줄에 하나씩 시리얼 번호를 정렬한 결과를 출력한다.<br>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int cnt = Integer.parseInt(reader.readLine());
        Serial [] serials = new Serial[cnt];

        for (int i = 0; i < cnt; i++)
            serials[i] = new Serial(reader.readLine());

        quickSort(serials, 0, cnt-1);

        for (Serial serial: serials) {
            result.append(serial.val).append("\n");
        }

        System.out.println(result);
        reader.close();
    }

    private static void quickSort(Serial[] serials, int start, int end) {
        if (start >= end) return;
        int divide = getDivide(serials, start, end);
        quickSort(serials, start, divide - 1);
        quickSort(serials, divide, end);
    }

    private static int getDivide(Serial[] serials, int start, int end) {
        Serial pivot = serials[(start + end) / 2];
        while (start <= end){
            while (compare(serials[start], pivot)) start++;
            while (compare(pivot, serials[end])) end--;
            if (start <= end){
                swap(serials, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static boolean compare(Serial small, Serial big) {
        if (small.len != big.len)
            return small.len < big.len;
        else if(small.sum != big.sum)
            return small.sum < big.sum;
        else
            return big.val.compareTo(small.val) > 0;
    }

    private static void swap(Serial[] serials, int start, int end) {
        Serial tmp = serials[start];
        serials[start] = serials[end];
        serials[end] = tmp;
    }

}

class Serial{
    String val;
    int sum;
    int len;

    Serial(String val){
        this.val = val;
        this.len = val.length();
        this.sum = getSum(val);
    }

    private int getSum(String val) {
        int s = 0;
        val = val.replaceAll("\\D","");
        for (char c : val.toCharArray()){
            s += Character.getNumericValue(c);
        }
        return s;
    }
}
