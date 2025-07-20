/**
 * N개의 정수가 주어질 때 X라는 정수가 존재하면 1, 아니면 0을 한줄씩 출력
 * 1 <= N, M <= 100000
 * 입력
 * N
 * N개의 줄에 걸쳐 숫자가 주어짐
 * M
 * M개의 수가 주어짐
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> nNum = new ArrayList<>();

        for(int i = 0;i<N;i++){
            nNum.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nNum);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] mNum = new int[M];

        for(int i = 0;i<M;i++){
            mNum[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i < M;i++){
            int rst = 0;
            int now = mNum[i];
            int firstIdx = 0;
            int lastIdx = nNum.size()-1;

            while(firstIdx <= lastIdx){
                int nowIdx = (firstIdx + lastIdx) / 2;
                int nowNNum = nNum.get(nowIdx);

                if(now == nowNNum){
                    rst = 1;
                    break;
                }

                if(now < nowNNum){
                    lastIdx = nowIdx -1;
                }else {
                    firstIdx = nowIdx +1;
                }
            }
            sb.append(rst).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
