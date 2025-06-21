/**
 * 03:22
 * 길이가 n인 컨베이어 벨트
 * 벨트의 길이는 2n
 * 벨트의 길이 1간격으로 2n개의 칸으로 나누어져 있고
 * 각 칸에는 1부터 2n까지 번호가 매겨져 있음
 * 벨트가 한 칸 회전 시 1~2n-1 까지 칸은 다음번호의 칸이 있는 위치로 이동
 * 2n번쨰 칸은 1번 칸으로 이동
 * i번 칸의 내구도는 A이다
 * 1번칸이 물건을 올리는 위치 n번이 내리는 위치
 * n번에 위치 시 즉시 물건을 내림
 * 로봇이 올려지거나 이동하는 칸은 내구도가 1 감소
 * 컨베이어를 이용해 로봇을 건너편으로 옮길예정
 *
 * 1. 벨트가 각 칸위에 있는 로봇과 함께 한 칸 회전
 * 2. 가장 먼저 올라간 로봇부터 회전하는 방향으로 한 칸 이동할 수 있으면 이동, 없으면 가만히 있음
 *  이동하려면 그 칸엔 로봇이 없어야 하고 내구도가 1이상
 * 3. 올리는 위치의 있는 칸 내구도가 0이 아니면 올리는 위치에 로봇을 올린다
 * 4. 내구도가 0인 칸의 개수가 k개 이상이면 종료, 그렇지 않으면 1번으로 돌아감
 *
 *  종료 시 몇 번째 단계가 진행중이었는지 출력
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] belt = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean[] robot = new boolean[N]; // 로봇 존재 여부

        int cnt = 0;
        while (true){
            // 벨트회전-로봇이동-로봇올리기 진행
            process(belt, robot, N);
            cnt++; // 카운트 +1

            // 0이 k개 인지 확인
            if(findZero(belt, K)) break;
        }
        System.out.println(cnt);
    }

    static void process(int[] belt, boolean[] robot, int N){
        //벨트회전
        int temp = belt[belt.length-1];
        for(int i = belt.length-1;i>0;i--){
            belt[i] = belt[i-1];
        }
        belt[0] = temp;

        for (int i = N-1; i > 0; i--) {
            robot[i] = robot[i-1];
        }
        robot[0] = false;
        if (robot[N-1]) robot[N-1] = false; // 내리는 위치 처리

        //로봇이동
        for (int i = N-2; i >= 0; i--) {
            if (robot[i] && !robot[i+1] && belt[i+1] > 0) {
                robot[i] = false;
                robot[i+1] = true;
                belt[i+1]--;
                if (i+1 == N-1) robot[i+1] = false; // 이동 후 내리는 위치
            }
        }

        //로봇올리기
        if(belt[0] > 0 && !robot[0]) {
            robot[0] = true;
            belt[0] -= 1;
        }

    }

    static boolean findZero(int[] belt, int K){
        int zero = 0;
        for(int b : belt){
            if(b == 0) zero++;
        }
        return zero >= K;
    }
}
