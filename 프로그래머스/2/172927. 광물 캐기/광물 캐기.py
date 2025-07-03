def solution(picks, minerals):
    group = []
    # 광물 5개씩 그룹으로 묶는다
    for i in range(0, len(minerals), 5):
        group.append(minerals[i:i+5])

    def cal(pick, group):
        cnt = 0
        for i in group:
            if pick == 0:
                cnt += 1
            elif pick == 1:
                cnt += 5 if i == "diamond" else 1
            else:
                if i == "diamond":
                    cnt += 25
                elif i == "iron":
                    cnt += 5
                else:
                    cnt += 1
        return cnt

    answer = float('inf')
    def dfs(idx, picks, total):
        nonlocal answer
        # 광물을 다 캤거나 곡괭이가 없으면 중단
        if idx == len(group) or sum(picks) == 0:
            answer = min(total, answer)
            return
        for j in range(3):
            if picks[j] > 0:
                picks[j] -= 1
                calRst = cal(j, group[idx])
                dfs(idx + 1, picks, total + calRst)
                picks[j] += 1

    dfs(0, picks[:], 0)
    return answer