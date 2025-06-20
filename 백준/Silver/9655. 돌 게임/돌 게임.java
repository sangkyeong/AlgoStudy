/**
 * 00:32
 * 두명이 돌게임을 시작
 * 돌 n개
 * 번갈아가며 1개 - 3개를 가져갈 수 있음
 * 마지막 돌을 가져가는 사람이 이김
 * 이기는 사람을 출력 상근sk , 창영cy
 * 상근이가 먼저 시작
 *
 */

import java.io.*;

public class java250616_9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n % 2 == 1 ? "SK" : "CY");
        br.close();
    }
}
