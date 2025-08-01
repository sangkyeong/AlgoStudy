/**
 * 길이가 N인 수열이 주어짐 그 수열의 합을 구하려고 함
 * 수열의 두 수를 묶음, 위치에 상관없이 묶기 가능
 * 같은위치에 있는 자기자신은 묶는 건 불가
 * 그리고 어떤 수를 묶게되면 수열의 합을 구할 때 묶은 수는 서로 곱한 후 묶음
 * 수열의 모든 수는 한번만 묶거나 안 묶어야 함
 * 이 방식을 사용해 최대가 되는 수 출력
 *
 * 입력
 * 수열의 크기 N < 50
 * N개의 줄에 수열의 각 수가 주어짐
 * 수열의 수는 -1000 <= 수 <= 10000
 */

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] negative = new int[N];
        int[] positive = new int[N];
        int[] one = new int[N];

        int negativeIdx = 0;
        int oneIdx = 0;
        int zeroIdx = 0;
        int positiveIdx = 0;
        for(int tc = 0;tc < N;tc++){
            int now = Integer.parseInt(br.readLine().trim());

            if(now > 1){
                positive[positiveIdx] = now;
                positiveIdx++;
            }else if(now == 0){
                zeroIdx++;
            }else if(now == 1){
                one[oneIdx] = now;
                oneIdx++;
            }else{
                negative[negativeIdx] = now;
                negativeIdx++;
            }
        }

        int allNum = 0;
        // 정렬해서 차례대로 곱하고 합산
        Arrays.sort(positive, 0, positiveIdx);
        Arrays.sort(negative, 0, negativeIdx);
        if((positiveIdx > 0) && (positiveIdx % 2 == 0)){
            for (int i = positiveIdx-1; i > 0; i -= 2) {
                allNum += positive[i] * positive[i - 1];
            }
        }else if(positiveIdx > 0){
            if (positiveIdx > 1) {
                for (int i = positiveIdx-1; i > 0; i -= 2) {
                    allNum += positive[i] * positive[i - 1];
                }
                allNum += positive[0];
            }else{
                allNum += positive[0];
            }
        }

        for(int i = 0;i < oneIdx;i++){
            if(one[i] == 0) break;
            allNum += one[i];
        }

        //음수는 짝수개면 서로 곱해서 합산
        if((negativeIdx > 1) && (negativeIdx % 2 == 0)){
            for (int i = 0; i < negativeIdx -1; i += 2) {
                allNum += negative[i] * negative[i+1];
            }
        }else if(negativeIdx > 0){
            //홀수 개면 짝수 개 끼리는 곱한 후 합산
            // 마지막은 0이 있으면 0이랑 곱하고
            // 0이 없으면 그냥 더하기
            if (negativeIdx > 1) {

                for (int i = 0; i < negativeIdx-1; i += 2) {
                    allNum += negative[i] * negative[i + 1];
                }
            }

            if(zeroIdx == 0){
                allNum += negative[negativeIdx-1];
            }

        }

        System.out.println(allNum);
        br.close();
    }
}
