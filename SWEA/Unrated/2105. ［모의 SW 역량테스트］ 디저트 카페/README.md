# [Unrated] [모의 SW 역량테스트] 디저트 카페 - 2105 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu) 

### 성능 요약

메모리: 72,064 KB, 시간: 550 ms, 코드길이: 2,047 Bytes

### 제출 일자

2025-09-02 00:50



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do

# 회고

완탐을 통해 모든 좌표를 확인하며 대각선으로 이동하며, dfs로 조합을 찾아 백트래킹 까지는 구현 아이디어가 떠올랐는데 사각형을 만드는 조건이 어려웠다.

먼저 현재 방향 그대로 갈건지, 방향을 바꿀건지 결정을 하고, 여기서 중요한 건 대각선 탐색 방향을 순서대로 좌표를 정해둔 후 차례대로 인덱스를 따로 변수화해서 dfs를 돌려야 했다.

기존에 사용했던 네방향 모두 탐색하며 dfs 좌표 탐색하는 방식은 시간이 너무 오래걸려(약 2700ms) 비효율 적이었다.
