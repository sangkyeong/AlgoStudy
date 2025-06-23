/**
 * 정수 n이 주어질 때 1, 2, 3의 합으로 나타내는 방법의 수를 출력
 * 1, 2, 3 1개이상 사용해야 함
 * 합을 이루고 있는 수의 순서만 다른 건 같은 것으로 침
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] dp = new int[n+1];
            dp[0] = 1; // 합이 0인 경우는 1가지 (아무것도 안 더함)
            //1로 이루어질 때
            for (int i = 1; i <= n; i++) {
                if (i >= 1) dp[i] += dp[i-1]; // 1만 사용
            }

            //2로 이루어질 때
            for (int i = 2; i <= n; i++) {
                if (i >= 2) dp[i] += dp[i-2]; // 1과 2만 사용
            }

            //3으로 이루어질 때
            for (int i = 3; i <= n; i++) {
                if (i >= 3) dp[i] += dp[i-3]; //1, 2, 3 사용
            }
            System.out.println(dp[n]);
        }
        br.close();
    }
}
