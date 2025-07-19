/**
 * A B로만 이루어진 두 문자열 S, T
 * S를 T로 바꿀 수 있으면 1 아니면 0출력
 * 1. 문자열 뒤에 A추가
 * 2. 문자열 뒤에 B를 추가하고 문자열을 뒤집는다
 * S길이 < T길이
 */

import java.io.*;
import java.util.*;
public class Main {
    static String S;
    static String T;
    static int rst = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        bfs(T);
        System.out.println(rst);
    }
    static void bfs(String word){
        Queue<String> q = new LinkedList<>();
        q.add(word);
        while(!q.isEmpty()){
            String qWord = q.poll();
            if(qWord.length() < S.length()) continue;
            if(qWord.equals(S)) {
                rst = 1;
                return;
            }

            if(qWord.endsWith("A")) {
                StringBuilder subA = new StringBuilder();
                subA.append(qWord).deleteCharAt(qWord.length()-1);
                q.add(String.valueOf(subA));
            }

            StringBuilder subB = new StringBuilder();
            subB.append(qWord);
            String b = String.valueOf(subB.reverse());
            if(b.endsWith("B")) {
                subB.deleteCharAt(qWord.length()-1);
                q.add(String.valueOf(subB));
            }
        }
    }
}
