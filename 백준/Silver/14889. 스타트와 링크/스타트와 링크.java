/**
 * 00:23
 * 축구를 하기위해 모인사람 N(짝수)
 * N/2명으로 이루어진 스타트팀과 링크팀으로 사람들을 나눠야 함
 * 1-N번으로 배정 후 각 능력치가 표로 주어짐
 * 스타트와 링크 팀의 능력치 합의 차이 최소 값을 출력
 *
 * 입력
 * N
 * N개의 줄에 능력치 표가 주어짐, 각 능력치는 1이상 100이하임
 *
 */

import java.io.*;
import java.util.*;
public class Main {

   static int N;
   static boolean[] visited;
   static int[][] matrix;
    static int rst = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        //능력치 입력받기
        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j < N;j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[N]; //방문처리 배열 생성
        dfs(0, 0);
        System.out.println(rst);

        br.close();
    }

    //팀을 구성 후 능력치 합산시작
    static void dfs(int idx, int count){
        if(count == N/2){ //팀 구성이 끝나면 합산시작
            cal();
            return;
        }

        for(int i=idx;i<N;i++){
            visited[i] = true; //방문처리
            dfs(i+1, count+1);
            visited[i] = false; //방문처리해제
        }
    }

    static void cal(){
        int start = 0, end = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){ //자기자신을 제외하고 짝을 이뤄야 함
                if(visited[i] && visited[j]) start += matrix[i][j] + matrix[j][i]; //스타트팀
                else if(!visited[i] && !visited[j]) end += matrix[i][j] + matrix[j][i]; //링크팀
            }
        }
        rst = Math.min(rst, Math.abs(start - end)); //최소 차이 계산
    }

}
