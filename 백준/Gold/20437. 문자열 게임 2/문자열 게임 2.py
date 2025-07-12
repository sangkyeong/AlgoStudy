"""
02:01
1소문자로 이루어진 문자열 w
2양의 정수 k
3어떤 문자를 정확히 k개 포함하는 가장 짧은 연속 문자열의 길이를 구함
4어떤 문자를 정확히 k개 포함하고 문자열의 첫번째와 마지막 글자가
해당 문자로 같은 가장 긴 연속 문자열의 길이

위 방식으로 T회 진행 3번과 4번에서 구한 연속 문자열의 길이 출력
없으면 -1
"""
T = int(input())
for _ in range(T):
    word = list(input())
    K = int(input())
    wordAndCnt = {}

    # 문자열을 이루는 철자의 인덱스를 모두 추가
    for i in range(len(word)):
        wordAndCnt.setdefault(word[i],[])
        wordAndCnt.update({word[i]:wordAndCnt.get(word[i])+[i]})

    rst = []
    for i in wordAndCnt.values():
        if len(i) >= K:
            for j in range(len(i)-K+1): # 인덱스 배열에서 K개의 철자를 포함하는 범위
                rst.append(abs(i[j+K-1] - i[j])+1) # 각 위치한 인덱스기준 문자개수 계산
    if rst:
        print(f'{min(rst)} {max(rst)}')
    else:
        print(-1)


