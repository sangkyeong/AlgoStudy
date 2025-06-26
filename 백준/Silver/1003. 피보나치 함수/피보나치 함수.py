"""
00:53
피보나치 함수fibo(n)를 호출했을 때
0과 1이 몇 번 출력 되는지 출력

입력
테케수 T
T개의 N
"""
def search(n):
    # 0, 1 출력개수는 숫자에 따라 앞전과 앞앞전 숫자 배열의 누적 합이 된다
    for i in range(3, 41):
        first = n[i-1][0] + n[i-2][0]
        second = n[i-1][1] + n[i-2][1]
        n[i] = [first, second]
        
dp = [[]] * 41  # 초기에 0~41까지 2차원 배열을 만든다

# 각 숫자에 따라 0, 1 출력개수를 미리 저장
dp[0] = [1, 0]
dp[1] = [0, 1]
dp[2] = [1, 1]
search(dp)

T = int(input())
for _ in range(1, T+1):
    N = int(input())
    print(f"{dp[N][0]} {dp[N][1]}")