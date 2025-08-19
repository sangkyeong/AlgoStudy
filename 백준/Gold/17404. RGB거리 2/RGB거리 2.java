/**
 * 02:30
 * RGB거리엔 집이 N개있음 거리는 선분으로 나타낼 수 있고 1-N번
 * 집은 빨 초 파 하나의 색으로 칠해야 함
 * 각각의 집을 칠했을 때 비용이 주어짐
 * 규칙을 만족하며 모든 집을 칠하는 비용의 최솟값 출력
 * 1. 1번 집의 색은 2번, N번 집의 색과 같지 않아야 함
 * 2. N번 집의 색은 N-1, 1번 집의 색과 같지 않아야 함
 * 3. i(2<= i <= N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 함
 *
 * 입력
 * 집의 수 N 2<= N <= 1000
 * N개의 줄에 걸쳐 빨 초 파 순으로 칠했을 때의 비용이 1번 집부터 주어짐, 비용 <= 1000
 * @author SSAFY
 *
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][3];
        int rst = Integer.MAX_VALUE;

        for(int tc = 0;tc < N ;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0;i < 3;i++) {
                matrix[tc][i] = Integer.parseInt(st.nextToken());
            }
        }

        for(int now=0;now<3;now++) {
            int[][] dp = new int[N][3]; //DP[i][color] : i번째 집을 color로 칠할 때 최소 비용
            //dp초기화
            for(int i=0;i < 3;i++){
                if(now == i) dp[0][i] = matrix[0][i];
                else dp[0][i] = 10000000;
            }

            //기준 집의 다음 줄 부터 시작
            for(int i=1;i < N;i++){
                dp[i][0] = matrix[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = matrix[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = matrix[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }

            // 마지막 색은 첫 집색이 아닌 색 중 최솟 값
            for(int last = 0;last < 3;last++){
                if(last == now) continue;
                rst = Math.min(rst, dp[N-1][last]);
            }

        }

        System.out.println(rst);

        br.close();
    }

}
