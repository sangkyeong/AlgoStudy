def solution(participant, completion):
    answer = ''
    participant.sort()
    completion.sort()

    for i in range(len(participant)):
        if i >= len(completion):
            answer = participant[i]
            break
        if participant[i] != completion[i]:
            answer = participant[i]
            break
    return answer