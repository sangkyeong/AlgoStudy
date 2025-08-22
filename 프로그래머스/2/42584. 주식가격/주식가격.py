def solution(prices):
    answer = []

    for i in range(len(prices)-1):
        TIME = 1
        for j in range(i+1, len(prices)-1):
            if prices[i] <= prices[j]:
                TIME += 1
            else: break
        answer.append(TIME)
    answer.append(0)
    return answer