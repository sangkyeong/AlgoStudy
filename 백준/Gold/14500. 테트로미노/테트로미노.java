import java.util.*;
import java.io.*;

public class Main {
    static int[][][] tetromino = {
        // 직선 (2가지)
        {{0,0}, {0,1}, {0,2}, {0,3}},
        {{0,0}, {1,0}, {2,0}, {3,0}},
        // 정사각형 (1가지)
        {{0,0}, {0,1}, {1,0}, {1,1}},
        // ㄱ자 (8가지)
        {{0,0}, {1,0}, {2,0}, {2,1}},
        {{0,0}, {0,1}, {0,2}, {1,0}},
        {{0,0}, {0,1}, {1,1}, {2,1}},
        {{0,0}, {0,1}, {0,2}, {1,2}},
        {{0,0}, {1,0}, {2,0}, {0,1}},
        {{0,0}, {1,0}, {1,1}, {1,2}},
        {{0,1}, {1,1}, {2,1}, {2,0}},
        {{0,2}, {1,2}, {1,1}, {1,0}},
        // 번개 (4가지)
        {{0,0}, {1,0}, {1,1}, {2,1}},
        {{0,1}, {1,0}, {1,1}, {2,0}},
        {{0,0}, {0,1}, {1,1}, {1,2}},
        {{0,1}, {0,2}, {1,0}, {1,1}},
        // ㅗ 모양 (4가지)
        {{0,0}, {0,1}, {0,2}, {1,1}},
        {{0,1}, {1,0}, {1,1}, {2,1}},
        {{0,0}, {1,0}, {1,1}, {2,0}},
        {{0,1}, {1,0}, {1,1}, {1,2}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[N][M];
            for(int i = 0;i<N;i++) {
                matrix[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int[][] shape : tetromino) {
                        int sum = 0;
                        boolean out = false;
                        for (int[] d : shape) {
                            int ni = i + d[0];
                            int nj = j + d[1];
                            if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                                out = true;
                                break;
                            }
                            sum += matrix[ni][nj];
                        }
                        if (!out) max = Math.max(max, sum);
                    }
                }
            }
            System.out.println(max);
        }

        br.close();
    }
}