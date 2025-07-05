/**
 *
 * 정수만 저장하는 이중우선순위 큐가 있다고 할 때
 * q에 저장된 각 정수의 값 자체를 우선순위라고 간주
 * q에 적용될 일련의 연산이 주어질 때 이를 처리 후 최종저장된 q의
 * 최댓값, 최솟값을 출력
 *
 * 입력
 * 테케수
 * 큐에 적용할 연산개수 k
 * k줄에 D/I와 정수가 주어짐
 * D -1는 최솟값 삭제  1은 최댓값 삭제
 * I는 삽입
 * 최댓값 최솟값이 둘 이상인 경우 하나만 삭제됨
 * 큐가 비어있다면 삭제 무시
 *
 *
 * 출력
 * 한 줄에 최댓값 최솟값
 * 비어있으면 EMPTY출력
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for(int tc=1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            int subT = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>();  //우선순위 오름차순
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());    //우선순위 내림차순
            Map<Integer, Integer> cnt = new HashMap<>();

            for(int subTc = 0;subTc<subT;subTc++){
                st = new StringTokenizer(br.readLine());
                String mode = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                //숫자 삽입명령
                if(mode.equals("I")) {
                    pq.add(num);
                    pq2.add(num);
                    cnt.put(num, cnt.getOrDefault(num, 0)+1);
                }
                //삭제 명령
                else if(mode.equals("D")){
                    if(cnt.isEmpty()) continue;
                    if(num == -1){
                        remove(pq, cnt);
                    }else{
                        remove(pq2, cnt);
                    }
                }
            }

            if(cnt.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else{
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int key : cnt.keySet()){
                    max = Math.max(max, key);
                    min = Math.min(min, key);
                }
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    static int remove(PriorityQueue<Integer> q, Map<Integer, Integer> cnt){
        while(!q.isEmpty()){
            int num = q.poll();
            if(cnt.containsKey(num)){
                cnt.put(num, cnt.get(num)-1);
                if(cnt.get(num)==0) cnt.remove(num); //0이 되면 없으니까 삭제
                return num;
            }
        }
        return 0;
    }
}
