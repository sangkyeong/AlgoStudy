def search(line):
    used = [0] * n
    for i in range(n - 1):
        if line[i] == line[i+1]:
            continue
        elif line[i] + 1 == line[i+1]:
            for j in range(i, i - l,-1):
                if j < 0 or line[j] != line[i] or used[j]:
                    return False
                used[j] = 1
        elif line[i] - 1 == line[i+1]:
            for j in range(i+1, i+1+l):
                if j >= n or line[j] != line[i + 1] or used[j]:
                    return False
                used[j] = 1
        else:
            return False
    return True


n, l = list(map(int, input().split()))
matrix = [list(map(int, input().split())) for _ in range(n)]
rst = [0]

for i in range(n):
    rst[0] += search(matrix[i])
    
matrix = list(zip(*matrix[::-1]))

for i in range(n):
    rst[0] += search(matrix[i])
print(*rst)