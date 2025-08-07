# [Gold V] 공통 부분 문자열 - 5582 

[문제 링크](https://www.acmicpc.net/problem/5582) 

### 성능 요약

메모리: 78300 KB, 시간: 360 ms

### 분류

다이나믹 프로그래밍, 문자열, 최장 공통 부분 수열 문제

### 제출 일자

2025년 8월 7일 17:49:48

### 문제 설명

<p>두 문자열이 주어졌을 때, 두 문자열에 모두 포함된 가장 긴 공통 부분 문자열을 찾는 프로그램을 작성하시오.</p>

<p>어떤 문자열 s의 부분 문자열 t란, s에 t가 연속으로 나타나는 것을 말한다. 예를 들어, 문자열 <code>ABRACADABRA</code>의 부분 문자열은 <code>ABRA</code>, <code>RAC</code>, <code>D</code>, <code>ACADABRA</code>, <code>ABRACADABRA</code>, 빈 문자열 등이다. 하지만, <code>ABRC</code>, <code>RAA</code>, <code>BA</code>, <code>K</code>는 부분 문자열이 아니다.</p>

<p>두 문자열 <code>ABRACADABRA</code>와 <code>ECADADABRBCRDARA</code>의 공통 부분 문자열은 <code>CA</code>, <code>CADA</code>, <code>ADABR</code>, 빈 문자열 등이 있다. 이 중에서 가장 긴 공통 부분 문자열은 <code>ADABR</code>이며, 길이는 5이다. 또, 두 문자열이 <code>UPWJCIRUCAXIIRGL</code>와 <code>SBQNYBSBZDFNEV</code>인 경우에는 가장 긴 공통 부분 문자열은 빈 문자열이다.</p>

### 입력 

 <p>첫째 줄과 둘째 줄에 문자열이 주어진다. 문자열은 대문자로 구성되어 있으며, 길이는 1 이상 4000 이하이다.</p>

### 출력 

 <p>첫째 줄에 두 문자열에 모두 포함 된 부분 문자열 중 가장 긴 것의 길이를 출력한다.</p>

# 회고

두 문자열이 주어지면 일일이 비교하며 같은지 확인하고 그 수의 최댓 값을 갱신하는 완전탐색 방법만 떠올랐다.
dp의 원리를 이해하며 두 문자열을 행렬로 놓고, 같은 문자열이 있을때 +1 누적해줬다. 그리고 왼쪽 대각선 위의 숫자+1을 하면 그 수가 순서대로 탐색할 때 같은 문자열의 개수를 누적할 수 있었다. 탐색하며 가장 큰 수를 갱신해주면서 답을 출력했다.
