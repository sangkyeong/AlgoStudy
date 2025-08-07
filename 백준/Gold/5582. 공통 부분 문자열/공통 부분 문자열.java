/**
 * 두 문자열이 주어질 때 두 문자열에 모두 포함된 가장 긴 공통 부분 문자열의 길이 출력
 * 연속적인 문자열만 인정
 * 없으면 0 출력
 */
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split("");
		String[] b = br.readLine().split("");
		int aNum = a.length;
		int bNum = b.length;
		
		int[][] dp = new int[aNum][bNum];
		dp[0][0] = 0;
		
		int cnt = 0;
		
		for(int i = 0; i < aNum;i++) {
			for(int j = 0; j < bNum;j++) {
				if(a[i].equals(b[j])) {
					if(i > 0 && j > 0)
						dp[i][j] = dp[i-1][j-1] + 1;
					else
						dp[i][j] += 1;
				}
				cnt = Math.max(cnt, dp[i][j]);
			}
		}
		
		System.out.println(cnt);
		
		br.close();

	}

}