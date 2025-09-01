XY = [(1, 1), (1, -1), (-1, -1), (-1, 1)]

def dfs(i, j, oriX, oriY, cnt, dir_idx):
    """
    :param i: 현재 탐색 중인 x좌표 
    :param j: 현재 탐색 중인 y좌표
    :param oriX: 출발지 x좌표
    :param oriY: 출발지 y좌표
    :param cnt: 누적 거리
    :param dir_idx: 대각선 방향 인덱스
    :return: 
    """
    global nowDessert, rst

    # 대각선 방향 인덱스에 따른 다음 탐색 x, y좌표
    dx = i + XY[dir_idx][0]
    dy = j + XY[dir_idx][1]

    if 0 <= dx < N and 0 <= dy < N: # 범위 내여야 함
        if dx == oriX and dy == oriY and cnt >= 4: # 출발지로 되돌아 오고, 사각형이면 거리 갱신 후 종료
            rst = max(rst, cnt)
            return
        
        # 다음 탐색 좌표가 방문한 적 없고, 중복이 아니면 탐색 진행 
        if not desertPass[dx][dy] and (dessert[dx][dy] not in nowDessert):
            # 방문 처리와 중복 확인 리스트에 추가
            desertPass[dx][dy] = 1
            nowDessert.add(dessert[dx][dy])
            dfs(dx, dy, oriX, oriY, cnt + 1, dir_idx) # 현재 방향 계속 탐색 dir_idx 그대로

            # 대각선 방향을 바꿔서 탐색 단, 사각형이니 dir_idx 범위를 4로 제한
            if (dir_idx + 1) < 4:
                dfs(dx, dy, oriX, oriY, cnt + 1, dir_idx + 1)
            
            # 백트래킹
            desertPass[dx][dy] = 0
            nowDessert.remove(dessert[dx][dy])


T = int(input())

for tc in range(1, T + 1):
    rst = 0 # 최종 출력할 가장 긴 탐방 거리
    N = int(input())
    dessert = [list(map(int, input().split())) for _ in range(N)]
    
    # 완전 탐색하며 각 위치에서 탐방을 시작한다 
    for i in range(N):
        for j in range(N):
            desertPass = [list([0] * N) for _ in range(N)] # 방문처리 현황용
            nowDessert = set() # 중복 디저트가 있는지 확인용

            desertPass[i][j] = 1 # 방문 처리
            nowDessert.add(dessert[i][j]) # 중복확인용 셋에도 추가

            dfs(i, j, i, j, 1, 0)

            # 백트래킹
            desertPass[i][j] = 0
            nowDessert.remove(dessert[i][j])
            
    print(f"#{tc} {-1 if not rst else rst}")