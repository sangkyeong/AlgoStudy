"""
01:57
nxm격자
모눈격자사각형에서 두 변이상이 바깥쪽이라면 한시간만에 녹음
내부 빈 공간이 있어도 안쪽이라 안녹음
모눈종이 맨 가장자리는 치즈가 안놓일 때 모두 녹을때까지 걸리는 시간 출력
"""
from collections import deque

dxy = {(-1, 0), (1, 0), (0, -1), (0, 1)}
def air(i, j, matrixPass):
    q = deque()
    q.append((i, j))
    matrixPass[i][j] = 1

    while q:
        a, b = q.popleft()
        for x, y in dxy:
            dx = a + x
            dy = b + y
            if dx < 0 or dx >= N or dy < 0 or dy >= M or matrixPass[dx][dy] or matrix[dx][dy]: continue
            matrixPass[dx][dy] = 1
            q.append((dx, dy))

def start():
    global TIME
    # 바깥쪽인지 확인
    # 1을 만나면 사방을 보고 0의 개수 확인(2개이상이면 통과)
    # 안쪽은 안봐도 됨(위치에 따라 다르게?)
    matrixPass = [[0] * M for _ in range(N)]
    air(0, 0, matrixPass)

    # 작은 모눈종이 사각형이 두 변이상 바깥쪽과 만나는지 확인
    for i in range(N):
        for j in range(M):
            if matrix[i][j] == 1:
                cnt = 0
                for x, y in dxy:
                    dx = i + x
                    dy = j + y
                    if dx < 0 or dx >= N or dy < 0 or dy >= M or not matrixPass[dx][dy] or matrix[dx][dy]: continue
                    cnt += 1
                if cnt >= 2:
                    matrix[i][j] = 0  # 녹이기
    # 시간 누적
    TIME += 1

N, M = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(N)]

TIME = 0

while True:
    cheese = 0
    for xx in range(N):
        for yy in range(M):
            if matrix[xx][yy] == 1:
                start()
                cheese += 1
    if not cheese: break

print(TIME)