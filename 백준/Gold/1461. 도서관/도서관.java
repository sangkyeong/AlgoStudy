/**
 * 도서관 정리
 * 현재 세준이는 0에 위치, 섞인 책도 0에 있음
 * 각 책들의 원래 위치가 주어질 때 책을 모두 제자리에 두는 최소 걸음 수 출력
 * 한 번에 최대 M권 들 수 있음
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> positiveLocation = new ArrayList<>();
		ArrayList<Integer> negativeLocation = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			if (now > 0) positiveLocation.add(now);
			else negativeLocation.add(now);
		}
		
		//위치 리스트를 음수와 양수로 분류하여 각각 정렬한다
		if (!positiveLocation.isEmpty()) positiveLocation.sort((a, b) -> b - a);
		if (!negativeLocation.isEmpty()) negativeLocation.sort((a, b) -> a - b);
		
		int total = 0;
		for(int i=0;i<positiveLocation.size();i += M) {
			int thisWay = Math.abs(positiveLocation.get(i));
			total += thisWay*2; //M개를 정리했으면 다시 0으로 돌아가 책을 가져와야 함
		}
		
		for(int i=0;i<negativeLocation.size();i += M) {
			int thisWay = Math.abs(negativeLocation.get(i));
			total += thisWay*2; //M개를 정리했으면 다시 0으로 돌아가 책을 가져와야 함
		}
			
		//가장 멀리 있는 책을 정리 후 다시 안돌아와도 됨
		int maxWay = 0;
		if(!positiveLocation.isEmpty()) maxWay = Math.max(positiveLocation.get(0), maxWay);
		if(!negativeLocation.isEmpty()) maxWay = Math.max(Math.abs(negativeLocation.get(0)), maxWay);
		total -= maxWay;
		
		System.out.println(total);
		
	}
}
