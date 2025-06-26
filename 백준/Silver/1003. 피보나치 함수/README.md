# [Silver III] 피보나치 함수 - 1003 

[문제 링크](https://www.acmicpc.net/problem/1003) 

### 성능 요약

메모리: 32412 KB, 시간: 40 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 6월 26일 22:39:15

### 문제 설명

<p>다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.</p>

<pre>int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}
</pre>

<p><code>fibonacci(3)</code>을 호출하면 다음과 같은 일이 일어난다.</p>

<ul>
	<li><code>fibonacci(3)</code>은 <code>fibonacci(2)</code>와 <code>fibonacci(1)</code> (첫 번째 호출)을 호출한다.</li>
	<li><code>fibonacci(2)</code>는 <code>fibonacci(1)</code> (두 번째 호출)과 <code>fibonacci(0)</code>을 호출한다.</li>
	<li>두 번째 호출한 <code>fibonacci(1)</code>은 1을 출력하고 1을 리턴한다.</li>
	<li><code>fibonacci(0)</code>은 0을 출력하고, 0을 리턴한다.</li>
	<li><code>fibonacci(2)</code>는 <code>fibonacci(1)</code>과 <code>fibonacci(0)</code>의 결과를 얻고, 1을 리턴한다.</li>
	<li>첫 번째 호출한 <code>fibonacci(1)</code>은 1을 출력하고, 1을 리턴한다.</li>
	<li><code>fibonacci(3)</code>은 <code>fibonacci(2)</code>와 <code>fibonacci(1)</code>의 결과를 얻고, 2를 리턴한다.</li>
</ul>

<p>1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, <code>fibonacci(N)</code>을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다.</p>

<p>각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.</p>

### 출력 

 <p>각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.</p>

# 회고

어제에 이어 DP에 대해 차근차근 다시 공부해보기로 했다.

가장 쉬운 문제처럼 보였는데 주어진 수에 따라 피보나치를 구하면 되는 문제라 재귀함수를 사용해 문제를 풀었다가 시간초과가 떴다.

고민을 하다 규칙을 찾기로 했고, 각 숫자를 표로 그린다음 0, 1이 몇 번 나오는지 세봤다. 해당 수의 전과 전전수의 출력을 합하면 되었다. 그래서 수 입력을 받기 전 문제에서 0~40이라고 정해져 있었기 때문에 미리 점화식을 사용해 만들어 주었다.

그리고 입력된 숫자를 통해 바로 찾을 수 있도록 했다.

처음엔 dp함수를 만들때 dp = [[]]*41로 했는데 정답은 맞았지만 값의 깊은복사가 문제라는 것을 알았다. 해당 문제는 상과없지만 다시 dp = [[] for _ in range(41)] 으로 다시 복기했다.

또 함수를 통해 깔끔히 점화식을 사용하려 했지만 간단한 부분은 함수에 바로 지정하는 게 빠르다고 한다.

제출했을 땐 둘 다 차이는 없었지만 나중에 빅데이터를 다룰 땐 중요한 부분이라 생각한다..
