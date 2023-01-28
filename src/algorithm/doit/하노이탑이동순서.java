package algorithm.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑이동순서 {
	//출력의 경우는 StringBuilder 사용
	public static StringBuilder sb = new StringBuilder();

	//메인에서 재귀함수를 불러 사용할 예정
	public static void main(String[] args) throws IOException {
		 
		// N : 원판의 개수 , start : 출발지 1 , mid : 옮기기 위해 이동해야 장소 2 ,to : 목적지 3

		System.out.println("원판의 개수를 입력하시오");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		// 원판의 개수를 N에 저장
		int N = Integer.parseInt(br.readLine());
		//				제곱함수(2,N)-1 을 해줍니다
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');

		Hanoi(N, 1, 2, 3);
		System.out.println(sb);

	}

	public static void Hanoi(int N, int start, int mid, int to) {
		// 이동할 원반의 수가 1개라면?
		if (N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}

		// A -> C로 옮긴다고 가정할 떄,
		// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
		Hanoi(N - 1, start, to, mid);

		// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
		sb.append(start + " " + to + "\n");

		// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		Hanoi(N - 1, mid, start, to);

	}
}
