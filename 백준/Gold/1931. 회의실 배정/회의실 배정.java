/**
 * n개의 회의실
 * 회의 i에 대해 시작시간, 종료시간이 주어짐
 * 회의가 겹치지 않고, 회의실을 사용할 수 있는 회의 최대 갯수 출력
 *
 * 회의는 중단되지 않고, 한 회의가 끝나면 다음 회의 바로 시작가능
 * 시작시간과 끝나는 시간이 같을 수 있음
 *
 * 입력
 * 1 <= N <= 100000
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<int[]> meetingTimes = new ArrayList<>();
        int rst = 0;

        for(int i = 0;i < N;i++ ) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingTimes.add(new int[] {start, end});
        }
        meetingTimes.sort((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        int maxEndTime = 0;

        //회의 끝나는 시간 기준 탐색
        for(int i=0;i<N;i++) {
            //탐색중인 시간이 뒷 시작시간보다 작거나 같아야 함
            if(meetingTimes.get(i)[0] < maxEndTime) continue;
            maxEndTime = meetingTimes.get(i)[1];
            rst++;
        }
        System.out.println(rst);

        br.close();
    }
}