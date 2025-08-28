# [Unrated] [모의 SW 역량테스트] 등산로 조성 - 1949 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq) 

### 성능 요약

메모리: 62,976 KB, 시간: 169 ms, 코드길이: 1,831 Bytes

### 제출 일자

2025-08-28 23:46



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do


# 회고

예전에 못 풀었던 문제였는데 다시 차근차근 읽고, 원리를 생각하며 풀었더니 풀렸다 ^__^

먼저, 가장 높은 봉우리를 찾아 좌표를 저장했고, 그 좌표를 기준으로 dfs 탐색했다. 탐색할 때마다 각자 다른 케이스기 때문에 방문처리 현황판을 새로 만들어주었다.

처음엔 효율성을 위해 bfs로 접근하다가 공사를 하는 경우가 있어 dfs로 다시 바꿔풀었다.

상, 하, 좌, 우로 현재 지형보다 낮은 곳이라면 바로 이어서 탐색하도록 했고, 그게아니라면 1부터 K까지 깎았을 때의 경우의 수를 모두 탐색해주었다. 그리고 백트래킹을 통해 방문처리와 지형 깎기 여부를 다시 복구하며 다른 경우의 수도 탐색할 수 있도록 했다. 탐색하며 현재까지 등산로의 길이가 길다면 갱신하는 식으로 답을 출력할 수 있었다.
