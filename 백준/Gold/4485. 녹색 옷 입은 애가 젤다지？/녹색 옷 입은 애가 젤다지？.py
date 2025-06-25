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
