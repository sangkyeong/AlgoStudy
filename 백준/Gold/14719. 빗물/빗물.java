/**
 * 01:11
 * 2차원세계에 블록이 쌓여있고 비가오면 블록사이에 빗물이 고임
 * 고이는 빗물의 총량 출력 한 칸은 1이고 고이지 않으면 0출력
 *
 * 입력
 * 세로 H 가로W
 * 블록이 쌓인 높이가 왼쪽부터 차례대로 W개 주어짐
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
        int[] block = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int scan=0;scan<W;scan++){
            block[scan] = Integer.parseInt(st.nextToken());
        }

        //오른쪽 최댓 값 배열 만들기
        int[] rightMax = new int[W];
        rightMax[W-1] = block[W-1]; //블록 끝을 먼저 입력
        for (int i = W-2; i >= 0; i--) {
            rightMax[i] = Math.max(block[i], rightMax[i+1]);    //오른쪽에서 차례대로 순회하며 탐색기준 최댓 값을 입력
        }

        // 왼쪽 최댓 값 배열 만들기
        int[] leftMax = new int[W];
        leftMax[0] = block[0];  //블록 첫번째부터 먼저 입력
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(block[i], leftMax[i-1]);  //왼쪽부터 차례대로 순회하며 탐색기준 최댓 값을 입력
        }
        int rst = 0;
        for (int i = 0; i < W; i++) {
            //빗물은 작은 블록기준으로 고이기 때문에 최댓 값 배열 중 작은 값을 고르고 탐색기준 높이 차를 구해 누적
            int water = Math.min(leftMax[i], rightMax[i]) - block[i];
            if (water > 0) rst += water;
        }

        System.out.println(rst);
    }
}
