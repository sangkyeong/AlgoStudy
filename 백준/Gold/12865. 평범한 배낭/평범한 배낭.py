"""
01:14
n개의 물건 무게w, 가치v
최대 k만큼 무게를 넣어 최댓 값을 출력

입력
물품의 개수n, 최대 무게k
n개의 줄에 무게w, 가치v가 주어짐
"""
N, K = map(int, input().split())
dp = [0] * (K + 1)
w = []
v = []
for _ in range(N):
    W, V = map(int, input().split())
    w.append(W)
    v.append(V)

for i in range(N):
    weight = w[i]  # 현재 물건 무게
    value = v[i]  # 현재 물건 가치
    for j in range(K, weight-1, -1): # 같은 물건을 중복해서 넣지 않기 위해 역순 순회
        dp[j] = max(dp[j], dp[j - weight] + value)

print(dp[K])