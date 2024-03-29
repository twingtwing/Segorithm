# 그리디
리디(Greedy) 알고리즘은 각 단계에서 지금 상황에서 가장 최선의 선택을 하는 알고리즘입니다. 
그리디 알고리즘은 매 순간 가장 이익이 크다고 생각되는 선택을 하며, 
각 선택이 전체적인 최적해로 이어지는 것을 기대합니다. 
그리디 알고리즘은 지역 최적해를 선택함으로써 전역 최적해를 찾는 방식으로 동작합니다. 
따라서 그리디 알고리즘은 탐욕스러운 선택을 계속 만들어 나가면서 문제를 해결합니다.

그리디 알고리즘의 특징은 다음과 같습니다:

1. 현재 단계에서의 최적해를 선택합니다.
2. 각 단계에서의 선택은 이후의 선택에 영향을 주지 않습니다.
3. 최적 부분 구조(Optimal Substructure)를 가집니다. 
  부분 문제의 최적해를 이용하여 전체 문제의 최적해를 구할 수 있습니다.

## Greedy vs DP
동적 계획법(Dynamic Programming, DP)은 최적화 문제를 해결하기 위한 알고리즘입니다. 
DP는 문제를 작은 하위 문제(subproblem)로 나누어 해결하며, 
하위 문제의 최적해를 이용하여 상위 문제의 최적해를 구하는 방식입니다. 
DP는 중복되는 하위 문제들을 한 번만 계산하고 그 결과를 메모이제이션(Memoization)하여 재활용함으로써 효율적으로 문제를 해결합니다.

그리디 알고리즘과 DP의 가장 큰 차이점은 선택의 시점과 선택의 영향입니다. 
그리디 알고리즘은 매 순간 최적의 선택을 하지만, 그 선택이 전체적인 최적해를 보장하지는 않습니다. 
즉, 지역 최적해를 선택하더라도 전역 최적해가 아닐 수 있습니다. 
반면에 DP는 모든 가능한 선택지를 고려하며, 
중복되는 계산을 최소화하여 최적해를 보장합니다.

