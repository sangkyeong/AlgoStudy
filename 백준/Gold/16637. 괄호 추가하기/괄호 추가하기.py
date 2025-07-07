def cal(a, b, etc):
    if etc == "+":
        return a + b
    elif etc == '*':
        return a * b
    elif etc == '-':
        return a - b
def dfs(idx, sumNum):
    global rst
    if idx >= len(etcList):
        rst = max(rst, sumNum)
        return

    # 괄호 없이 계산하는 경우
    nextNum = cal(sumNum, numList[idx+1], etcList[idx])
    dfs(idx+1, nextNum)

    # 괄호 있는경우
    if idx + 1 < len(etcList):
        # 뒷항부터 계산
        before = cal(numList[idx+1], numList[idx+2], etcList[idx+1])
        # 앞항과 뒷항을 계산
        nextNum = cal(sumNum, before, etcList[idx])
        # 뒷 항을 계산했으니 idx도 +2
        dfs(idx+2, nextNum)


N = int(input())
allList = list(input().strip())
rst = float('-inf')

numList = []
etcList = []

for i in range(len(allList)):
    if not i % 2:
        numList.append(int(allList[i]))
    else:
        etcList.append(allList[i])

dfs(0, numList[0]) # 첫 숫자부터 시작

print(rst)