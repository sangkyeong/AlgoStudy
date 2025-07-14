/**
 * 02:45
 * 무게가 서로 다른 물건 N개(1-N번)
 * 일부 물건 쌍에 대해 어떤 것이 무거운 것인지 측정한 결과표가 있음
 * 직접 측정하지 않은 물건 쌍의 비교 결과를 알아낼 수 도, 못 알 수 도 있음
 * 각 물건에 대해 그 물건과의 비교결과를 알 수 없는 물건의 개수를 출력
 *
 * 입력
 * 물건의 개수  5<= N<=100
 * 미리 측정된 물건쌍의 개수 0 <= M <= 2000
 * M개의 줄에 무게 측정결과가 주어짐. 앞이 뒤 물건보다 무거움
 *
 * 출력
 * N개의 줄에 i번째 줄에 물건 i와 비교결과를 알 수 없는 물건의 개수 출력
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        //대소관계를 알 수 있는 2차원 배열 생성(1부터 시작되니 +1)
        int[][] NUM = new int[N+1][N+1];
        // 모두 0으로 채운다
        for(int i=1;i<=N;i++) {
            for(int j =1;j<=N;j++) {
                NUM[i][j] = 0;
            }
        }

        // 입력받은 값 들을 넣는다
        //a>b면 1 아니면 -1을 넣는다
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            NUM[a][b] = 1;
            NUM[b][a] = -1;

        }

        //각 자리의 수를 비교해 값을 정리
        for (int k=1; k<=N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(NUM[i][k] == 1 && NUM[k][j] == 1) NUM[i][j] = 1;
                    if(NUM[i][k] == -1 && NUM[k][j] == -1) NUM[i][j] = -1;
                }
            }
        }
        
        //대소관계가 정리된 배열을 탐색
        //자기자신이 아닌 0이라면 관계가 없는 상태
        for(int i = 1;i<= N;i++){
            int rst = 0;
            for(int j = 1;j<= N;j++) {
                if(NUM[i][j] == 0 && i != j) rst++;
            }
            System.out.println(rst);
        }

        br.close();
    }

}