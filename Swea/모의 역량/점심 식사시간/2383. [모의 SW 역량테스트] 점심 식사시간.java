/**
 * 04:18
 * N*N 크기의 방 4 <= N <= 10
 * 1 <= 사람 수 <= 10
 * 점심을 먹기 위해 아래층으로 이동, 빠른 시간내에 내려가야함
 * 사람을 P 계단입구를 S(무조건 2개)라 할 때
 * - 계단 입구까지 이동 시간
 * |P세로위치-입구 세로 위치| - |p가로위치 -입구 가로위치|
 *
 * - 계단 내려가는 시간
 * 	- 계단을 내려가는 시간은 입구 부터 완전히 계단을 내려간 시간
 * 	- 계단 입구 도착 시 1분 후 내려갈 수 있음
 * 	- 계단 위에는 최대 3명까지만 올라갈 수 있음
 * 	- 이미 계단에 3명이 내려가는 경우 한 명이 완전히 내려갈 때 까지 입구에서 대기
 * 	- 계단마다 길이 K(2<= K <= 10)가 주어지고, 계단에 올라간 후 완전히 내려가는데 K분이 걸림
 *
 * 입력
 * 테케 수 T
 * N
 * N의 지도정보(1은 사람, 그 외는 입구(길이)
 *
 * @author SSAFY
 *
 */

import java.io.*;
import java.util.*;
public class java250820_swea2383 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int TC = 1;TC <= T;TC++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N]; //방정보
            int personCnt = 0; //사람 수
            ArrayList<int[]> person = new ArrayList<>(); //각 사람의 좌표
            ArrayList<int[]> door = new ArrayList<>(); //각 입구의 좌표

            //방정보 입력받고, 사람 수 파악 및 좌표 정리
            for(int i=0;i < N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j < N;j++) {
                    int now = Integer.parseInt(st.nextToken());
                    matrix[i][j] = now;
                    if(now == 1) {
                        person.add(new int[] {i, j});
                        personCnt++;
                    }else if(now >= 2) door.add(new int[] {i, j});
                }
            }

            int TIME = Integer.MAX_VALUE;

            int firstDoorX = door.get(0)[0]; //첫번째 계단 입구 X
            int firstDoorY = door.get(0)[1]; //첫번째 계단 입구 Y
            int secondDoorX = door.get(1)[0]; //두번째 계단 입구 X
            int secondDoorY = door.get(1)[1]; //두번째 계단 입구 Y

            for(int mask=0;mask < (1 << personCnt); mask++){ //두 계단을 이용하는 모든 조합 수 구하기
                //mask비트가 0인 사람은 첫번째 계단, 1인 사람은 두번째 계단으로 지정
                List<Integer> firstTimes = new ArrayList<>();
                List<Integer> secondTimes = new ArrayList<>();

                for(int i = 0; i < personCnt ; i++){
                    int[] personXY = person.get(i);
                    int first = Math.abs(personXY[0]-firstDoorX)+Math.abs(personXY[1]-firstDoorY); //첫번째 계단까지 이동시간
                    int second = Math.abs(personXY[0]-secondDoorX)+Math.abs(personXY[1]-secondDoorY); //두번째 계단까지 이동시간

                    if((mask & (1 << i)) == 0){ // 현재 선택된 사람이 계단 할당 여부에 따라 계단 배정
                        firstTimes.add(first);
                    }else{
                        secondTimes.add(second);
                    }
                }

                int simulationFirst = simulation(firstTimes, matrix[firstDoorX][firstDoorY]); // 첫번째 계단 이용자의 최대 이용시간
                int simulationSecond = simulation(secondTimes, matrix[secondDoorX][secondDoorY]);//두번째 계단 이용자의 최대 이용시간
                int total = Math.max(simulationFirst, simulationSecond);//둘 중 가장 늦게 내려간 시간이 현재 탐색 중인 조합의 계단 완료 시간이 됨

                TIME = Math.min(TIME, total); //최종 시간은 최소시간으로 갱신
            }

            sb.append("#").append(TC).append(" ").append(TIME).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static int simulation(List<Integer> times, int stairLang){
        if(times.size() == 0) return 0;
        Collections.sort(times);
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for(int arrival : times){
            int start = arrival + 1; //입구에 도착 후 1분 후에 계단 진입

            if(endTimes.size() < 3){
                endTimes.add(start + stairLang);
            }else{
                int earlyEnd = endTimes.poll();

                if(start < earlyEnd){
                    start = earlyEnd;
                }
                endTimes.add(start + stairLang);
            }

        }
        int maxtime = 0;
        while (!endTimes.isEmpty()){
            maxtime = Math.max(maxtime, endTimes.poll());
        }

        return maxtime;
    }

}
