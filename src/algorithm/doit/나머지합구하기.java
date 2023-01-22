package algorithm.doit;
//수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
//즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

import java.util.Scanner;

public class 나머지합구하기 {

	public static void main(String[] args) {
		// 입력 받을것!
		Scanner sc = new Scanner(System.in);
		// 배열의 개수 N
		System.out.println("배열 몇자리수?");
		int N = sc.nextInt();

		// 나누어 떨어져야 하는 수 M
		System.out.println("몇으로 나누어 떨어져야하는지?");
		int M = sc.nextInt();

		// 합배열 저장
		long[] S = new long[N];
		// 아까 배열의 개수를 몇개를 지정하겠다고 했으니까!
		// 그 값 만큼 배열의 길이를 만들기.

		// 합배열을 M으로 나눈 나머지 값 저장
		long[] C = new long[M];

		// 합배열 0번째는 그냥 입력한 값 저장
		System.out.println("합배열 0번째 값 입력");
		S[0] = sc.nextInt();

		// 이제 합배열에 0번째에는 첫번째 값이 있으니까
		// 1번째 배열부터 N번째 까지 돌면서 하나씩 합 배열을 만들기!
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + sc.nextInt();
		}
		// 이제 M값으로 나머지 연산을 수행하기!!!
		for (int i = 0; i < N; i++) {
			// 이제 0번째 부터 합배열 길이만큼 전체를 돌면서

			// M으로 나눴을때 나머지가 0이 될때
			int remainder = (int) (S[i] % M);
			if (remainder == 0) {
				// 카운트 배열에 같은 인덱스에 값을 증가시킨다.
				C[remainder]++;
			}
			// 이렇게 하면 같은수가 M으로 나눴을때 0이 된것이 많으면
			// [0]번째 인덱스에 ++되어 값이 저장되게 됩니다.
			// 나머지의 값은 나누는 값보다 클수 없기때문에
			// 다음 for문을 돌릴때 i의 값은 M 보다 클 수 없습니다.
		}
		long answer = 0;

		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {
				// 1보다 큰 이유는, 나눴을때 나머지가 0이나 1임을 제외하는것임.
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}
}
