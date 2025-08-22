import java.io.*;
import java.util.*;

/**
02:51
 * RxC크기 표
 * 각 칸에는 지뢰가 있을 수도 없을 수도 있음
 * 지뢰를 누르면 게임오버
 * 지뢰가 없는 칸이면 변이 맞닿아 있거나 꼭지점이 맞닿아 있는 최대 8칸에 대해
 * 몇 개의 지뢰가 있는지 0-8사이 숫자로 표시
 * 0이라면 근처 8방향 지뢰가 없는 칸의 8방향도 표시
 * 지뢰는 *
 * 없으면 .
 * 클릭한 지뢰가 없는 칸은 c
 * 지뢰가 있는 칸을 제외한 다른 모든 칸의 숫자가 표시되려면 최소 몇 번의 클릭을 해야하는지 출력
 *
 *  입력
 * 테케수
 * N(NxN)
 * 지뢰현황
 */
public class java250704_swea1868 {
    static int[] X = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] Y = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String[][] matrix = new String[N][N];
            int[][] matrixPass = new int[N][N];

            for(int i=0;i<N;i++){
                matrix[i] = br.readLine().split("");
            }

            //완전탐색으로 지뢰개수 업데이트
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if (!matrix[i][j].equals(".")) continue;
                    search(matrix, N, i, j);
                }
            }

            //0주변이 0이면 확산(0그룹화)
            int zero = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if (matrix[i][j].equals("0") && matrixPass[i][j] != 1) {
                        zeroAway(matrixPass, matrix, i, j, N);
                        zero++;
                    }
                }
            }
						
						//0과 지뢰를 제외한 미방문지역 개수
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if (!matrix[i][j].equals("0") && !matrix[i][j].equals("*") && matrixPass[i][j] != 1) {
                        zero++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(zero).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void search(String[][] matrix, int N, int i, int j){
        int boom = 0;
        for(int idx=0;idx<X.length;idx++){
            int dx = i + X[idx];
            int dy = j + Y[idx];
            if(0 > dx || dx >= N || 0 > dy || dy >= N || !matrix[dx][dy].equals("*")) continue;
            boom += 1;
        }
        matrix[i][j] = String.valueOf(boom);
    }

    static void zeroAway(int[][] matrixPass, String[][] matrix, int i, int j, int N){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()){
            int[] nowQ = q.poll();
            int nowI = nowQ[0], nowJ = nowQ[1];

            for(int idx=0;idx<X.length;idx++){
                int dx = nowI + X[idx];
                int dy = nowJ + Y[idx];

                if (0 > dx || dx >= N || 0 > dy || dy >= N || matrix[dx][dy].equals("*") || matrixPass[dx][dy] == 1)
                    continue;
                matrixPass[dx][dy] = 1;
                if (matrix[dx][dy].equals("0"))
                    q.add(new int[]{dx, dy});
            }
        }
    }
}