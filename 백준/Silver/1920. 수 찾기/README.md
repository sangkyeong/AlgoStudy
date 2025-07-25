# [Silver IV] 수 찾기 - 1920 

[문제 링크](https://www.acmicpc.net/problem/1920) 

### 성능 요약

메모리: 45812 KB, 시간: 848 ms

### 분류

자료 구조, 정렬, 이분 탐색, 집합과 맵, 해시를 사용한 집합과 맵

### 제출 일자

2025년 7월 20일 22:57:38

### 문제 설명

<p>N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -2<sup>31</sup> 보다 크거나 같고 2<sup>31</sup>보다 작다.</p>

### 출력 

 <p>M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.</p>

# 회고

수를 찾는 문제에서 10만이 넘어가는 범위라 이분탐색을 써야겠다는 생각이 들었다. first와 last 양 쪽 인덱스를 사용해 문제를 풀었는데 이분법을 놓쳐 시간초과가 떴다. 다시 원리를 생각해보고 시간복잡도를 줄이기 위해 이분법을 구현했고, 이분법이 적용된 인덱스에서 필요한 방향으로 +1, -1을 해야 범위 양 끝까지 탐색할 수 있다는 것을 다시 되새겼다.
