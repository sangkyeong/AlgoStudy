/**
 * 0, 1로 이루어진 문자열 s
 * 특정범위를 뒤집어서 s에 있는 모든 숫자를 같게 만들 때
 * 최소 횟수를 출력
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> numMap = new HashMap<>();

        // 문자열을 모두 탐색해 그룹화 한다000->0
        // HashMap으로 그룹화 개수를 파악
        for (String s : br.readLine().split("")){
            if((list.isEmpty() && s.equals("0")) || (!list.isEmpty() && !list.get(list.size()-1).equals(Integer.parseInt(s)) && s.equals("0"))){
                list.add(0);
                numMap.put(0, numMap.getOrDefault(0,0)+1);
            }else if((list.isEmpty() && s.equals("1")) || (!list.isEmpty() && !list.get(list.size()-1).equals(Integer.parseInt(s)) && s.equals("1"))){
                list.add(1);
                numMap.put(1, numMap.getOrDefault(1,0)+1);
            }
        }
        //가장 작은 횟수를 출력
        if(numMap.size() == 1) System.out.println(0);
        else {
            int minCnt = Integer.MAX_VALUE;
            for (int num : numMap.values()) {
                if (minCnt > num) minCnt = num;
            }
            System.out.println(minCnt);
        }       
        br.close();
    }
}
