"""
01:59
정수삼각형이 주어짐
맨 위층부터 아래에 있는 수 중 하나를 선택해 내려올 때
이제까지 선택된 수의 합이 최대가 되는 경로를 출력
아래층에 있는 수는 현재층에서 선택된 수의 대각선 왼쪽, 대각선 오른쪽 있는 것만
선택가능
"""
N = int(input())
tri = [0] * N

for i in range(N):
    tri[i] = list(map(int, input().split()))

dp = [[0] * N for _ in range(N)]
dp[0][0] = tri[0][0]

for i in range(1, N): # 삼각형의 크기
    for j in range(i+1): # 삼각형의 각 라인
        # 각 라인별 누적합 중 큰 값을 dp배열에 갱신한다
        if j == 0: # 맨 왼쪽
            dp[i][j] = dp[i-1][j] + tri[i][j]
        elif i == j: # 맨 오른쪽
            dp[i][j] = dp[i-1][j-1] + tri[i][j]
        else: #중간
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j]
print(max(dp[N-1]))