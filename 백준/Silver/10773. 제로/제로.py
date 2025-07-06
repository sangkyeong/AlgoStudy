K = int(input())
rst = 0
stk = []
for _ in range(K):
    num = int(input())

    if num:
        stk.append(num)
    elif len(stk) != 0:
        stk.pop()
print(sum(stk))