# 수학

## 소수
에라토스테네스의 체

## 수열의 순열 & 조합
수열을 구하기 위해서는 모든 경우의 수를 구해야 한다.
깊이 탐색 검색(DFS)은 모든 경우의 수를 탐색할 때 매우 용이하다.

```java
public class Main{
    public void dfs(int count, boolean [] visited){
        if (count == 0) return;
        for(int i = 0; i < visited.length; i++){
            if (visited[i]) return;
            visited[i] = true;
            dfs(count - 1, visited);
            visited[i] = false;
        }
    }
}
```

### 1. 순열
    순열은 서로다른 n개 중 r 개를 골라서 순서를 고려해 나열한 경우의 수

### 2. 조합
    조합은 서로다른 n개 중 r 개를 골라서 순서를 고려하지 않고 나열한 경우의 수

## 최대 공약수 & 최소 공배수
