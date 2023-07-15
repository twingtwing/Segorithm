# 문자열
## 회문 
회문(回文) 또는 팰린드롬(palindrome)은 앞 뒤 방향으로 볼 때 같은 순서의 문자로 구성된 문자열
회문이 아니지만 한 문자를 삭제하여 회문으로 만들 수 있는 문자열이라면 우리는 이런 문자열을 “유사회문”(pseudo palindrome)

## 문자열 뒤집기

## 재정렬 11655

## KMP알고리즘
문자열 검색 알고리즘 중 하나로, 특정 문자열에서 패턴 문자열을 효율적으로 찾아내는 데 사용됩니다. 
이 알고리즘은 패턴 문자열에 포함된 중복된 정보를 이용하여 검색 과정에서 필요한 비교 횟수를 줄이는 방법

> 패턴 문자열을 검색하면서 매칭이 실패한 경우, 
> 이미 비교한 문자들 중 어떤 부분은 다시 비교하지 않고 건너뛰어도 된다

1. 패턴 문자열을 전처리하여 접두사와 접미사가 일치하는 부분을 구합니다.
    - 접두사와 접미사가 일치하는 최대 길이를 저장하는 배열을 만듭니다. 
      이를 "패턴의 실패 함수" 또는 "LPS(Longest Proper Prefix which is also Suffix)" 배열이라고 합니다.
2. 패턴 문자열을 사용하여 검색 대상 문자열을 순회하면서 매칭을 찾습니다.
    - 검색 대상 문자열과 패턴 문자열을 비교하면서 일치하지 않는 위치가 나타날 때마다, 
      패턴의 실패 함수를 이용하여 다음 비교할 위치를 결정합니다.
    - 만약 일치하지 않는 위치에서 패턴의 실패 함수를 사용해 다음 비교할 위치로 건너뛰면, 
      이미 비교한 문자들 중 접두사와 접미사가 일치하는 부분을 다시 비교하지 않아도 됩니다

KMP 알고리즘은 문자열 검색에서 효율적인 알고리즘으로 사용될 수 있으며, 
패턴 문자열을 검색하는 데에 시간 복잡도 O(N+M)을 가지는데, N은 텍스트의 길이, M은 패턴의 길이입니다.



