from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
q = deque()
for _ in range(N):
    cmd = input().strip()
    if cmd.startswith("push_front"):
        q.appendleft(int(cmd.split()[1]))
    elif cmd.startswith("push_back"):
        q.append(int(cmd.split()[1]))
    elif cmd == "pop_front":
        print(q.popleft() if q else -1)
    elif cmd == "pop_back":
        print(q.pop() if q else -1)
    elif cmd == "size":
        print(len(q))
    elif cmd == "empty":
        print(1 if not q else 0)
    elif cmd == "front":
        print(q[0] if q else -1)
    elif cmd == "back":
        print(q[-1] if q else -1)