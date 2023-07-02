package plan08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sort11650 {
    /**
     * [11650 좌표 정렬하기]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Merge sort = new Merge(N);
        StringTokenizer str;
        for (int i = 0; i < N; i++){
            str = new StringTokenizer(reader.readLine());
            sort.addNode(i, Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
        }

        sort.mergeSort();
        sort.print();

        reader.close();
    }
}

class Merge{
    private Node [] sort;
    private Node [] tmp;

    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    Merge(int n){
        this.sort = new Node[n];
        this.tmp = new Node[n];
    }

    void addNode(int i, int x, int y) {
        this.sort[i] = new Node(x,y);
    }

    void mergeSort(){
        mergeSort(0, this.sort.length - 1);
    }

    private void mergeSort(int s, int e){
        if (s >= e) return;
        int mid = (s + e) / 2;
        mergeSort(s, mid);
        mergeSort(mid + 1, e);
        merge(s, mid, e);
    }

    private void merge(int s, int mid, int e) {
        // 임시 저장소
        for (int i = s; i <= e; i++) this.tmp[i] = this.sort[i];

        // 두개의 포인터
        int one = s;
        int two = mid + 1;
        int idx = s;

        while (one <= mid && two <= e){
            if(compareXY(tmp[one],tmp[two])) sort[idx++] = tmp[one++];
            else sort[idx++] = tmp[two++];
        }

        for (int i = 0; i <= mid - one; i++)
            sort[idx + i] = tmp[one + i];
    }

    private boolean compareXY(Node i, Node j){
        if (i.x != j.x)
            return i.x < j.x;
        else
            return i.y < j.y;

    }

    void print(){
        StringBuilder result = new StringBuilder();
        for (Node n : this.sort)
            result.append(n.x).append(" ").append(n.y).append("\n");

        System.out.println(result);
    }

}
