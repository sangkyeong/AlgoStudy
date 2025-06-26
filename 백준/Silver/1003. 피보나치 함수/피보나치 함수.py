dp = [[] for _ in range(41)]  # 각 dp[i]를 별도의 리스트로 초기화
dp[0] = [1, 0]
dp[1] = [0, 1]

for i in range(2, 41):
    dp[i] = [dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]]

T = int(input())
for _ in range(T):
    N = int(input())
    print(dp[N][0], dp[N][1])