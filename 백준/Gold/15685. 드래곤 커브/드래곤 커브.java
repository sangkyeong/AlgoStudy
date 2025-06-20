/**
 * 드래곤 커브를 세가지 속성이 있음
 * 시작점, 시작방향, 세대
 * 0세대는 길이가 1인 선분
 *
 * 1세대는 0세대 선 끝점을 기준으로 시계방향으로 90도 회전해서 붙인 것
 * 끝점은 시작점에서 선분을 타고 이동 시 가장 먼 거리에 있는 점을 의미
 *
 * 2세대는  1세대의 끝점을 기준으로 똑같이 생성
 *
 * 3세대도 마찬가지
 *
 * 즉, k(k>1)세대 드래곤 커브는 k-1세대 드래곤 끝 커브를 끝점을 기준으로 90도 시계방향으로 회전한 다음
 * 이어 붙인 것
 *
 * 100x100위에 드래곤 커브가 n개가 있는데 1x1인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인
 * 정사각형의 개수를 출력
 *
 * 입력
 * 드래곤 커브개수 n
 * n개의 줄에 드래곤 커브가 주어짐(x, y, d, g)
 * x, y ->드래곤 커브의 시작 점
 * d는 시작방향 0 우, 1 상, 2 좌, 3 하
 * g는 세대
 */

import java.io.*;
import java.util.*;

public class Main {
    //우 상 좌 하
    static int[] xx = {1, 0, -1, 0};
    static int[] yy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] matrix = new int[101][101]; //초기 격자를 선언
        int count = 0;  // 최종 정사각형 개수
        for (int tc = 0; tc < N; tc++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());
            //드래곤 커브 만들기 함수
            curved(matrix, x, y, dir, generation);
        }

        //격자를 모두 돌며 네 꼭짓점이 1이면 정사각형이므로 카운트
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (matrix[i][j] == 1 && matrix[i][j+1] == 1 &&
                        matrix[i+1][j] == 1 && matrix[i+1][j+1] == 1)
                    count++;
            }
        }
        System.out.println(count);
        br.close();
    }

    static void curved(int[][] matrix, int x, int y, int dir, int generation){
        List<Integer> directions = new ArrayList<>();   //방향 기록용
        directions.add(dir);    //초기 방향을 넣어준다

        //가장 최근에 넣은 방향을 토대로 시계방향으로 90도 회전한 방향이 다음 방향이 된다.
        for(int i=0;i<generation;i++){
            int size = directions.size();
            for (int j = size - 1; j >= 0; j--) {
                int newDir = (directions.get(j) + 1) % 4;
                directions.add(newDir);
            }
        }

        List<int[]> points = new ArrayList<>(); //좌표 값 변화를 기록하기 위한 리스트
        int dx = x, dy = y; // 초기 값
        points.add(new int[]{dx, dy});

        //방향 리스트를 통해 좌표 값의 변화를 기록한다
        for(int idx:directions){
            dx += xx[idx];
            dy += yy[idx];
            points.add(new int[]{dx, dy});
        }

        //좌표 값을 토대로 격자 위에 1로 표시한다
        for (int[] p : points) {
            if (p[0] >= 0 && p[0] <= 100 && p[1] >= 0 && p[1] <= 100)
                matrix[p[1]][p[0]] = 1;
        }
    }
}
