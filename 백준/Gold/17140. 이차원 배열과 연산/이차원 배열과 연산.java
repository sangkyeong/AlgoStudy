/**
 * https://www.acmicpc.net/problem/17140
 *
 * 03:37
 *
 * 크기가 3x3인 배열이 있음 인덱스는 1부터 시작, 1초가 지날 때마다 배열에 연산이 적용
 * R연산 - 배열 A의 모든 행에 정렬 수행, 행의 개수 >= 열의 개수
 * C연산 - 배열 A의 모든 행의 정렬 수행, 행의 개수 < 열의 개수
 * 정렬하려면 각각 수가 몇 번 나왔는지 알아야 됨
 * 그 다음 수의 등장 횟수가 커지는 순으로,이게 여러가지면 수가 커지는 수 순으로 정렬
 * 배열A에 정렬된 결과를 다시 넣어야 됨
 * 배열에 넣을 때 수, 등장 횟수를 모두 넣고, 순서는 수가 먼저임
 * 행, 열이 크기가 100이 넘어가면 처음 100을 제외한 나머지는 버림
 * 배열a에 들어있는 수와 r, c, k가 주어질 때 A[r][c]에 들어있는 값이 k가 되기위한 최소시간 출력
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //처음부터 시작할 때 100x100
        int[][] matrix = new int[101][101];
        int TIME = 0;

        int sizeR = 3;
        int sizeC = 3;

        for(int i=1;i<4;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<4;j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (TIME <= 100) {
            if (matrix[R][C] == K) break;

            //행, 열 크기 비교 후 정렬 방향 선택
            if(sizeR >= sizeC) {
                int maxCol  = 0;
                for(int i = 1;i <= sizeR;i++) {
                    HashMap<Integer, Integer> m = new HashMap<>();
                    for(int j = 1;j <= sizeC;j++) {
                        if(matrix[i][j] == 0) continue;
                        m.put(matrix[i][j], m.getOrDefault(matrix[i][j], 0)+1);
                    }
                    ArrayList<int[]> mapList = new ArrayList<>();

                    for(int key : m.keySet()){
                        mapList.add(new int[]{key, m.get(key)});
                    }

                    mapList.sort((a, b) -> {
                        if (a[1] == b[1]) return a[0] - b[0];
                        return a[1] - b[1];
                    });

                    //배열에 적용
                    int idx = 1;
                    for (int[] pair : mapList) {
                        if (idx > 100) break;
                        matrix[i][idx++] = pair[0];
                        if (idx > 100) break;
                        matrix[i][idx++] = pair[1];
                    }

                    maxCol  = Math.max(maxCol , idx - 1); // 전체 행 중 가장 긴 길이로 갱신

                    // 남은 부분 0으로 초기화
                    for (; idx <= 100; idx++) matrix[i][idx] = 0;

                }
                sizeC  = maxCol  == 0 ? 1 : maxCol ; // 최소 1 이상 유지!
            }else {
                int maxRow  = 0;
                for(int j = 1;j <= sizeC;j++) {
                    HashMap<Integer, Integer> m = new HashMap<>();
                    for (int i = 1; i <= sizeR; i++) {
                        if (matrix[i][j] == 0) continue;
                        m.put(matrix[i][j], m.getOrDefault(matrix[i][j], 0) + 1);
                    }
                    ArrayList<int[]> mapList = new ArrayList<>();

                    for (int key : m.keySet()) {
                        mapList.add(new int[]{key, m.get(key)});
                    }

                    mapList.sort((a, b) -> {
                        if (a[1] == b[1]) return a[0] - b[0];
                        return a[1] - b[1];
                    });

                    //배열에 적용
                    int idx = 1;
                    for (int[] pair : mapList) {
                        if (idx > 100) break;
                        matrix[idx++][j] = pair[0];
                        if (idx > 100) break;
                        matrix[idx++][j] = pair[1];
                    }
                    maxRow  = Math.max(maxRow , idx - 1); // 전체 행 중 가장 긴 길이로 갱신

                    // 남은 부분 0으로 초기화
                    for (; idx <= 100; idx++) matrix[idx][j] = 0;

                }
                sizeR = maxRow  == 0 ? 1 : maxRow ; // 최소 1 이상 유지!
            }

            //1초 증가
            TIME++;
        }
        System.out.println(matrix[R][C] != K ? -1 : TIME );
        br.close();
    }
}