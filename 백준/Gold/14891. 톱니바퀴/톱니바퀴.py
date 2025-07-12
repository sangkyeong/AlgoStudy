def go(num, dir):

    # 왼쪽으로 전파
    for i in range(num-1, 0, -1):
        if init.get(i)[0][2] != init.get(i+1)[0][6]:
            selectDir[i] = -dir if not selectDir[i+1] else -selectDir[i+1]
        else:
            break

    # 오른쪽으로 전파
    for i in range(num+1, 5):
        if init.get(i)[0][6] != init.get(i-1)[0][2]:
            selectDir[i] = -dir if not selectDir[i-1] else -selectDir[i-1]
        else:
            break


init = dict()
point = 1
# 4개의 톱니바퀴
for i in range(1, 5):
    inputStatus = list(map(str, input()))
    init.setdefault(i, (inputStatus, point))
    point += point

# 현재 톱니바퀴의 상태를 저장
for i in range(int(input())):
    num, dir = list(map(int, input().split()))

    selectDir = [0] * 5
    selectDir[num] = dir
    go(num, dir)
    for rotate in range(1, len(selectDir)):
        # 시계방향인경우
        if selectDir[rotate] == 1:
            # 선택된 톱니바퀴 회전
            init.get(rotate)[0][1:8], init.get(rotate)[0][0] = init.get(rotate)[0][0:7], init.get(rotate)[0][7]
        # 반시계 방향인 경우
        elif selectDir[rotate] == -1:
            # 선택된 톱니바퀴 회전
            init.get(rotate)[0][0:7], init.get(rotate)[0][7] = init.get(rotate)[0][1:8], init.get(rotate)[0][0]
rst = 0
for val in init.values():
    if val[0][0] == '1':
        rst += val[1]
print(rst)