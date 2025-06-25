"""
01:18
화폐의 단위는 루피
검은색루피도 있는데 획득 시 루피가 감소
링크는 도둑루피만 가득한 nxn동굴 제일 왼쪽 위에 있음(0,0)
(n-1, n-1)까지 이동 해야할 때 잃을 수 밖에 없는 최소금액을 출력

입력
테케수
n개의 줄에 걸쳐 도둑루피의 크기가 주어짐k
k를 지나면 k만큼 루피를 잃는다
0입력 시 종료

출력
Problem 테케번호: 답
"""
import heapq

xy = {(-1, 0), (1, 0), (0, -1), (0, 1)}
def search(xx, yy, subPoint, N):
    heap = []
    heapq.heappush(heap, (xx, yy, subPoint))

    while heap:
        x, y, nowPoint = heapq.heappop(heap)

        for i, j in xy:
            dx = x + i
            dy = y + j
            if 0 > dx or dx >= N or 0 > dy or dy >= N:continue
            new = nowPoint+matrix[dx][dy]
            if new < matrixPass[dx][dy]: # 최소 값을 갱신
                matrixPass[dx][dy] = new
                heapq.heappush(heap, (dx, dy, new))


T = 1
while(True):
    N = int(input())

    if N == 0: break
    matrix = [list(map(int, input().split())) for _ in range(N)]
    matrixPass = [[float('inf')]*N for _ in range(N)]

    # 첫 시작(0, 0), 도둑루피 첫 지점 저장, N의 크기
    search(0, 0, matrix[0][0], N)

    print(f"Problem {T}: {matrixPass[N-1][N-1]}")
    T += 1
