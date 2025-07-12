import java.io.IOException;

/**
 * 00:29
 * 어떤 도화지에 그림이 있음
 * 그 그림의 개수와
 * 그 그림 넓이 중 넓이가 가장 넓은 것의 넓이를 출력
 * 그림은 1로 연결된 것을 한 그림으로 봄
 * 가로, 세로만 연결된 것으로 본다
 *
 * 입력
 * 세로, 가로 크기
 * 그림현황
 *
 * 출력
 * 그림의 개수
 * 가장 넓은 그림의 넓이
 */
import java.io.*;
import java.util.*;

public class Main {

    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, -1, 1};
    static int search(int i, int j, int row, int col, int[][] matrix, int[][] matrixPass){
        Queue<int[]> q = new LinkedList<>();
        int sub = 1; //그림의 넓이 파악 변수
        q.add(new int[]{i, j});
        matrixPass[i][j] = 1;

        while (!q.isEmpty()){
            int[] subList = q.poll();
            int a = subList[0], b = subList[1];
            //상, 하, 좌, 우를 탐색하며 연결된 그림인지 판별
            for(int idx=0;idx<x.length;idx++){
                int dx = a + x[idx];
                int dy = b + y[idx];
                if(0 > dx || row <= dx || 0 > dy || col <= dy || matrix[dx][dy] != 1 || matrixPass[dx][dy] == 1) continue;
                matrixPass[dx][dy] = 1;
                q.add(new int[]{dx, dy});
                sub++;
            }
        }
        return sub;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[row][col];
        int[][] matrixPass = new int[row][col];

        //그림현황 입력 받기, 방문처리 초기화
        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<col;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                matrixPass[i][j] = 0;
            }
        }

        int cnt = 0; // 그림의 개수
        int maxVal = 0; //가장 넓은 그림
        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //그림이 아닌 곳이나 방문한 적이 있다면 패스
                if(matrix[i][j] != 1 || matrixPass[i][j] == 1 ) continue;
                maxVal = Math.max(maxVal, search(i, j, row, col, matrix, matrixPass));
                cnt++;

            }
        }
        System.out.println(cnt + " " + maxVal);
        br.close();
    }
}
