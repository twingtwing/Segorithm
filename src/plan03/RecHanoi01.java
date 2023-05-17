package plan03;

import java.util.Scanner;
import java.util.Stack;

public class RecHanoi01 {
    /**
     * [1914 하노이 탑]
     * <br>
     * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.
     * 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
     * 
     * 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
     * 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
     * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int cnt = (int) (Math.pow(2, num) - 1); // 하노이 탑 최소 이동 횟수 : 2^원판수-1

        System.out.println(cnt);

        Stack<Integer>[] stack = new Stack[3];
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
        stack[2] = new Stack<>();

        for (int i = num; i > 0; i--)
            stack[0].push(i);

        while(cnt-->0){
            recHanoi(stack[0].empty() ? 1 : 0, 2, stack);
        }

        scanner.close();
    }
    
    
    public static void recHanoi(int now, int spot, Stack<Integer>[] stack){
        if(stack[now].empty()) return;
        int other = (3 - now - spot);
        int push = stack[now].size() % 2 == 0 ? other : spot;

        // 이동하는 값보다 클 경우
        if(!stack[push].isEmpty() && stack[push].peek() < stack[now].peek())
            recHanoi(push, push == spot ? other : spot, stack);

        // 값 이동
        stack[push].push(stack[now].pop());
        
        System.out.println((now+1) + " " + (push+1));

        recHanoi(now, spot, stack);

    }

}
